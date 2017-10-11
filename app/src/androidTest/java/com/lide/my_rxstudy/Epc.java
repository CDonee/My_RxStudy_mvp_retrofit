package com.lide.my_rxstudy;

/**
 * @author DaiJiCheng
 * @time 2017/3/27  11:33
 * @desc ${epc 封装类}
 */
public class Epc {
    public String shopCode;//	门店编码
    public String sku;//商品编码
    public String epc;//Epc编码
    public String deviceId;    //设备号
    public String startDate;//试衣开始日期（YYYY-MM-DD HH:mm:ss）
    public String endDate;//试衣结束日期（YYYY-MM-DD HH:mm:ss）

    public int LeftTime;  //提交前剩余时间
    public long StartToMath;  //提交前剩余时间


    public Epc(String shopCode, String sku, String epc, String deviceId, String startDate, String endDate) {
        this.shopCode = shopCode;
        this.sku = sku;
        this.epc = epc;
        this.deviceId = deviceId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Epc() {
    }

    public int getLeftTime() {
        return LeftTime;
    }

    public void setLeftTime(int leftTime) {
        LeftTime = leftTime;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getEpc() {
        return epc;
    }

    public void setEpc(String epc) {
        this.epc = epc;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Epc{" +
                "shopCode='" + shopCode + '\'' +
                ", sku='" + sku + '\'' +
                ", epc='" + epc + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", LeftTime="+LeftTime+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Epc))
            return false;

        Epc epc1 = (Epc) o;

        return getEpc().equals(epc1.getEpc());

    }

    @Override
    public int hashCode() {
        return getEpc().hashCode();
    }
}
