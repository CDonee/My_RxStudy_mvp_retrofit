package com.lide.my_rxstudy.Activity.bean.errorbean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DaiJiCheng
 * @time 2017/8/28  17:45
 * @desc ${TODD}
 */
public class ErrorBean {

    /**
     * clientIp : 192.168.8.250
     * error :
     * errorCode : BUSINESS_EXCEPTION
     * httpStatus : 400
     * message : 密码错误，请重试！
     */

    private String clientIp;
    private String error;
    private String errorCode;
    private int httpStatus;
    private String message;

    public static ErrorBean objectFromData(String str) {

        return new Gson().fromJson(str, ErrorBean.class);
    }

    public static List<ErrorBean> arrayErrorBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<ErrorBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
