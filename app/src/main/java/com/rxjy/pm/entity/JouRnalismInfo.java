package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by AAA on 2018/3/19.
 */

public class JouRnalismInfo {


    /**
     * StatusCode : 0
     * StatusMsg : Success!
     * Body : {"topList":[{"spare1":"外人","id":976,"name":"瑞祥联盟：新模式 高起点 大平台","tid":255,"author":"李锋","did":20,"cover":"http://up.courseware.rx/sap/201803161607368699509.jpg","praise":24,"view":93,"releaseDate":"2018-03-16 16:08:16.0"},{"spare1":"外人","id":577,"name":"最好的，是下一个","tid":255,"author":"赵丽","did":20,"cover":"http://up.courseware.rx/sap/201709231544371383107.jpg","praise":9,"view":188,"releaseDate":"2017-09-23 16:45:27.0"},{"spare1":"外人","id":502,"name":"Hi!想带你回家！","tid":255,"author":"张敬","did":20,"cover":"http://up.courseware.rx/sap/201708251023230112428.png","praise":7,"view":227,"releaseDate":"2017-08-25 12:38:41.0"}],"list":[{"spare1":"外人","id":577,"name":"最好的，是下一个","tid":255,"author":"赵丽","did":20,"cover":"http://up.courseware.rx/sap/201709231544371383107.jpg","praise":9,"view":188,"releaseDate":"2017-09-23 16:45:27.0"},{"spare1":"外人","id":502,"name":"Hi!想带你回家！","tid":255,"author":"张敬","did":20,"cover":"http://up.courseware.rx/sap/201708251023230112428.png","praise":7,"view":227,"releaseDate":"2017-08-25 12:38:41.0"}]}
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
        private List<TopListBean> topList;
        private List<ListBean> list;

        public List<TopListBean> getTopList() {
            return topList;
        }

        public void setTopList(List<TopListBean> topList) {
            this.topList = topList;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class TopListBean {
            /**
             * spare1 : 外人
             * id : 976
             * name : 瑞祥联盟：新模式 高起点 大平台
             * tid : 255
             * author : 李锋
             * did : 20
             * cover : http://up.courseware.rx/sap/201803161607368699509.jpg
             * praise : 24
             * view : 93
             * releaseDate : 2018-03-16 16:08:16.0
             */

            private String spare1;
            private int id;
            private String name;
            private int tid;
            private String author;
            private int did;
            private String cover;
            private int praise;
            private int view;
            private String releaseDate;

            public String getSpare1() {
                return spare1;
            }

            public void setSpare1(String spare1) {
                this.spare1 = spare1;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getTid() {
                return tid;
            }

            public void setTid(int tid) {
                this.tid = tid;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public int getDid() {
                return did;
            }

            public void setDid(int did) {
                this.did = did;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public int getPraise() {
                return praise;
            }

            public void setPraise(int praise) {
                this.praise = praise;
            }

            public int getView() {
                return view;
            }

            public void setView(int view) {
                this.view = view;
            }

            public String getReleaseDate() {
                return releaseDate;
            }

            public void setReleaseDate(String releaseDate) {
                this.releaseDate = releaseDate;
            }
        }

        public static class ListBean {
            /**
             * spare1 : 外人
             * id : 577
             * name : 最好的，是下一个
             * tid : 255
             * author : 赵丽
             * did : 20
             * cover : http://up.courseware.rx/sap/201709231544371383107.jpg
             * praise : 9
             * view : 188
             * releaseDate : 2017-09-23 16:45:27.0
             */

            private String spare1;
            private int id;
            private String name;
            private int tid;
            private String author;
            private int did;
            private String cover;
            private int praise;
            private int view;
            private String releaseDate;

            public String getSpare1() {
                return spare1;
            }

            public void setSpare1(String spare1) {
                this.spare1 = spare1;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getTid() {
                return tid;
            }

            public void setTid(int tid) {
                this.tid = tid;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public int getDid() {
                return did;
            }

            public void setDid(int did) {
                this.did = did;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public int getPraise() {
                return praise;
            }

            public void setPraise(int praise) {
                this.praise = praise;
            }

            public int getView() {
                return view;
            }

            public void setView(int view) {
                this.view = view;
            }

            public String getReleaseDate() {
                return releaseDate;
            }

            public void setReleaseDate(String releaseDate) {
                this.releaseDate = releaseDate;
            }
        }
    }
}
