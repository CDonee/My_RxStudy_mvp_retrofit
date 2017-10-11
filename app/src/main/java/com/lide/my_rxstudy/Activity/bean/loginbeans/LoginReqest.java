package com.lide.my_rxstudy.Activity.bean.loginbeans;

/**
 * @author DaiJiCheng
 * @time 2017/7/18  15:56
 * @desc ${TODD}
 */
public class LoginReqest {
    public String businessModuleCode;//	模块编码（系统模块，最顶级节点的模块编码）
    public String warehouseCode;//	仓库编码，用于判断当前登陆用户是否拥有仓库权限（非必要，如果不存该参数，则不校验）
    public String accountType;//帐户类型，员工：EMPLOYEE
    public String username;//帐户名称
    public String password;//帐户密码

    @Override
    public String toString() {
        return "LoginReqest{" +
                "businessModuleCode='" + businessModuleCode + '\'' +
                ", warehouseCode='" + warehouseCode + '\'' +
                ", accountType='" + accountType + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
