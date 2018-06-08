package com.rxjy.pm.entity;

/**
 * Created by AAA on 2017/8/28.
 */

public class PmUserInfo {


    /**
     * StatusCode : 1
     * StatusMsg : 获取信息成功
     * Body : {"JOne":0,"JTwo":0,"JThree":0,"z_one":0,"z_two":0,"z_three":0,"z_four":0,"z_five":0,"z_six":0,"z_oneTime":"0001-01-01T00:00:00","z_twoTime":"0001-01-01T00:00:00","z_threeTime":"0001-01-01T00:00:00","z_fourTime":"0001-01-01T00:00:00","z_fiveTime":"0001-01-01T00:00:00","z_sixTime":"0001-01-01T00:00:00","z_one_remark":null,"z_two_remark":null,"z_three_remark":null,"z_four_remark":null,"z_five_remark":null,"z_six_remark":null,"PmUserinfoEstimate":null,"uid":390,"user_no":null,"user_type":1,"major":1,"contract_type":1,"user_name":"李老师","user_level":2,"user_level_next":3,"temp_original_level":0,"temp_level_deadline":"9999-12-31T23:59:59.997","quality_level":0,"sex":1,"nation":1,"birthday":"1993-02-01T00:00:00","mobile":"13132103766","marital_status":2,"now_address":"东丽区津滨大道雪莲桥嘉春园15栋1-401室","self_job":1,"referrer":null,"idcard":"2302081987118604123","user_height":0,"emergency_relation":0,"emergency_name":"15146579885","emergency_mobile":"13165487894","register_place":"安徽省安庆市枞阳县钱桥镇大塘村李黄组","bank_account_name":"李光旺","bank_account":"62122603020185067123","bank_type":1,"bank_address":"工商银行东丽区东城家园支行00","induction_date":"2016-06-13T15:11:18","leaving_date":"0001-01-01T00:00:00","induction_area":19,"education":3,"education_history":null,"education_certificate":null,"login_account":"TJ005","login_passpord":"941018","worker_num":0,"worker_leader_num":2,"worker_year":7,"lead_team_year":2,"pro_max_Name":"老姑砂锅","pro_max_address":"八里台桥下底商","pro_max_area":"600","pro_type":3,"customer_pro_type":0,"pro_max_money":4,"can_visit":1,"known_way":2,"first_impression":"非常好","last_leaving_reason":null,"comp_name":null,"comp_register_money":0,"comp_register_date":null,"comp_address":null,"comp_business_license":null,"comp_tax_id":null,"comp_legal_person":null,"comp_legal_cardno":null,"comp_legal_mobile":null,"comp_legal_person_email":null,"comp_bank_account":null,"comp_bank_type":0,"deposit_cash":55293.5,"deposit_back_state":0,"deposit_expect_back_date":null,"deposit_actual_back_date":null,"leaving_reason":null,"leaving_time":"0001-01-01T00:00:00","is_blacklist":0,"pro_test_count":2,"user_state":2,"ApproveDesc":null,"TemporaryDesc":null,"OfficialDesc":null,"MsgState":2,"StageState":2,"user_state_name":"正式","is_freeze":2,"photo_server_url":"http://img9.rxjy.com:80/image/","photo_file_url":"0C8FwKgBtFqvLkyAAz5ZAADsdRSjPow092.jpg","photo_checkstate":0,"photo_art_checkstate":0,"createtime":"2017-06-09T09:03:10.107","createuser":null,"updatetime":"2018-04-12T10:01:11.33","updateuser":null,"P_Trait":null,"TrainingDate":null,"GG_level":null,"group_isOk":1,"is_guiDang":1,"orderCountnew":0,"photo_art_server_url":"http://img9.rxjy.com:80/image/","photo_art_file_url":"0C39wKgBtFqiBTWAPswXAAASWn6OmF4474.png","achievement_level":0,"user_tag":"","app_cardNo":null,"starlevel":3,"paid_type":0,"comp_bank_account_name":null,"counselorLevel":0,"syntheticGrade":3,"tempSyntheticGrade":0,"StatisticsEntity":null,"AttrTime":"0001-01-01T00:00:00","VisitTime":null,"VisitMark":0,"orderCount":0,"sum_actual_money":0,"sum_contract_fee":0,"Total_FinesTime":0,"Total_Fines":0,"tud_flow":0,"RowID":0,"Time1":"0001-01-01T00:00:00","Time2":"0001-01-01T00:00:00","MonthOrdersCount":0,"MeetOrdersCount":0,"MeetOrdersMoney":0,"ConstructionCount":0,"FinishCount":0,"AuditScore":0,"ConstructionMoney":0,"ExtensionCount":0,"ExtensionAbnormalCount":0,"CompletedCount":0,"CompletedMoney":0,"HistoryCompletedCount":0,"HistoryCompletedMoney":0,"HistoryCount":0,"WorkorderMoney":0,"NotsettledMoney":0,"PerformanceMoney":0,"FinishPublishMoney":0,"Pro_Score":0,"Construction_Quality":0,"Project_Process":0,"Security_Image":0,"Environmental_Health":0,"Material_Quality":0,"counselorLevelName":null,"attrInfos":null,"projectCount":0,"orderList":null,"isSubmit":false,"artPhotoUrl":null,"auditScoreAvg":0,"doingCount":0,"doneCount":0,"doingScore":0,"ZHScore":0,"mdv_createtime":null,"mdv_visit_type":0,"mdv_visit_next_time":null,"mdv_problem_totalmoney":0,"CanCount":0,"monthmark":0,"user_title_level":3,"data_sources":0,"LastVisitType":0,"name_checkstate":0,"idcard_checkstate":0,"bank_amount_checkstate":0,"bank_type_checkstate":0,"area_type":0,"customer_area_type":0,"project_money_type":0,"customer_budget_type":0,"user_join_state":1,"character_type":0,"customer_character_type":0,"deviation_type":0,"customer_deviation_type":0,"age_type_des":null,"pro_type_des":null,"area_type_des":null,"budget_type_des":null,"focus_type_des":null,"nature_type_des":null,"degree_type_des":null,"matchdegree":0,"Infoauditswitchs":null,"trains":null,"checkStatus":0,"isqualified":0,"ProjectName":null,"recommend":0,"ID":0}
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
        @Override
        public String toString() {
            return "BodyBean{" +
                    "JOne=" + JOne +
                    ", JTwo=" + JTwo +
                    ", JThree=" + JThree +
                    ", z_one=" + z_one +
                    ", z_two=" + z_two +
                    ", z_three=" + z_three +
                    ", z_four=" + z_four +
                    ", z_five=" + z_five +
                    ", z_six=" + z_six +
                    ", z_oneTime='" + z_oneTime + '\'' +
                    ", z_twoTime='" + z_twoTime + '\'' +
                    ", z_threeTime='" + z_threeTime + '\'' +
                    ", z_fourTime='" + z_fourTime + '\'' +
                    ", z_fiveTime='" + z_fiveTime + '\'' +
                    ", z_sixTime='" + z_sixTime + '\'' +
                    ", z_one_remark=" + z_one_remark +
                    ", z_two_remark=" + z_two_remark +
                    ", z_three_remark=" + z_three_remark +
                    ", z_four_remark=" + z_four_remark +
                    ", z_five_remark=" + z_five_remark +
                    ", z_six_remark=" + z_six_remark +
                    ", PmUserinfoEstimate=" + PmUserinfoEstimate +
                    ", uid=" + uid +
                    ", user_no=" + user_no +
                    ", user_type=" + user_type +
                    ", major=" + major +
                    ", contract_type=" + contract_type +
                    ", user_name='" + user_name + '\'' +
                    ", user_level=" + user_level +
                    ", user_level_next=" + user_level_next +
                    ", temp_original_level=" + temp_original_level +
                    ", temp_level_deadline='" + temp_level_deadline + '\'' +
                    ", quality_level=" + quality_level +
                    ", sex=" + sex +
                    ", nation=" + nation +
                    ", birthday='" + birthday + '\'' +
                    ", mobile='" + mobile + '\'' +
                    ", marital_status=" + marital_status +
                    ", now_address='" + now_address + '\'' +
                    ", self_job=" + self_job +
                    ", referrer=" + referrer +
                    ", idcard='" + idcard + '\'' +
                    ", user_height=" + user_height +
                    ", emergency_relation=" + emergency_relation +
                    ", emergency_name='" + emergency_name + '\'' +
                    ", emergency_mobile='" + emergency_mobile + '\'' +
                    ", register_place='" + register_place + '\'' +
                    ", bank_account_name='" + bank_account_name + '\'' +
                    ", bank_account='" + bank_account + '\'' +
                    ", bank_type=" + bank_type +
                    ", bank_address='" + bank_address + '\'' +
                    ", induction_date='" + induction_date + '\'' +
                    ", leaving_date='" + leaving_date + '\'' +
                    ", induction_area=" + induction_area +
                    ", education=" + education +
                    ", education_history=" + education_history +
                    ", education_certificate=" + education_certificate +
                    ", login_account='" + login_account + '\'' +
                    ", login_passpord='" + login_passpord + '\'' +
                    ", worker_num=" + worker_num +
                    ", worker_leader_num=" + worker_leader_num +
                    ", worker_year=" + worker_year +
                    ", lead_team_year=" + lead_team_year +
                    ", pro_max_Name='" + pro_max_Name + '\'' +
                    ", pro_max_address='" + pro_max_address + '\'' +
                    ", pro_max_area='" + pro_max_area + '\'' +
                    ", pro_type=" + pro_type +
                    ", customer_pro_type=" + customer_pro_type +
                    ", pro_max_money=" + pro_max_money +
                    ", can_visit=" + can_visit +
                    ", known_way=" + known_way +
                    ", first_impression='" + first_impression + '\'' +
                    ", last_leaving_reason=" + last_leaving_reason +
                    ", comp_name=" + comp_name +
                    ", comp_register_money=" + comp_register_money +
                    ", comp_register_date=" + comp_register_date +
                    ", comp_address=" + comp_address +
                    ", comp_business_license=" + comp_business_license +
                    ", comp_tax_id=" + comp_tax_id +
                    ", comp_legal_person=" + comp_legal_person +
                    ", comp_legal_cardno=" + comp_legal_cardno +
                    ", comp_legal_mobile=" + comp_legal_mobile +
                    ", comp_legal_person_email=" + comp_legal_person_email +
                    ", comp_bank_account=" + comp_bank_account +
                    ", comp_bank_type=" + comp_bank_type +
                    ", deposit_cash=" + deposit_cash +
                    ", deposit_back_state=" + deposit_back_state +
                    ", deposit_expect_back_date=" + deposit_expect_back_date +
                    ", deposit_actual_back_date=" + deposit_actual_back_date +
                    ", leaving_reason=" + leaving_reason +
                    ", leaving_time='" + leaving_time + '\'' +
                    ", is_blacklist=" + is_blacklist +
                    ", pro_test_count=" + pro_test_count +
                    ", user_state=" + user_state +
                    ", ApproveDesc=" + ApproveDesc +
                    ", TemporaryDesc=" + TemporaryDesc +
                    ", OfficialDesc=" + OfficialDesc +
                    ", MsgState=" + MsgState +
                    ", StageState=" + StageState +
                    ", user_state_name='" + user_state_name + '\'' +
                    ", is_freeze=" + is_freeze +
                    ", photo_server_url='" + photo_server_url + '\'' +
                    ", photo_file_url='" + photo_file_url + '\'' +
                    ", photo_checkstate=" + photo_checkstate +
                    ", photo_art_checkstate=" + photo_art_checkstate +
                    ", createtime='" + createtime + '\'' +
                    ", createuser=" + createuser +
                    ", updatetime='" + updatetime + '\'' +
                    ", updateuser=" + updateuser +
                    ", P_Trait=" + P_Trait +
                    ", TrainingDate=" + TrainingDate +
                    ", GG_level=" + GG_level +
                    ", group_isOk=" + group_isOk +
                    ", is_guiDang=" + is_guiDang +
                    ", orderCountnew=" + orderCountnew +
                    ", photo_art_server_url='" + photo_art_server_url + '\'' +
                    ", photo_art_file_url='" + photo_art_file_url + '\'' +
                    ", achievement_level=" + achievement_level +
                    ", user_tag='" + user_tag + '\'' +
                    ", app_cardNo=" + app_cardNo +
                    ", starlevel=" + starlevel +
                    ", paid_type=" + paid_type +
                    ", comp_bank_account_name=" + comp_bank_account_name +
                    ", counselorLevel=" + counselorLevel +
                    ", syntheticGrade=" + syntheticGrade +
                    ", tempSyntheticGrade=" + tempSyntheticGrade +
                    ", StatisticsEntity=" + StatisticsEntity +
                    ", AttrTime='" + AttrTime + '\'' +
                    ", VisitTime=" + VisitTime +
                    ", VisitMark=" + VisitMark +
                    ", orderCount=" + orderCount +
                    ", sum_actual_money=" + sum_actual_money +
                    ", sum_contract_fee=" + sum_contract_fee +
                    ", Total_FinesTime=" + Total_FinesTime +
                    ", Total_Fines=" + Total_Fines +
                    ", tud_flow=" + tud_flow +
                    ", RowID=" + RowID +
                    ", Time1='" + Time1 + '\'' +
                    ", Time2='" + Time2 + '\'' +
                    ", MonthOrdersCount=" + MonthOrdersCount +
                    ", MeetOrdersCount=" + MeetOrdersCount +
                    ", MeetOrdersMoney=" + MeetOrdersMoney +
                    ", ConstructionCount=" + ConstructionCount +
                    ", FinishCount=" + FinishCount +
                    ", AuditScore=" + AuditScore +
                    ", ConstructionMoney=" + ConstructionMoney +
                    ", ExtensionCount=" + ExtensionCount +
                    ", ExtensionAbnormalCount=" + ExtensionAbnormalCount +
                    ", CompletedCount=" + CompletedCount +
                    ", CompletedMoney=" + CompletedMoney +
                    ", HistoryCompletedCount=" + HistoryCompletedCount +
                    ", HistoryCompletedMoney=" + HistoryCompletedMoney +
                    ", HistoryCount=" + HistoryCount +
                    ", WorkorderMoney=" + WorkorderMoney +
                    ", NotsettledMoney=" + NotsettledMoney +
                    ", PerformanceMoney=" + PerformanceMoney +
                    ", FinishPublishMoney=" + FinishPublishMoney +
                    ", Pro_Score=" + Pro_Score +
                    ", Construction_Quality=" + Construction_Quality +
                    ", Project_Process=" + Project_Process +
                    ", Security_Image=" + Security_Image +
                    ", Environmental_Health=" + Environmental_Health +
                    ", Material_Quality=" + Material_Quality +
                    ", counselorLevelName=" + counselorLevelName +
                    ", attrInfos=" + attrInfos +
                    ", projectCount=" + projectCount +
                    ", orderList=" + orderList +
                    ", isSubmit=" + isSubmit +
                    ", artPhotoUrl=" + artPhotoUrl +
                    ", auditScoreAvg=" + auditScoreAvg +
                    ", doingCount=" + doingCount +
                    ", doneCount=" + doneCount +
                    ", doingScore=" + doingScore +
                    ", ZHScore=" + ZHScore +
                    ", mdv_createtime=" + mdv_createtime +
                    ", mdv_visit_type=" + mdv_visit_type +
                    ", mdv_visit_next_time=" + mdv_visit_next_time +
                    ", mdv_problem_totalmoney=" + mdv_problem_totalmoney +
                    ", CanCount=" + CanCount +
                    ", monthmark=" + monthmark +
                    ", user_title_level=" + user_title_level +
                    ", data_sources=" + data_sources +
                    ", LastVisitType=" + LastVisitType +
                    ", name_checkstate=" + name_checkstate +
                    ", idcard_checkstate=" + idcard_checkstate +
                    ", bank_amount_checkstate=" + bank_amount_checkstate +
                    ", bank_type_checkstate=" + bank_type_checkstate +
                    ", area_type=" + area_type +
                    ", customer_area_type=" + customer_area_type +
                    ", project_money_type=" + project_money_type +
                    ", customer_budget_type=" + customer_budget_type +
                    ", user_join_state=" + user_join_state +
                    ", character_type=" + character_type +
                    ", customer_character_type=" + customer_character_type +
                    ", deviation_type=" + deviation_type +
                    ", customer_deviation_type=" + customer_deviation_type +
                    ", age_type_des=" + age_type_des +
                    ", pro_type_des=" + pro_type_des +
                    ", area_type_des=" + area_type_des +
                    ", budget_type_des=" + budget_type_des +
                    ", focus_type_des=" + focus_type_des +
                    ", nature_type_des=" + nature_type_des +
                    ", degree_type_des=" + degree_type_des +
                    ", matchdegree=" + matchdegree +
                    ", Infoauditswitchs=" + Infoauditswitchs +
                    ", trains=" + trains +
                    ", checkStatus=" + checkStatus +
                    ", isqualified=" + isqualified +
                    ", ProjectName=" + ProjectName +
                    ", recommend=" + recommend +
                    ", ID=" + ID +
                    '}';
        }

        /**
         * JOne : 0
         * JTwo : 0
         * JThree : 0
         * z_one : 0
         * z_two : 0
         * z_three : 0
         * z_four : 0
         * z_five : 0
         * z_six : 0
         * z_oneTime : 0001-01-01T00:00:00
         * z_twoTime : 0001-01-01T00:00:00
         * z_threeTime : 0001-01-01T00:00:00
         * z_fourTime : 0001-01-01T00:00:00
         * z_fiveTime : 0001-01-01T00:00:00
         * z_sixTime : 0001-01-01T00:00:00
         * z_one_remark : null
         * z_two_remark : null
         * z_three_remark : null
         * z_four_remark : null
         * z_five_remark : null
         * z_six_remark : null
         * PmUserinfoEstimate : null
         * uid : 390
         * user_no : null
         * user_type : 1
         * major : 1
         * contract_type : 1
         * user_name : 李老师
         * user_level : 2
         * user_level_next : 3
         * temp_original_level : 0
         * temp_level_deadline : 9999-12-31T23:59:59.997
         * quality_level : 0
         * sex : 1
         * nation : 1
         * birthday : 1993-02-01T00:00:00
         * mobile : 13132103766
         * marital_status : 2
         * now_address : 东丽区津滨大道雪莲桥嘉春园15栋1-401室
         * self_job : 1
         * referrer : null
         * idcard : 2302081987118604123
         * user_height : 0
         * emergency_relation : 0
         * emergency_name : 15146579885
         * emergency_mobile : 13165487894
         * register_place : 安徽省安庆市枞阳县钱桥镇大塘村李黄组
         * bank_account_name : 李光旺
         * bank_account : 62122603020185067123
         * bank_type : 1
         * bank_address : 工商银行东丽区东城家园支行00
         * induction_date : 2016-06-13T15:11:18
         * leaving_date : 0001-01-01T00:00:00
         * induction_area : 19
         * education : 3
         * education_history : null
         * education_certificate : null
         * login_account : TJ005
         * login_passpord : 941018
         * worker_num : 0
         * worker_leader_num : 2
         * worker_year : 7.0
         * lead_team_year : 2.0
         * pro_max_Name : 老姑砂锅
         * pro_max_address : 八里台桥下底商
         * pro_max_area : 600
         * pro_type : 3
         * customer_pro_type : 0
         * pro_max_money : 4
         * can_visit : 1
         * known_way : 2
         * first_impression : 非常好
         * last_leaving_reason : null
         * comp_name : null
         * comp_register_money : 0.0
         * comp_register_date : null
         * comp_address : null
         * comp_business_license : null
         * comp_tax_id : null
         * comp_legal_person : null
         * comp_legal_cardno : null
         * comp_legal_mobile : null
         * comp_legal_person_email : null
         * comp_bank_account : null
         * comp_bank_type : 0
         * deposit_cash : 55293.5
         * deposit_back_state : 0
         * deposit_expect_back_date : null
         * deposit_actual_back_date : null
         * leaving_reason : null
         * leaving_time : 0001-01-01T00:00:00
         * is_blacklist : 0
         * pro_test_count : 2
         * user_state : 2
         * ApproveDesc : null
         * TemporaryDesc : null
         * OfficialDesc : null
         * MsgState : 2
         * StageState : 2
         * user_state_name : 正式
         * is_freeze : 2
         * photo_server_url : http://img9.rxjy.com:80/image/
         * photo_file_url : 0C8FwKgBtFqvLkyAAz5ZAADsdRSjPow092.jpg
         * photo_checkstate : 0
         * photo_art_checkstate : 0
         * createtime : 2017-06-09T09:03:10.107
         * createuser : null
         * updatetime : 2018-04-12T10:01:11.33
         * updateuser : null
         * P_Trait : null
         * TrainingDate : null
         * GG_level : null
         * group_isOk : 1
         * is_guiDang : 1
         * orderCountnew : 0
         * photo_art_server_url : http://img9.rxjy.com:80/image/
         * photo_art_file_url : 0C39wKgBtFqiBTWAPswXAAASWn6OmF4474.png
         * achievement_level : 0
         * user_tag :
         * app_cardNo : null
         * starlevel : 3
         * paid_type : 0
         * comp_bank_account_name : null
         * counselorLevel : 0
         * syntheticGrade : 3
         * tempSyntheticGrade : 0
         * StatisticsEntity : null
         * AttrTime : 0001-01-01T00:00:00
         * VisitTime : null
         * VisitMark : 0
         * orderCount : 0
         * sum_actual_money : 0
         * sum_contract_fee : 0
         * Total_FinesTime : 0
         * Total_Fines : 0.0
         * tud_flow : 0
         * RowID : 0
         * Time1 : 0001-01-01T00:00:00
         * Time2 : 0001-01-01T00:00:00
         * MonthOrdersCount : 0
         * MeetOrdersCount : 0
         * MeetOrdersMoney : 0.0
         * ConstructionCount : 0
         * FinishCount : 0
         * AuditScore : 0
         * ConstructionMoney : 0.0
         * ExtensionCount : 0
         * ExtensionAbnormalCount : 0
         * CompletedCount : 0
         * CompletedMoney : 0.0
         * HistoryCompletedCount : 0
         * HistoryCompletedMoney : 0.0
         * HistoryCount : 0
         * WorkorderMoney : 0.0
         * NotsettledMoney : 0.0
         * PerformanceMoney : 0.0
         * FinishPublishMoney : 0.0
         * Pro_Score : 0.0
         * Construction_Quality : 0.0
         * Project_Process : 0.0
         * Security_Image : 0.0
         * Environmental_Health : 0.0
         * Material_Quality : 0.0
         * counselorLevelName : null
         * attrInfos : null
         * projectCount : 0
         * orderList : null
         * isSubmit : false
         * artPhotoUrl : null
         * auditScoreAvg : 0
         * doingCount : 0
         * doneCount : 0
         * doingScore : 0
         * ZHScore : 0
         * mdv_createtime : null
         * mdv_visit_type : 0
         * mdv_visit_next_time : null
         * mdv_problem_totalmoney : 0.0
         * CanCount : 0
         * monthmark : 0
         * user_title_level : 3
         * data_sources : 0
         * LastVisitType : 0
         * name_checkstate : 0
         * idcard_checkstate : 0
         * bank_amount_checkstate : 0
         * bank_type_checkstate : 0
         * area_type : 0
         * customer_area_type : 0
         * project_money_type : 0
         * customer_budget_type : 0
         * user_join_state : 1
         * character_type : 0
         * customer_character_type : 0
         * deviation_type : 0
         * customer_deviation_type : 0
         * age_type_des : null
         * pro_type_des : null
         * area_type_des : null
         * budget_type_des : null
         * focus_type_des : null
         * nature_type_des : null
         * degree_type_des : null
         * matchdegree : 0.0
         * Infoauditswitchs : null
         * trains : null
         * checkStatus : 0
         * isqualified : 0
         * ProjectName : null
         * recommend : 0
         * ID : 0
         */

