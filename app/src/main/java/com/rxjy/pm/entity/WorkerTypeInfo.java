package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by asus on 2018/6/22.
 */

public class WorkerTypeInfo {


    /**
     * body : [{"majorJobName":"瓦工","majorJob":"1"},{"majorJobName":"木工","majorJob":"2"},{"majorJobName":"油工","majorJob":"3"},{"majorJobName":"电工","majorJob":"4"},{"majorJobName":"暖通","majorJob":"5"},{"majorJobName":"焊工","majorJob":"6"},{"majorJobName":"壮工","majorJob":"7"},{"majorJobName":"安装","majorJob":"8"},{"majorJobName":"拆除","majorJob":"9"},{"majorJobName":"搬运","majorJob":"10"},{"majorJobName":"家具","majorJob":"11"},{"majorJobName":"弱电","majorJob":"12"},{"majorJobName":"水暖成品安装","majorJob":"13"},{"majorJobName":"电气成品安装","majorJob":"14"},{"majorJobName":"装饰成品安装","majorJob":"88"},{"majorJobName":"其他","majorJob":"100"},{"majorJobName":"水工","majorJob":"15"},{"majorJobName":"经理","majorJob":"16"},{"majorJobName":"监理","majorJob":"0"}]
     * statusCode : 1
     * statusMsg : success
     */

    private int statusCode;
    private String statusMsg;
    private List<BodyBean> body;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public List<BodyBean> getBody() {
        return body;
    }

    public void setBody(List<BodyBean> body) {
        this.body = body;
    }

    public static class BodyBean {
        /**
         * majorJobName : 瓦工
         * majorJob : 1
         */

        private String majorJobName;
        private String majorJob;

        public String getMajorJobName() {
            return majorJobName;
        }

        public void setMajorJobName(String majorJobName) {
            this.majorJobName = majorJobName;
        }

        public String getMajorJob() {
            return majorJob;
        }

        public void setMajorJob(String majorJob) {
            this.majorJob = majorJob;
        }
    }
}
