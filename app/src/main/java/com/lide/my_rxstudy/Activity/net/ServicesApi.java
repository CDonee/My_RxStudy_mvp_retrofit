package com.lide.my_rxstudy.Activity.net;


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

    @POST("jewel-api/api/security/login")
    Observable<ResponseBody> Login(@Body RequestBody loginReq);
}