        private int JOne;
        private int JTwo;
        private int JThree;
        private int z_one;
        private int z_two;
        private int z_three;
        private int z_four;
        private int z_five;
        private int z_six;
        private String z_oneTime;
        private String z_twoTime;
        private String z_threeTime;
        private String z_fourTime;
        private String z_fiveTime;
        private String z_sixTime;
        private Object z_one_remark;
        private Object z_two_remark;
        private Object z_three_remark;
        private Object z_four_remark;
        private Object z_five_remark;
        private Object z_six_remark;
        private Object PmUserinfoEstimate;
        private int uid;
        private Object user_no;
        private int user_type;
        private int major;
        private int contract_type;
        private String user_name;
        private int user_level;
        private int user_level_next;
        private int temp_original_level;
        private String temp_level_deadline;
        private int quality_level;
        private int sex;
        private int nation;
        private String birthday;
        private String mobile;
        private int marital_status;
        private String now_address;
        private int self_job;
        private Object referrer;
        private String idcard;
        private int user_height;
        private int emergency_relation;
        private String emergency_name;
        private String emergency_mobile;
        private String register_place;
        private String bank_account_name;
        private String bank_account;
        private int bank_type;
        private String bank_address;
        private String induction_date;
        private String leaving_date;
        private int induction_area;
        private int education;
        private Object education_history;
        private Object education_certificate;
        private String login_account;
        private String login_passpord;
        private int worker_num;
        private int worker_leader_num;
        private double worker_year;
        private double lead_team_year;
        private String pro_max_Name;
        private String pro_max_address;
        private String pro_max_area;
        private int pro_type;
        private int customer_pro_type;
        private int pro_max_money;
        private int can_visit;
        private int known_way;
        private String first_impression;
        private Object last_leaving_reason;
        private Object comp_name;
        private double comp_register_money;
        private Object comp_register_date;
        private Object comp_address;
        private Object comp_business_license;
        private Object comp_tax_id;
        private Object comp_legal_person;
        private Object comp_legal_cardno;
        private Object comp_legal_mobile;
        private Object comp_legal_person_email;
        private Object comp_bank_account;
        private int comp_bank_type;
        private double deposit_cash;
        private int deposit_back_state;
        private Object deposit_expect_back_date;
        private Object deposit_actual_back_date;
        private Object leaving_reason;
        private String leaving_time;
        private int is_blacklist;
        private int pro_test_count;
        private int user_state;
        private Object ApproveDesc;
        private Object TemporaryDesc;
        private Object OfficialDesc;
        private int MsgState;
        private int StageState;
        private String user_state_name;
        private int is_freeze;
        private String photo_server_url;
        private String photo_file_url;
        private int photo_checkstate;
        private int photo_art_checkstate;
        private String createtime;
        private Object createuser;
        private String updatetime;
        private Object updateuser;
        private Object P_Trait;
        private Object TrainingDate;
        private Object GG_level;
        private int group_isOk;
        private int is_guiDang;
        private int orderCountnew;
        private String photo_art_server_url;
        private String photo_art_file_url;
        private int achievement_level;
        private String user_tag;
        private Object app_cardNo;
        private int starlevel;
        private int paid_type;
        private Object comp_bank_account_name;
        private int counselorLevel;
        private int syntheticGrade;
        private int tempSyntheticGrade;
        private Object StatisticsEntity;
        private String AttrTime;
        private Object VisitTime;
        private int VisitMark;
        private int orderCount;
        private int sum_actual_money;
        private int sum_contract_fee;
        private int Total_FinesTime;
        private double Total_Fines;
        private int tud_flow;
        private int RowID;
        private String Time1;
        private String Time2;
        private int MonthOrdersCount;
        private int MeetOrdersCount;
        private double MeetOrdersMoney;
        private int ConstructionCount;
        private int FinishCount;
        private int AuditScore;
        private double ConstructionMoney;
        private int ExtensionCount;
        private int ExtensionAbnormalCount;
        private int CompletedCount;
        private double CompletedMoney;
        private int HistoryCompletedCount;
        private double HistoryCompletedMoney;
        private int HistoryCount;
        private double WorkorderMoney;
        private double NotsettledMoney;
        private double PerformanceMoney;
        private double FinishPublishMoney;
        private double Pro_Score;
        private double Construction_Quality;
        private double Project_Process;
        private double Security_Image;
        private double Environmental_Health;
        private double Material_Quality;
        private Object counselorLevelName;
        private Object attrInfos;
        private int projectCount;
        private Object orderList;
        private boolean isSubmit;
        private Object artPhotoUrl;
        private int auditScoreAvg;
        private int doingCount;
        private int doneCount;
        private int doingScore;
        private int ZHScore;
        private Object mdv_createtime;
        private int mdv_visit_type;
        private Object mdv_visit_next_time;
        private double mdv_problem_totalmoney;
        private int CanCount;
        private int monthmark;
        private int user_title_level;
        private int data_sources;
        private int LastVisitType;
        private int name_checkstate;
        private int idcard_checkstate;
        private int bank_amount_checkstate;
        private int bank_type_checkstate;
        private int area_type;
        private int customer_area_type;
        private int project_money_type;
        private int customer_budget_type;
        private int user_join_state;
        private int character_type;
        private int customer_character_type;
        private int deviation_type;
        private int customer_deviation_type;
        private Object age_type_des;
        private Object pro_type_des;
        private Object area_type_des;
        private Object budget_type_des;
        private Object focus_type_des;
        private Object nature_type_des;
        private Object degree_type_des;
        private double matchdegree;
        private Object Infoauditswitchs;
        private Object trains;
        private int checkStatus;
        private int isqualified;
        private Object ProjectName;
        private int recommend;
        private int ID;

