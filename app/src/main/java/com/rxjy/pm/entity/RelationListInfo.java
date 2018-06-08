package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by AAA on 2018/2/1.
 */

public class RelationListInfo {

    /**
     * StatusCode : 1
     * StatusMsg : 查询成功
     * Body : [{"Key":"0","Relation":"父亲"},{"Key":"1","Relation":"母亲"},{"Key":"2","Relation":"配偶"},{"Key":"3","Relation":"子女"}]
     */

    private int StatusCode;
    private String StatusMsg;
    private List<RelationInfo> Body;

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

    public List<RelationInfo> getBody() {
        return Body;
    }

    public void setBody(List<RelationInfo> Body) {
        this.Body = Body;
    }

    public static class RelationInfo {
        /**
         * Key : 0
         * Relation : 父亲
         */

        private String Key;
        private String Relation;

        public String getKey() {
            return Key;
        }

        public void setKey(String Key) {
            this.Key = Key;
        }

        public String getRelation() {
            return Relation;
        }

        public void setRelation(String Relation) {
            this.Relation = Relation;
        }
    }
}
