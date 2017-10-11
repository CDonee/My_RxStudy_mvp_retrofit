package com.lide.my_rxstudy.Activity.presenter;

import android.content.Context;
import android.util.Log;

import com.lide.my_rxstudy.Activity.bean.errorbean.ErrorBean;
import com.lide.my_rxstudy.Activity.model.Imodel.ILoginMode;
import com.lide.my_rxstudy.Activity.model.LoginModelImpl;
import com.lide.my_rxstudy.Activity.view.IloginView.IVieWloginFinish;

import java.io.IOException;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author DaiJiCheng
 * @time 2017/8/28  16:47
 * @desc ${TODD}
 */
public class LogingPresenter extends Presenter {

    private IVieWloginFinish mIVieWloginFinish;
    private ILoginMode mILoginMode;

    public LogingPresenter(Context context, IVieWloginFinish view) {
        super(context);
        this.mIVieWloginFinish = view;
        mILoginMode = new LoginModelImpl();
    }

    public void login(RequestBody body){
//        rxJavaExecuter.execute(
//                mILoginMode.login(body)
//                , updateRefreshCookMenuByIDSubscriber = new UpdateRefreshCookMenuByIDSubscriber()
//        );
        updateRefreshCookMenuByIDSubscriber = new UpdateRefreshCookMenuByIDSubscriber();
        mILoginMode.login(body).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(updateRefreshCookMenuByIDSubscriber);
    }


    @Override
    public void destroy() {
        if(updateRefreshCookMenuByIDSubscriber != null){
            updateRefreshCookMenuByIDSubscriber.unsubscribe();
        }
    }

    private UpdateRefreshCookMenuByIDSubscriber updateRefreshCookMenuByIDSubscriber;
    private class UpdateRefreshCookMenuByIDSubscriber extends Subscriber<ResponseBody> {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {   //地址设置错误时
            Log.i("test", "onFailure---dj->" + e.getMessage()); //onFailureHTTP 400

            if(e instanceof HttpException){
                ResponseBody body = ((HttpException) e).response().errorBody();//密码设置错误时
                try {
                 //   Log.i("test", "error--->" + body.string());   //I/test: error--->{"clientIp":"192.168.8.250","error":null,"errorCode":"BUSINESS_EXCEPTION","httpStatus":400,"message":"密码错误，请重试！"}
                    String  msg = body.string();
                    ErrorBean errorBean = ErrorBean.objectFromData(msg);

                    mIVieWloginFinish.LoginFinishFailer(errorBean.getMessage());
                } catch (IOException IOe) {
                    IOe.printStackTrace();
                }
            }
        }


        @Override
        public void onNext(ResponseBody responseBody) {//密码正确时
            try {
               // Log.i("test", "onResponse---right-->" + responseBody.string());  //onResponse--->"d1b10dc2-63a1-46c3-b44d-1e9def60b00d"
                String key = responseBody.string();
                mIVieWloginFinish.LoginFinishSuceess(key);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