        public int getJOne() {
            return JOne;
        }

        public void setJOne(int JOne) {
            this.JOne = JOne;
        }

        public int getJTwo() {
            return JTwo;
        }

        public void setJTwo(int JTwo) {
            this.JTwo = JTwo;
        }

        public int getJThree() {
            return JThree;
        }

        public void setJThree(int JThree) {
            this.JThree = JThree;
        }

        public int getZ_one() {
            return z_one;
        }

        public void setZ_one(int z_one) {
            this.z_one = z_one;
        }

        public int getZ_two() {
            return z_two;
        }

        public void setZ_two(int z_two) {
            this.z_two = z_two;
        }

        public int getZ_three() {
            return z_three;
        }

        public void setZ_three(int z_three) {
            this.z_three = z_three;
        }

        public int getZ_four() {
            return z_four;
        }

        public void setZ_four(int z_four) {
            this.z_four = z_four;
        }

        public int getZ_five() {
            return z_five;
        }

        public void setZ_five(int z_five) {
            this.z_five = z_five;
        }

        public int getZ_six() {
            return z_six;
        }

        public void setZ_six(int z_six) {
            this.z_six = z_six;
        }

        public String getZ_oneTime() {
            return z_oneTime;
        }

        public void setZ_oneTime(String z_oneTime) {
            this.z_oneTime = z_oneTime;
        }

