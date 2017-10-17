package com.lide.my_rxstudy.Activity.view.IloginView;

import com.lide.my_rxstudy.Activity.bean.GetDevices.GetDeviceResp;

/**
 * @author DaiJiCheng
 * @time 2017/8/28  16:16
 * @desc ${TODD}
 */
public interface IViewGetDevices {

    void getDeviceSuceess(GetDeviceResp key);
    void getDevicesFalier(String errMsg);
}
