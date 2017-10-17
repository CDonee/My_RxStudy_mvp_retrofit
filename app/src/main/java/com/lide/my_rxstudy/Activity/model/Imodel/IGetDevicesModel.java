package com.lide.my_rxstudy.Activity.model.Imodel;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import rx.Observable;

/**
 * @author DaiJiCheng
 * @time 2017/10/17  9:36
 * @desc ${获取设备列表}
 */
public interface IGetDevicesModel {

     Observable<ResponseBody> getDevices(RequestBody requestBody);
}