        public String getZ_twoTime() {
            return z_twoTime;
        }

        public void setZ_twoTime(String z_twoTime) {
            this.z_twoTime = z_twoTime;
        }

        public String getZ_threeTime() {
            return z_threeTime;
        }

        public void setZ_threeTime(String z_threeTime) {
            this.z_threeTime = z_threeTime;
        }

        public String getZ_fourTime() {
            return z_fourTime;
        }

        public void setZ_fourTime(String z_fourTime) {
            this.z_fourTime = z_fourTime;
        }

        public String getZ_fiveTime() {
            return z_fiveTime;
        }

        public void setZ_fiveTime(String z_fiveTime) {
            this.z_fiveTime = z_fiveTime;
        }

        public String getZ_sixTime() {
            return z_sixTime;
        }

        public void setZ_sixTime(String z_sixTime) {
            this.z_sixTime = z_sixTime;
        }

        public Object getZ_one_remark() {
            return z_one_remark;
        }

        public void setZ_one_remark(Object z_one_remark) {
            this.z_one_remark = z_one_remark;
        }

        public Object getZ_two_remark() {
            return z_two_remark;
        }

        public void setZ_two_remark(Object z_two_remark) {
            this.z_two_remark = z_two_remark;
        }

        public Object getZ_three_remark() {
            return z_three_remark;
        }

