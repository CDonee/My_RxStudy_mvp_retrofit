package com.lide.my_rxstudy.Activity.model;

import com.lide.my_rxstudy.Activity.model.Imodel.IGetDevicesModel;
import com.lide.my_rxstudy.Activity.net.RetrofitService;
import com.lide.my_rxstudy.Activity.net.ServicesApi;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import rx.Observable;

/**
 * @author DaiJiCheng
 * @time 2017/10/17  9:38
 * @desc ${获取设备列表}
 */
public class GetDevicesImpl implements IGetDevicesModel {
    @Override
    public Observable<ResponseBody> getDevices(RequestBody requestBody) {
        return RetrofitService.getInstance().createApi(ServicesApi.class).GetDevice(requestBody);
    }
}
