package com.lide.my_rxstudy.Activity.model;

import com.lide.my_rxstudy.Activity.model.Imodel.ILoginMode;
import com.lide.my_rxstudy.Activity.net.RetrofitService;
import com.lide.my_rxstudy.Activity.net.ServicesApi;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import rx.Observable;

/**
 * @author DaiJiCheng
 * @time 2017/8/28  16:55
 * @desc ${TODD}
 */
public class LoginModelImpl implements ILoginMode{

    @Override
    public Observable<ResponseBody> login(RequestBody body) {

        return  RetrofitService.getInstance().createApi(ServicesApi.class).Login(body);
    }
}