        public void setZ_three_remark(Object z_three_remark) {
            this.z_three_remark = z_three_remark;
        }

        public Object getZ_four_remark() {
            return z_four_remark;
        }

        public void setZ_four_remark(Object z_four_remark) {
            this.z_four_remark = z_four_remark;
        }

        public Object getZ_five_remark() {
            return z_five_remark;
        }

        public void setZ_five_remark(Object z_five_remark) {
            this.z_five_remark = z_five_remark;
        }

        public Object getZ_six_remark() {
            return z_six_remark;
        }

        public void setZ_six_remark(Object z_six_remark) {
            this.z_six_remark = z_six_remark;
        }

        public Object getPmUserinfoEstimate() {
            return PmUserinfoEstimate;
        }

        public void setPmUserinfoEstimate(Object PmUserinfoEstimate) {
            this.PmUserinfoEstimate = PmUserinfoEstimate;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public Object getUser_no() {
            return user_no;
        }

        public void setUser_no(Object user_no) {
            this.user_no = user_no;
        }

        public int getUser_type() {
            return user_type;
        }

        public void setUser_type(int user_type) {
            this.user_type = user_type;
        }

        public int getMajor() {
            return major;
        }

        public void setMajor(int major) {
            this.major = major;
        }

        public int getContract_type() {
            return contract_type;
        }

        public void setContract_type(int contract_type) {
            this.contract_type = contract_type;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public int getUser_level() {
            return user_level;
        }

        public void setUser_level(int user_level) {
            this.user_level = user_level;
        }

        public int getUser_level_next() {
            return user_level_next;
        }

        public void setUser_level_next(int user_level_next) {
            this.user_level_next = user_level_next;
        }

        public int getTemp_original_level() {
            return temp_original_level;
        }

        public void setTemp_original_level(int temp_original_level) {
            this.temp_original_level = temp_original_level;
        }

        public String getTemp_level_deadline() {
            return temp_level_deadline;
        }

        public void setTemp_level_deadline(String temp_level_deadline) {
            this.temp_level_deadline = temp_level_deadline;
        }

        public int getQuality_level() {
            return quality_level;
        }

        public void setQuality_level(int quality_level) {
            this.quality_level = quality_level;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getNation() {
            return nation;
        }

        public void setNation(int nation) {
            this.nation = nation;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getMarital_status() {
            return marital_status;
        }

        public void setMarital_status(int marital_status) {
            this.marital_status = marital_status;
        }

        public String getNow_address() {
            return now_address;
        }

        public void setNow_address(String now_address) {
            this.now_address = now_address;
        }

        public int getSelf_job() {
            return self_job;
        }

        public void setSelf_job(int self_job) {
            this.self_job = self_job;
        }

        public Object getReferrer() {
            return referrer;
        }

        public void setReferrer(Object referrer) {
            this.referrer = referrer;
        }

        public String getIdcard() {
            return idcard;
        }

        public void setIdcard(String idcard) {
            this.idcard = idcard;
        }

        public int getUser_height() {
            return user_height;
        }

        public void setUser_height(int user_height) {
            this.user_height = user_height;
        }

        public int getEmergency_relation() {
            return emergency_relation;
        }

        public void setEmergency_relation(int emergency_relation) {
            this.emergency_relation = emergency_relation;
        }

        public String getEmergency_name() {
            return emergency_name;
        }

        public void setEmergency_name(String emergency_name) {
            this.emergency_name = emergency_name;
        }

        public String getEmergency_mobile() {
            return emergency_mobile;
        }

        public void setEmergency_mobile(String emergency_mobile) {
            this.emergency_mobile = emergency_mobile;
        }

        public String getRegister_place() {
            return register_place;
        }

        public void setRegister_place(String register_place) {
            this.register_place = register_place;
        }

        public String getBank_account_name() {
            return bank_account_name;
        }

        public void setBank_account_name(String bank_account_name) {
            this.bank_account_name = bank_account_name;
        }

        public String getBank_account() {
            return bank_account;
        }

        public void setBank_account(String bank_account) {
            this.bank_account = bank_account;
        }

        public int getBank_type() {
            return bank_type;
        }

        public void setBank_type(int bank_type) {
            this.bank_type = bank_type;
        }

        public String getBank_address() {
            return bank_address;
        }

        public void setBank_address(String bank_address) {
            this.bank_address = bank_address;
        }

        public String getInduction_date() {
            return induction_date;
        }

        public void setInduction_date(String induction_date) {
            this.induction_date = induction_date;
        }

        public String getLeaving_date() {
            return leaving_date;
        }

        public void setLeaving_date(String leaving_date) {
            this.leaving_date = leaving_date;
        }

        public int getInduction_area() {
            return induction_area;
        }

        public void setInduction_area(int induction_area) {
            this.induction_area = induction_area;
        }

        public int getEducation() {
            return education;
        }

        public void setEducation(int education) {
            this.education = education;
        }

        public Object getEducation_history() {
            return education_history;
        }

        public void setEducation_history(Object education_history) {
            this.education_history = education_history;
        }

        public Object getEducation_certificate() {
            return education_certificate;
        }

        public void setEducation_certificate(Object education_certificate) {
            this.education_certificate = education_certificate;
        }

        public String getLogin_account() {
            return login_account;
        }

        public void setLogin_account(String login_account) {
            this.login_account = login_account;
        }

        public String getLogin_passpord() {
            return login_passpord;
        }

        public void setLogin_passpord(String login_passpord) {
            this.login_passpord = login_passpord;
        }

        public int getWorker_num() {
            return worker_num;
        }

        public void setWorker_num(int worker_num) {
            this.worker_num = worker_num;
        }

        public int getWorker_leader_num() {
            return worker_leader_num;
        }

        public void setWorker_leader_num(int worker_leader_num) {
            this.worker_leader_num = worker_leader_num;
        }

        public double getWorker_year() {
            return worker_year;
        }

        public void setWorker_year(double worker_year) {
            this.worker_year = worker_year;
        }

        public double getLead_team_year() {
            return lead_team_year;
        }

        public void setLead_team_year(double lead_team_year) {
            this.lead_team_year = lead_team_year;
        }

        public String getPro_max_Name() {
            return pro_max_Name;
        }

        public void setPro_max_Name(String pro_max_Name) {
            this.pro_max_Name = pro_max_Name;
        }

        public String getPro_max_address() {
            return pro_max_address;
        }

        public void setPro_max_address(String pro_max_address) {
            this.pro_max_address = pro_max_address;
        }

        public String getPro_max_area() {
            return pro_max_area;
        }

        public void setPro_max_area(String pro_max_area) {
            this.pro_max_area = pro_max_area;
        }

        public int getPro_type() {
            return pro_type;
        }

        public void setPro_type(int pro_type) {
            this.pro_type = pro_type;
        }

        public int getCustomer_pro_type() {
            return customer_pro_type;
        }

        public void setCustomer_pro_type(int customer_pro_type) {
            this.customer_pro_type = customer_pro_type;
        }

        public int getPro_max_money() {
            return pro_max_money;
        }

        public void setPro_max_money(int pro_max_money) {
            this.pro_max_money = pro_max_money;
        }

        public int getCan_visit() {
            return can_visit;
        }

        public void setCan_visit(int can_visit) {
            this.can_visit = can_visit;
        }

        public int getKnown_way() {
            return known_way;
        }

        public void setKnown_way(int known_way) {
            this.known_way = known_way;
        }

        public String getFirst_impression() {
            return first_impression;
        }

        public void setFirst_impression(String first_impression) {
            this.first_impression = first_impression;
        }

        public Object getLast_leaving_reason() {
            return last_leaving_reason;
        }

        public void setLast_leaving_reason(Object last_leaving_reason) {
            this.last_leaving_reason = last_leaving_reason;
        }

        public Object getComp_name() {
            return comp_name;
        }

        public void setComp_name(Object comp_name) {
            this.comp_name = comp_name;
        }

        public double getComp_register_money() {
            return comp_register_money;
        }

        public void setComp_register_money(double comp_register_money) {
            this.comp_register_money = comp_register_money;
        }

        public Object getComp_register_date() {
            return comp_register_date;
        }

        public void setComp_register_date(Object comp_register_date) {
            this.comp_register_date = comp_register_date;
        }

        public Object getComp_address() {
            return comp_address;
        }

        public void setComp_address(Object comp_address) {
            this.comp_address = comp_address;
        }

        public Object getComp_business_license() {
            return comp_business_license;
        }

        public void setComp_business_license(Object comp_business_license) {
            this.comp_business_license = comp_business_license;
        }

        public Object getComp_tax_id() {
            return comp_tax_id;
        }

        public void setComp_tax_id(Object comp_tax_id) {
            this.comp_tax_id = comp_tax_id;
        }

        public Object getComp_legal_person() {
            return comp_legal_person;
        }

        public void setComp_legal_person(Object comp_legal_person) {
            this.comp_legal_person = comp_legal_person;
        }

        public Object getComp_legal_cardno() {
            return comp_legal_cardno;
        }

        public void setComp_legal_cardno(Object comp_legal_cardno) {
            this.comp_legal_cardno = comp_legal_cardno;
        }

        public Object getComp_legal_mobile() {
            return comp_legal_mobile;
        }

        public void setComp_legal_mobile(Object comp_legal_mobile) {
            this.comp_legal_mobile = comp_legal_mobile;
        }

        public Object getComp_legal_person_email() {
            return comp_legal_person_email;
        }

        public void setComp_legal_person_email(Object comp_legal_person_email) {
            this.comp_legal_person_email = comp_legal_person_email;
        }

        public Object getComp_bank_account() {
            return comp_bank_account;
        }

        public void setComp_bank_account(Object comp_bank_account) {
            this.comp_bank_account = comp_bank_account;
        }

        public int getComp_bank_type() {
            return comp_bank_type;
        }

        public void setComp_bank_type(int comp_bank_type) {
            this.comp_bank_type = comp_bank_type;
        }

        public double getDeposit_cash() {
            return deposit_cash;
        }

        public void setDeposit_cash(double deposit_cash) {
            this.deposit_cash = deposit_cash;
        }

        public int getDeposit_back_state() {
            return deposit_back_state;
        }

        public void setDeposit_back_state(int deposit_back_state) {
            this.deposit_back_state = deposit_back_state;
        }

        public Object getDeposit_expect_back_date() {
            return deposit_expect_back_date;
        }

        public void setDeposit_expect_back_date(Object deposit_expect_back_date) {
            this.deposit_expect_back_date = deposit_expect_back_date;
        }

        public Object getDeposit_actual_back_date() {
            return deposit_actual_back_date;
        }

        public void setDeposit_actual_back_date(Object deposit_actual_back_date) {
            this.deposit_actual_back_date = deposit_actual_back_date;
        }

        public Object getLeaving_reason() {
            return leaving_reason;
        }

        public void setLeaving_reason(Object leaving_reason) {
            this.leaving_reason = leaving_reason;
        }

        public String getLeaving_time() {
            return leaving_time;
        }

        public void setLeaving_time(String leaving_time) {
            this.leaving_time = leaving_time;
        }

        public int getIs_blacklist() {
            return is_blacklist;
        }

        public void setIs_blacklist(int is_blacklist) {
            this.is_blacklist = is_blacklist;
        }

        public int getPro_test_count() {
            return pro_test_count;
        }

        public void setPro_test_count(int pro_test_count) {
            this.pro_test_count = pro_test_count;
        }

        public int getUser_state() {
            return user_state;
        }

        public void setUser_state(int user_state) {
            this.user_state = user_state;
        }

        public Object getApproveDesc() {
            return ApproveDesc;
        }

        public void setApproveDesc(Object ApproveDesc) {
            this.ApproveDesc = ApproveDesc;
        }

        public Object getTemporaryDesc() {
            return TemporaryDesc;
        }

        public void setTemporaryDesc(Object TemporaryDesc) {
            this.TemporaryDesc = TemporaryDesc;
        }

        public Object getOfficialDesc() {
            return OfficialDesc;
        }

        public void setOfficialDesc(Object OfficialDesc) {
            this.OfficialDesc = OfficialDesc;
        }

        public int getMsgState() {
            return MsgState;
        }

        public void setMsgState(int MsgState) {
            this.MsgState = MsgState;
        }

        public int getStageState() {
            return StageState;
        }

        public void setStageState(int StageState) {
            this.StageState = StageState;
        }

        public String getUser_state_name() {
            return user_state_name;
        }

        public void setUser_state_name(String user_state_name) {
            this.user_state_name = user_state_name;
        }

        public int getIs_freeze() {
            return is_freeze;
        }

        public void setIs_freeze(int is_freeze) {
            this.is_freeze = is_freeze;
        }

        public String getPhoto_server_url() {
            return photo_server_url;
        }

        public void setPhoto_server_url(String photo_server_url) {
            this.photo_server_url = photo_server_url;
        }

        public String getPhoto_file_url() {
            return photo_file_url;
        }

        public void setPhoto_file_url(String photo_file_url) {
            this.photo_file_url = photo_file_url;
        }

        public int getPhoto_checkstate() {
            return photo_checkstate;
        }

        public void setPhoto_checkstate(int photo_checkstate) {
            this.photo_checkstate = photo_checkstate;
        }

        public int getPhoto_art_checkstate() {
            return photo_art_checkstate;
        }

        public void setPhoto_art_checkstate(int photo_art_checkstate) {
            this.photo_art_checkstate = photo_art_checkstate;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public Object getCreateuser() {
            return createuser;
        }

        public void setCreateuser(Object createuser) {
            this.createuser = createuser;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }

        public Object getUpdateuser() {
            return updateuser;
        }

        public void setUpdateuser(Object updateuser) {
            this.updateuser = updateuser;
        }

        public Object getP_Trait() {
            return P_Trait;
        }

        public void setP_Trait(Object P_Trait) {
            this.P_Trait = P_Trait;
        }

        public Object getTrainingDate() {
            return TrainingDate;
        }

        public void setTrainingDate(Object TrainingDate) {
            this.TrainingDate = TrainingDate;
        }

        public Object getGG_level() {
            return GG_level;
        }

        public void setGG_level(Object GG_level) {
            this.GG_level = GG_level;
        }

        public int getGroup_isOk() {
            return group_isOk;
        }

        public void setGroup_isOk(int group_isOk) {
            this.group_isOk = group_isOk;
        }

        public int getIs_guiDang() {
            return is_guiDang;
        }

        public void setIs_guiDang(int is_guiDang) {
            this.is_guiDang = is_guiDang;
        }

        public int getOrderCountnew() {
            return orderCountnew;
        }

        public void setOrderCountnew(int orderCountnew) {
            this.orderCountnew = orderCountnew;
        }

        public String getPhoto_art_server_url() {
            return photo_art_server_url;
        }

        public void setPhoto_art_server_url(String photo_art_server_url) {
            this.photo_art_server_url = photo_art_server_url;
        }

        public String getPhoto_art_file_url() {
            return photo_art_file_url;
        }

        public void setPhoto_art_file_url(String photo_art_file_url) {
            this.photo_art_file_url = photo_art_file_url;
        }

        public int getAchievement_level() {
            return achievement_level;
        }

        public void setAchievement_level(int achievement_level) {
            this.achievement_level = achievement_level;
        }

        public String getUser_tag() {
            return user_tag;
        }

        public void setUser_tag(String user_tag) {
            this.user_tag = user_tag;
        }

        public Object getApp_cardNo() {
            return app_cardNo;
        }

        public void setApp_cardNo(Object app_cardNo) {
            this.app_cardNo = app_cardNo;
        }

        public int getStarlevel() {
            return starlevel;
        }

        public void setStarlevel(int starlevel) {
            this.starlevel = starlevel;
        }

        public int getPaid_type() {
            return paid_type;
        }

        public void setPaid_type(int paid_type) {
            this.paid_type = paid_type;
        }

        public Object getComp_bank_account_name() {
            return comp_bank_account_name;
        }

        public void setComp_bank_account_name(Object comp_bank_account_name) {
            this.comp_bank_account_name = comp_bank_account_name;
        }

        public int getCounselorLevel() {
            return counselorLevel;
        }

        public void setCounselorLevel(int counselorLevel) {
            this.counselorLevel = counselorLevel;
        }

        public int getSyntheticGrade() {
            return syntheticGrade;
        }

        public void setSyntheticGrade(int syntheticGrade) {
            this.syntheticGrade = syntheticGrade;
        }

        public int getTempSyntheticGrade() {
            return tempSyntheticGrade;
        }

        public void setTempSyntheticGrade(int tempSyntheticGrade) {
            this.tempSyntheticGrade = tempSyntheticGrade;
        }

        public Object getStatisticsEntity() {
            return StatisticsEntity;
        }

        public void setStatisticsEntity(Object StatisticsEntity) {
            this.StatisticsEntity = StatisticsEntity;
        }

        public String getAttrTime() {
            return AttrTime;
        }

        public void setAttrTime(String AttrTime) {
            this.AttrTime = AttrTime;
        }

        public Object getVisitTime() {
            return VisitTime;
        }

        public void setVisitTime(Object VisitTime) {
            this.VisitTime = VisitTime;
        }

        public int getVisitMark() {
            return VisitMark;
        }

        public void setVisitMark(int VisitMark) {
            this.VisitMark = VisitMark;
        }

        public int getOrderCount() {
            return orderCount;
        }

        public void setOrderCount(int orderCount) {
            this.orderCount = orderCount;
        }

        public int getSum_actual_money() {
            return sum_actual_money;
        }

        public void setSum_actual_money(int sum_actual_money) {
            this.sum_actual_money = sum_actual_money;
        }

        public int getSum_contract_fee() {
            return sum_contract_fee;
        }

        public void setSum_contract_fee(int sum_contract_fee) {
            this.sum_contract_fee = sum_contract_fee;
        }

        public int getTotal_FinesTime() {
            return Total_FinesTime;
        }

        public void setTotal_FinesTime(int Total_FinesTime) {
            this.Total_FinesTime = Total_FinesTime;
        }

        public double getTotal_Fines() {
            return Total_Fines;
        }

        public void setTotal_Fines(double Total_Fines) {
            this.Total_Fines = Total_Fines;
        }

        public int getTud_flow() {
            return tud_flow;
        }

        public void setTud_flow(int tud_flow) {
            this.tud_flow = tud_flow;
        }

        public int getRowID() {
            return RowID;
        }

        public void setRowID(int RowID) {
            this.RowID = RowID;
        }

        public String getTime1() {
            return Time1;
        }

        public void setTime1(String Time1) {
            this.Time1 = Time1;
        }

        public String getTime2() {
            return Time2;
        }

        public void setTime2(String Time2) {
            this.Time2 = Time2;
        }

        public int getMonthOrdersCount() {
            return MonthOrdersCount;
        }

        public void setMonthOrdersCount(int MonthOrdersCount) {
            this.MonthOrdersCount = MonthOrdersCount;
        }

        public int getMeetOrdersCount() {
            return MeetOrdersCount;
        }

        public void setMeetOrdersCount(int MeetOrdersCount) {
            this.MeetOrdersCount = MeetOrdersCount;
        }

        public double getMeetOrdersMoney() {
            return MeetOrdersMoney;
        }

        public void setMeetOrdersMoney(double MeetOrdersMoney) {
            this.MeetOrdersMoney = MeetOrdersMoney;
        }

        public int getConstructionCount() {
            return ConstructionCount;
        }

        public void setConstructionCount(int ConstructionCount) {
            this.ConstructionCount = ConstructionCount;
        }

        public int getFinishCount() {
            return FinishCount;
        }

        public void setFinishCount(int FinishCount) {
            this.FinishCount = FinishCount;
        }

        public int getAuditScore() {
            return AuditScore;
        }

        public void setAuditScore(int AuditScore) {
            this.AuditScore = AuditScore;
        }

        public double getConstructionMoney() {
            return ConstructionMoney;
        }

        public void setConstructionMoney(double ConstructionMoney) {
            this.ConstructionMoney = ConstructionMoney;
        }

        public int getExtensionCount() {
            return ExtensionCount;
        }

        public void setExtensionCount(int ExtensionCount) {
            this.ExtensionCount = ExtensionCount;
        }

        public int getExtensionAbnormalCount() {
            return ExtensionAbnormalCount;
        }

        public void setExtensionAbnormalCount(int ExtensionAbnormalCount) {
            this.ExtensionAbnormalCount = ExtensionAbnormalCount;
        }

        public int getCompletedCount() {
            return CompletedCount;
        }

        public void setCompletedCount(int CompletedCount) {
            this.CompletedCount = CompletedCount;
        }

        public double getCompletedMoney() {
            return CompletedMoney;
        }

        public void setCompletedMoney(double CompletedMoney) {
            this.CompletedMoney = CompletedMoney;
        }

        public int getHistoryCompletedCount() {
            return HistoryCompletedCount;
        }

        public void setHistoryCompletedCount(int HistoryCompletedCount) {
            this.HistoryCompletedCount = HistoryCompletedCount;
        }

        public double getHistoryCompletedMoney() {
            return HistoryCompletedMoney;
        }

        public void setHistoryCompletedMoney(double HistoryCompletedMoney) {
            this.HistoryCompletedMoney = HistoryCompletedMoney;
        }

        public int getHistoryCount() {
            return HistoryCount;
        }

        public void setHistoryCount(int HistoryCount) {
            this.HistoryCount = HistoryCount;
        }

        public double getWorkorderMoney() {
            return WorkorderMoney;
        }

        public void setWorkorderMoney(double WorkorderMoney) {
            this.WorkorderMoney = WorkorderMoney;
        }

        public double getNotsettledMoney() {
            return NotsettledMoney;
        }

        public void setNotsettledMoney(double NotsettledMoney) {
            this.NotsettledMoney = NotsettledMoney;
        }

        public double getPerformanceMoney() {
            return PerformanceMoney;
        }

        public void setPerformanceMoney(double PerformanceMoney) {
            this.PerformanceMoney = PerformanceMoney;
        }

        public double getFinishPublishMoney() {
            return FinishPublishMoney;
        }

        public void setFinishPublishMoney(double FinishPublishMoney) {
            this.FinishPublishMoney = FinishPublishMoney;
        }

        public double getPro_Score() {
            return Pro_Score;
        }

        public void setPro_Score(double Pro_Score) {
            this.Pro_Score = Pro_Score;
        }

        public double getConstruction_Quality() {
            return Construction_Quality;
        }

        public void setConstruction_Quality(double Construction_Quality) {
            this.Construction_Quality = Construction_Quality;
        }

        public double getProject_Process() {
            return Project_Process;
        }

        public void setProject_Process(double Project_Process) {
            this.Project_Process = Project_Process;
        }

        public double getSecurity_Image() {
            return Security_Image;
        }

        public void setSecurity_Image(double Security_Image) {
            this.Security_Image = Security_Image;
        }

        public double getEnvironmental_Health() {
            return Environmental_Health;
        }

        public void setEnvironmental_Health(double Environmental_Health) {
            this.Environmental_Health = Environmental_Health;
        }

        public double getMaterial_Quality() {
            return Material_Quality;
        }

        public void setMaterial_Quality(double Material_Quality) {
            this.Material_Quality = Material_Quality;
        }

        public Object getCounselorLevelName() {
            return counselorLevelName;
        }

        public void setCounselorLevelName(Object counselorLevelName) {
            this.counselorLevelName = counselorLevelName;
        }

        public Object getAttrInfos() {
            return attrInfos;
        }

        public void setAttrInfos(Object attrInfos) {
            this.attrInfos = attrInfos;
        }

        public int getProjectCount() {
            return projectCount;
        }

        public void setProjectCount(int projectCount) {
            this.projectCount = projectCount;
        }

        public Object getOrderList() {
            return orderList;
        }

        public void setOrderList(Object orderList) {
            this.orderList = orderList;
        }

        public boolean isIsSubmit() {
            return isSubmit;
        }

        public void setIsSubmit(boolean isSubmit) {
            this.isSubmit = isSubmit;
        }

        public Object getArtPhotoUrl() {
            return artPhotoUrl;
        }

        public void setArtPhotoUrl(Object artPhotoUrl) {
            this.artPhotoUrl = artPhotoUrl;
        }

        public int getAuditScoreAvg() {
            return auditScoreAvg;
        }

        public void setAuditScoreAvg(int auditScoreAvg) {
            this.auditScoreAvg = auditScoreAvg;
        }

        public int getDoingCount() {
            return doingCount;
        }

        public void setDoingCount(int doingCount) {
            this.doingCount = doingCount;
        }

        public int getDoneCount() {
            return doneCount;
        }

        public void setDoneCount(int doneCount) {
            this.doneCount = doneCount;
        }

        public int getDoingScore() {
            return doingScore;
        }

        public void setDoingScore(int doingScore) {
            this.doingScore = doingScore;
        }

        public int getZHScore() {
            return ZHScore;
        }

        public void setZHScore(int ZHScore) {
            this.ZHScore = ZHScore;
        }

        public Object getMdv_createtime() {
            return mdv_createtime;
        }

        public void setMdv_createtime(Object mdv_createtime) {
            this.mdv_createtime = mdv_createtime;
        }

        public int getMdv_visit_type() {
            return mdv_visit_type;
        }

        public void setMdv_visit_type(int mdv_visit_type) {
            this.mdv_visit_type = mdv_visit_type;
        }

        public Object getMdv_visit_next_time() {
            return mdv_visit_next_time;
        }

        public void setMdv_visit_next_time(Object mdv_visit_next_time) {
            this.mdv_visit_next_time = mdv_visit_next_time;
        }

        public double getMdv_problem_totalmoney() {
            return mdv_problem_totalmoney;
        }

        public void setMdv_problem_totalmoney(double mdv_problem_totalmoney) {
            this.mdv_problem_totalmoney = mdv_problem_totalmoney;
        }

        public int getCanCount() {
            return CanCount;
        }

        public void setCanCount(int CanCount) {
            this.CanCount = CanCount;
        }

        public int getMonthmark() {
            return monthmark;
        }

        public void setMonthmark(int monthmark) {
            this.monthmark = monthmark;
        }

        public int getUser_title_level() {
            return user_title_level;
        }

        public void setUser_title_level(int user_title_level) {
            this.user_title_level = user_title_level;
        }

        public int getData_sources() {
            return data_sources;
        }

        public void setData_sources(int data_sources) {
            this.data_sources = data_sources;
        }

        public int getLastVisitType() {
            return LastVisitType;
        }

        public void setLastVisitType(int LastVisitType) {
            this.LastVisitType = LastVisitType;
        }

        public int getName_checkstate() {
            return name_checkstate;
        }

        public void setName_checkstate(int name_checkstate) {
            this.name_checkstate = name_checkstate;
        }

        public int getIdcard_checkstate() {
            return idcard_checkstate;
        }

        public void setIdcard_checkstate(int idcard_checkstate) {
            this.idcard_checkstate = idcard_checkstate;
        }

        public int getBank_amount_checkstate() {
            return bank_amount_checkstate;
        }

        public void setBank_amount_checkstate(int bank_amount_checkstate) {
            this.bank_amount_checkstate = bank_amount_checkstate;
        }

        public int getBank_type_checkstate() {
            return bank_type_checkstate;
        }

        public void setBank_type_checkstate(int bank_type_checkstate) {
            this.bank_type_checkstate = bank_type_checkstate;
        }

        public int getArea_type() {
            return area_type;
        }

        public void setArea_type(int area_type) {
            this.area_type = area_type;
        }

        public int getCustomer_area_type() {
            return customer_area_type;
        }

        public void setCustomer_area_type(int customer_area_type) {
            this.customer_area_type = customer_area_type;
        }

        public int getProject_money_type() {
            return project_money_type;
        }

        public void setProject_money_type(int project_money_type) {
            this.project_money_type = project_money_type;
        }

        public int getCustomer_budget_type() {
            return customer_budget_type;
        }

        public void setCustomer_budget_type(int customer_budget_type) {
            this.customer_budget_type = customer_budget_type;
        }

        public int getUser_join_state() {
            return user_join_state;
        }

        public void setUser_join_state(int user_join_state) {
            this.user_join_state = user_join_state;
        }

        public int getCharacter_type() {
            return character_type;
        }

        public void setCharacter_type(int character_type) {
            this.character_type = character_type;
        }

        public int getCustomer_character_type() {
            return customer_character_type;
        }

        public void setCustomer_character_type(int customer_character_type) {
            this.customer_character_type = customer_character_type;
        }

        public int getDeviation_type() {
            return deviation_type;
        }

        public void setDeviation_type(int deviation_type) {
            this.deviation_type = deviation_type;
        }

        public int getCustomer_deviation_type() {
            return customer_deviation_type;
        }

        public void setCustomer_deviation_type(int customer_deviation_type) {
            this.customer_deviation_type = customer_deviation_type;
        }

        public Object getAge_type_des() {
            return age_type_des;
        }

        public void setAge_type_des(Object age_type_des) {
            this.age_type_des = age_type_des;
        }

        public Object getPro_type_des() {
            return pro_type_des;
        }

        public void setPro_type_des(Object pro_type_des) {
            this.pro_type_des = pro_type_des;
        }

        public Object getArea_type_des() {
            return area_type_des;
        }

        public void setArea_type_des(Object area_type_des) {
            this.area_type_des = area_type_des;
        }

        public Object getBudget_type_des() {
            return budget_type_des;
        }

        public void setBudget_type_des(Object budget_type_des) {
            this.budget_type_des = budget_type_des;
        }

        public Object getFocus_type_des() {
            return focus_type_des;
        }

        public void setFocus_type_des(Object focus_type_des) {
            this.focus_type_des = focus_type_des;
        }

        public Object getNature_type_des() {
            return nature_type_des;
        }

        public void setNature_type_des(Object nature_type_des) {
            this.nature_type_des = nature_type_des;
        }

        public Object getDegree_type_des() {
            return degree_type_des;
        }

        public void setDegree_type_des(Object degree_type_des) {
            this.degree_type_des = degree_type_des;
        }

        public double getMatchdegree() {
            return matchdegree;
        }

        public void setMatchdegree(double matchdegree) {
            this.matchdegree = matchdegree;
        }

        public Object getInfoauditswitchs() {
            return Infoauditswitchs;
        }

        public void setInfoauditswitchs(Object Infoauditswitchs) {
            this.Infoauditswitchs = Infoauditswitchs;
        }

        public Object getTrains() {
            return trains;
        }

        public void setTrains(Object trains) {
            this.trains = trains;
        }

        public int getCheckStatus() {
            return checkStatus;
        }

        public void setCheckStatus(int checkStatus) {
            this.checkStatus = checkStatus;
        }

        public int getIsqualified() {
            return isqualified;
        }

        public void setIsqualified(int isqualified) {
            this.isqualified = isqualified;
        }

        public Object getProjectName() {
            return ProjectName;
        }

        public void setProjectName(Object ProjectName) {
            this.ProjectName = ProjectName;
        }

        public int getRecommend() {
            return recommend;
        }

        public void setRecommend(int recommend) {
            this.recommend = recommend;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }
    }
}
