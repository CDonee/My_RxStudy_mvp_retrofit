package com.lide.my_rxstudy.Activity.bean.GetDevices;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DaiJiCheng
 * @time 2017/10/17  11:09
 * @desc ${TODD}
 */
public class GetDeviceResp {

    /**
     * currentPage : 1
     * data : [{"code":"TEST01","created":"2017-06-20 09:46:22.737","description":null,"deviceType":"PACKAGING_DESK","deviceTypeName":"打包平台","disable":false,"id":"D178361D-D1A3-4ABB-B5D3-61571568C375","modified":"2017-06-20 09:53:22.213","name":"TEST01","readerIds":["E7437C70-40A1-46E0-AFAA-E25CE15CCB8D"],"version":2},{"code":"001","created":"2017-07-21 14:02:14.463","description":null,"deviceType":"HAND_SET","deviceTypeName":"手持机","disable":false,"id":"D62B532F-62B3-4D76-ABFC-250DE7739E68","modified":"2017-07-21 14:02:14.463","name":"001_test","readerIds":[],"version":1}]
     * hasNext : false
     * recordsPerPage : 20
     * totalPages : 1
     * totalRecords : 2
     */

    private int currentPage;
    private boolean hasNext;
    private int recordsPerPage;
    private int totalPages;
    private int totalRecords;
    /**
     * code : TEST01
     * created : 2017-06-20 09:46:22.737
     * description : null
     * deviceType : PACKAGING_DESK
     * deviceTypeName : 打包平台
     * disable : false
     * id : D178361D-D1A3-4ABB-B5D3-61571568C375
     * modified : 2017-06-20 09:53:22.213
     * name : TEST01
     * readerIds : ["E7437C70-40A1-46E0-AFAA-E25CE15CCB8D"]
     * version : 2
     */

    private List<DataBean> data;

    public static GetDeviceResp objectFromData(String str) {

        return new Gson().fromJson(str, GetDeviceResp.class);
    }

    public static List<GetDeviceResp> arrayGetDeviceRespFromData(String str) {

        Type listType = new TypeToken<ArrayList<GetDeviceResp>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public int getRecordsPerPage() {
        return recordsPerPage;
    }

    public void setRecordsPerPage(int recordsPerPage) {
        this.recordsPerPage = recordsPerPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String code;
        private String created;
        private Object description;
        private String deviceType;
        private String deviceTypeName;
        private boolean disable;
        private String id;
        private String modified;
        private String name;
        private int version;
        private List<String> readerIds;

        @Override
        public String toString() {
            return "DataBean{" +
                    "code='" + code + '\'' +
                    ", created='" + created + '\'' +
                    ", description=" + description +
                    ", deviceType='" + deviceType + '\'' +
                    ", deviceTypeName='" + deviceTypeName + '\'' +
                    ", disable=" + disable +
                    ", id='" + id + '\'' +
                    ", modified='" + modified + '\'' +
                    ", name='" + name + '\'' +
                    ", version=" + version +
                    ", readerIds=" + readerIds +
                    '}';
        }

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public static List<DataBean> arrayDataBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<DataBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public String getDeviceType() {
            return deviceType;
        }

        public void setDeviceType(String deviceType) {
            this.deviceType = deviceType;
        }

        public String getDeviceTypeName() {
            return deviceTypeName;
        }

        public void setDeviceTypeName(String deviceTypeName) {
            this.deviceTypeName = deviceTypeName;
        }

        public boolean isDisable() {
            return disable;
        }

        public void setDisable(boolean disable) {
            this.disable = disable;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getModified() {
            return modified;
        }

        public void setModified(String modified) {
            this.modified = modified;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public List<String> getReaderIds() {
            return readerIds;
        }

        public void setReaderIds(List<String> readerIds) {
            this.readerIds = readerIds;
        }
    }
}
