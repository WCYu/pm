package com.rxjy.pm.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/5/11.
 */
public class ProcessInfo {

    private int StatusCode;
    private String StatusMsg;

    private List<ProcessGroup> Body;

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

    public List<ProcessGroup> getBody() {
        return Body;
    }

    public void setBody(List<ProcessGroup> Body) {
        this.Body = Body;
    }

    public static class ProcessGroup {
        private int process_id;
        private String process_name;
        private int NoCount;
        private int Status;

        private List<ProcessChild> list;

        public int getProcess_id() {
            return process_id;
        }

        public void setProcess_id(int process_id) {
            this.process_id = process_id;
        }

        public String getProcess_name() {
            return process_name;
        }

        public void setProcess_name(String process_name) {
            this.process_name = process_name;
        }

        public int getNoCount() {
            return NoCount;
        }

        public void setNoCount(int NoCount) {
            this.NoCount = NoCount;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public List<ProcessChild> getList() {
            return list;
        }

        public void setList(List<ProcessChild> list) {
            this.list = list;
        }

        public static class ProcessChild {
            private int process_id;
            private String process_name;
            private int NoCount;
            private int Status;

            public int getProcess_id() {
                return process_id;
            }

            public void setProcess_id(int process_id) {
                this.process_id = process_id;
            }

            public String getProcess_name() {
                return process_name;
            }

            public void setProcess_name(String process_name) {
                this.process_name = process_name;
            }

            public int getNoCount() {
                return NoCount;
            }

            public void setNoCount(int NoCount) {
                this.NoCount = NoCount;
            }

            public int getStatus() {
                return Status;
            }

            public void setStatus(int Status) {
                this.Status = Status;
            }
        }
    }
}
