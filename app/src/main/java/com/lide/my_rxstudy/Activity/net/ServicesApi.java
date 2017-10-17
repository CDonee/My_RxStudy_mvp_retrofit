package com.lide.my_rxstudy.Activity.net;


import com.lide.my_rxstudy.Activity.global.Constants;

import app.MyApp;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * @author DaiJiCheng
 * @time 2017/8/28  16:22
 * @desc ${TODD}
 */
public interface ServicesApi {
   public  MyApp mApp = new MyApp();


    /**
     * 登录
     *
     * @param loginReq
     * @return
     */
    @POST(Constants.LOGIN_URL)
    Observable<ResponseBody> Login(@Body RequestBody loginReq);

    /**
     * 获取设备列表
     *
     * @param getDevicesReq
     * @return
     */
   // @Headers({"authorization:APP_KEYS "})
    @POST(Constants.GET_DEVICE_URL)
    Observable<ResponseBody> GetDevice(@Body RequestBody getDevicesReq);


}
