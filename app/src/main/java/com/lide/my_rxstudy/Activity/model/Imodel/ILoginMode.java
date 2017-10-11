package com.lide.my_rxstudy.Activity.model.Imodel;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import rx.Observable;

/**
 * @author DaiJiCheng
 * @time 2017/8/28  16:53
 * @desc ${TODD}
 */
public interface ILoginMode {
   Observable<ResponseBody> login(RequestBody body);
}
