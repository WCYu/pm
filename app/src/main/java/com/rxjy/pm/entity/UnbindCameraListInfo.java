package com.rxjy.pm.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AAA on 2017/11/10.
 */

public class UnbindCameraListInfo {

    /**
     * StatusCode : 1
     * StatusMsg :
     * Body : [{"TotalCount":0,"InUseCount":0,"FreeCount":0,"inventoryCount":0,"equipmentno":"0021","EquipStatus":"异常","equipment_type":0,"equipment_typename":"摄像头"},{"TotalCount":0,"InUseCount":0,"FreeCount":0,"inventoryCount":0,"equipmentno":"0022","EquipStatus":"异常","equipment_type":0,"equipment_typename":"摄像头"},{"TotalCount":0,"InUseCount":0,"FreeCount":0,"inventoryCount":0,"equipmentno":"0023","EquipStatus":"异常","equipment_type":0,"equipment_typename":"摄像头"},{"TotalCount":0,"InUseCount":0,"FreeCount":0,"inventoryCount":0,"equipmentno":"0024","EquipStatus":"异常","equipment_type":0,"equipment_typename":"摄像头"},{"TotalCount":0,"InUseCount":0,"FreeCount":0,"inventoryCount":0,"equipmentno":"0025","EquipStatus":"异常","equipment_type":0,"equipment_typename":"摄像头"},{"TotalCount":0,"InUseCount":0,"FreeCount":0,"inventoryCount":0,"equipmentno":"0323","EquipStatus":"异常","equipment_type":0,"equipment_typename":"摄像头"}]
     */

    private int StatusCode;
    private String StatusMsg;
    private List<UnbindCameraInfo> Body;

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

    public List<UnbindCameraInfo> getBody() {
        return Body;
    }

    public void setBody(List<UnbindCameraInfo> Body) {
        this.Body = Body;
    }

    public static class UnbindCameraInfo implements Serializable {
        /**
         * TotalCount : 0
         * InUseCount : 0
         * FreeCount : 0
         * inventoryCount : 0
         * equipmentno : 0021
         * EquipStatus : 异常
         * equipment_type : 0
         * equipment_typename : 摄像头
         */

        private int TotalCount;
        private int InUseCount;
        private int FreeCount;
        private int inventoryCount;
        private String equipmentno;
        private String EquipStatus;
        private int equipment_type;
        private String equipment_typename;

        public int getTotalCount() {
            return TotalCount;
        }

        public void setTotalCount(int TotalCount) {
            this.TotalCount = TotalCount;
        }

        public int getInUseCount() {
            return InUseCount;
        }

        public void setInUseCount(int InUseCount) {
            this.InUseCount = InUseCount;
        }

        public int getFreeCount() {
            return FreeCount;
        }

        public void setFreeCount(int FreeCount) {
            this.FreeCount = FreeCount;
        }

        public int getInventoryCount() {
            return inventoryCount;
        }

        public void setInventoryCount(int inventoryCount) {
            this.inventoryCount = inventoryCount;
        }

        public String getEquipmentno() {
            return equipmentno;
        }

        public void setEquipmentno(String equipmentno) {
            this.equipmentno = equipmentno;
        }

        public String getEquipStatus() {
            return EquipStatus;
        }

        public void setEquipStatus(String EquipStatus) {
            this.EquipStatus = EquipStatus;
        }

        public int getEquipment_type() {
            return equipment_type;
        }

        public void setEquipment_type(int equipment_type) {
            this.equipment_type = equipment_type;
        }

        public String getEquipment_typename() {
            return equipment_typename;
        }

        public void setEquipment_typename(String equipment_typename) {
            this.equipment_typename = equipment_typename;
        }
    }
}
