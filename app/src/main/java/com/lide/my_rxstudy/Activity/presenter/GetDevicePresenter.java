package com.lide.my_rxstudy.Activity.presenter;

import android.content.Context;

import com.lide.my_rxstudy.Activity.bean.GetDevices.GetDeviceResp;
import com.lide.my_rxstudy.Activity.bean.errorbean.ErrorBean;
import com.lide.my_rxstudy.Activity.model.GetDevicesImpl;
import com.lide.my_rxstudy.Activity.model.Imodel.IGetDevicesModel;
import com.lide.my_rxstudy.Activity.view.IloginView.IViewGetDevices;

import java.io.IOException;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author DaiJiCheng
 * @time 2017/10/17  10:54
 * @desc ${TODD}
 */
public class GetDevicePresenter extends Presenter {
    private IGetDevicesModel mModel;
    private IViewGetDevices mIView;
    private DevicesSbuscribe mDevicesSbuscribe;

    public GetDevicePresenter(Context contest, IViewGetDevices view) {
        super(contest);
        this.mModel = new GetDevicesImpl();
        this.mIView = view;
    }


    @Override
    public void destroy() {
           if(mDevicesSbuscribe != null){
                mDevicesSbuscribe.unsubscribe();
           }
    }

    public void getDevices(RequestBody body) {
        mDevicesSbuscribe = new DevicesSbuscribe();
        mModel.getDevices(body).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mDevicesSbuscribe);
    }

    class DevicesSbuscribe extends Subscriber<ResponseBody> {

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            if (e instanceof HttpException) {
                ResponseBody body = ((HttpException) e).response().errorBody();//密码设置错误时
                try {
                    //   Log.i("test", "error--->" + body.string());   //I/test: error--->{"clientIp":"192.168.8.250","error":null,"errorCode":"BUSINESS_EXCEPTION","httpStatus":400,"message":"密码错误，请重试！"}
                    String msg = body.string();
                    ErrorBean errorBean = ErrorBean.objectFromData(msg);

                    mIView.getDevicesFalier(errorBean.getMessage());
                } catch (IOException IOe) {
                    IOe.printStackTrace();
                }
            }
        }

        @Override
        public void onNext(ResponseBody responseBody) {

            try {
                // Log.i("test", "onResponse---right-->" + responseBody.string());  //onResponse--->"d1b10dc2-63a1-46c3-b44d-1e9def60b00d"
                String json = responseBody.string();
                GetDeviceResp getDeviceResp = GetDeviceResp.objectFromData(json);
                mIView.getDeviceSuceess(getDeviceResp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
