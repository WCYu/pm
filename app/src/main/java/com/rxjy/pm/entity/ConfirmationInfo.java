package com.rxjy.pm.entity;

/**
 * Created by asus on 2018/4/26.
 */

public class ConfirmationInfo {


    /**
     * StatusCode : 1
     * StatusMsg : success
     * Body : {"proname":"撒旦法办公装修工程","proaddr":"会根据","proarea":122,"protype":"办公-网络公司","construction_time":"-","ProbablyAddr":"-","verbal_promise":"物业要求：100;口头承诺：100","construction_period":30,"PushMoney":11,"part_a_chief":"未","part_a_chief_mobile":"18911005532","designer_username":"刘景玉","designer_mobile":"18629245957","supervisor_username":"柳瑞锋","supervisor_mobile":"13571820216"}
     */

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int StatusCode) {
        this.StatusCode = StatusCode;
    }

    public String getStatusMsg() {
        return StatusMsg;
    }

    public void setStatusMsg(String StatusMsg) {
        this.StatusMsg = StatusMsg;
    }

    public BodyBean getBody() {
        return Body;
    }

    public void setBody(BodyBean Body) {
        this.Body = Body;
    }

    public static class BodyBean {
        /**
         * proname : 撒旦法办公装修工程
         * proaddr : 会根据
         * proarea : 122.0
         * protype : 办公-网络公司
         * construction_time : -
         * ProbablyAddr : -
         * verbal_promise : 物业要求：100;口头承诺：100
         * construction_period : 30
         * PushMoney : 11.0
         * part_a_chief : 未
         * part_a_chief_mobile : 18911005532
         * designer_username : 刘景玉
         * designer_mobile : 18629245957
         * supervisor_username : 柳瑞锋
         * supervisor_mobile : 13571820216
         */

        private String proname;
        private String proaddr;
        private double proarea;
        private String protype;
        private String construction_time;
        private String ProbablyAddr;
        private String verbal_promise;
        private int construction_period;
        private double PushMoney;
        private String part_a_chief;
        private String part_a_chief_mobile;
        private String designer_username;
        private String designer_mobile;
        private String supervisor_username;
        private String supervisor_mobile;

        public String getProname() {
            return proname;
        }

        public void setProname(String proname) {
            this.proname = proname;
        }

        public String getProaddr() {
            return proaddr;
        }

        public void setProaddr(String proaddr) {
            this.proaddr = proaddr;
        }

        public double getProarea() {
            return proarea;
        }

        public void setProarea(double proarea) {
            this.proarea = proarea;
        }

        public String getProtype() {
            return protype;
        }

        public void setProtype(String protype) {
            this.protype = protype;
        }

        public String getConstruction_time() {
            return construction_time;
        }

        public void setConstruction_time(String construction_time) {
            this.construction_time = construction_time;
        }

        public String getProbablyAddr() {
            return ProbablyAddr;
        }

        public void setProbablyAddr(String ProbablyAddr) {
            this.ProbablyAddr = ProbablyAddr;
        }

        public String getVerbal_promise() {
            return verbal_promise;
        }

        public void setVerbal_promise(String verbal_promise) {
            this.verbal_promise = verbal_promise;
        }

        public int getConstruction_period() {
            return construction_period;
        }

        public void setConstruction_period(int construction_period) {
            this.construction_period = construction_period;
        }

        public double getPushMoney() {
            return PushMoney;
        }

        public void setPushMoney(double PushMoney) {
            this.PushMoney = PushMoney;
        }

        public String getPart_a_chief() {
            return part_a_chief;
        }

        public void setPart_a_chief(String part_a_chief) {
            this.part_a_chief = part_a_chief;
        }

        public String getPart_a_chief_mobile() {
            return part_a_chief_mobile;
        }

        public void setPart_a_chief_mobile(String part_a_chief_mobile) {
            this.part_a_chief_mobile = part_a_chief_mobile;
        }

        public String getDesigner_username() {
            return designer_username;
        }

        public void setDesigner_username(String designer_username) {
            this.designer_username = designer_username;
        }

        public String getDesigner_mobile() {
            return designer_mobile;
        }

        public void setDesigner_mobile(String designer_mobile) {
            this.designer_mobile = designer_mobile;
        }

        public String getSupervisor_username() {
            return supervisor_username;
        }

        public void setSupervisor_username(String supervisor_username) {
            this.supervisor_username = supervisor_username;
        }

        public String getSupervisor_mobile() {
            return supervisor_mobile;
        }

        public void setSupervisor_mobile(String supervisor_mobile) {
            this.supervisor_mobile = supervisor_mobile;
        }
    }
}
