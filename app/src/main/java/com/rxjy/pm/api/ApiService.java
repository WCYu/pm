package com.rxjy.pm.api;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2017/1/9.
 */
public interface ApiService {

    /**
     * 获取版本信息
     *///http://api.gc.rxjy.com/app/version_com.rxjy.pm.json
    @GET("actionapi/AppCurrencyHome/IsAndroidUpdated")
    Observable<String> getVersionInfo(
            @Query("Version") int version,
            @Query("AppId") int AppId
    );

    /**
     * 登录
     */
    @FormUrlEncoded
    @POST("actionapi/apphome/Login")
    Observable<String> getToken(
            @Field("cardNo") String cardNo,
            @Field("password") String password//,
            // @Field("postId") int postID
    );

    /**
     * 验证码登录
     */
    @FormUrlEncoded
    @POST("actionapi/apphome/Login")
    Observable<String> getTokenByCode(
            @Field("cardNo") String cardNo,
            @Field("vCode") String vCode//,
            // @Field("postId") int postID
    );

    /**
     * 获取注册验证码
     */
    @FormUrlEncoded
    @POST("actionapi/AppHome/GetVcodeRegister")
    Observable<String> getVerificationCode(
            @Field("phone") String phoneNum
    );

    /**
     * 获取登录验证码
     */
    @FormUrlEncoded
    @POST("actionapi/AppHome/GetVcodeLanding")
    Observable<String> getVCodeLogin(
            @Field("phone") String phoneNum
    );

    /**
     * 获取忘记密码验证码
     */
    @FormUrlEncoded
    @POST("actionapi/AppHome/GetVcodeUpdatePwd")
    Observable<String> getVCodeForgetPassword(
            @Field("phone") String phoneNum
    );

    /**
     * 忘记密码修改密码
     */
    @FormUrlEncoded
    @POST("actionapi/AppHome/UpdatePassword_Vcode")
    Observable<String> updatePasswordByForget(
            @Field("phone") String phoneNum,
            @Field("newPassword") String newPassword,
            @Field("vCode") String vCode
    );

    /**
     * 修改密码
     */
    @GET("actionapi/apphome/UpdatePassword")
    Observable<String> updatePassword(
            @Query("cardNo") String cardNo,
            @Query("password") String password,
            @Query("newPassword") String newPassword,
            @Query("token") String token
    );

    /**
     * 注册
     */
    @FormUrlEncoded
    @POST("actionapi/AppHome/AddUser")
    Observable<String> getRegister(
            @Field("v_code") String code,
            @Field("a_account") String phoneNum,
            @Field("a_password") String password,
            @Field("depart_id") int areaID,
            @Field("post_name") String postName,
            @Field("post_id") int postID,
            @Field("sw_invitation_code") String invitationCode
    );

    /**
     * 获取用户信息
     */
//    @Headers("Cache-Control: public, max-age=3600")
    @GET("actionapi/apphome/GetUserMessage")
    Observable<String> getLoginUserInfo(
            @Query("cardNo") String cardNo,
            @Query("token") String token
    );

    @FormUrlEncoded
    @POST("api/APPPM/SaveWorkorderUserMatching")
    Observable<String> loadBinding(
            @Field("workerid") String workerid,
            @Field("orderno") String orderno,
            @Field("uid") String uid
    );

    /**
     * 获取工人用户信息
     */
    @GET("api/APPPM/GetPmWorkerMsg")
    Observable<String> getLoginWorkerInfo(
            @Query("mobile") String mobile

    );

    /**
     * 获取UID
     */
    @GET("api/PhoneMaterial/GetPMInfoByMobile")
    Observable<String> getPmUserInfo(
            @Query("mobile") String phoneNum,
            @Query("user_type") int type
    );

    /**
     * 上传头像
     */
    @Multipart
    @POST("actionapi/AppHome/UpdateImages")
    Observable<String> upHeaderPicture(
            @Part("token") String token,
            @Part("cardNo") String cardNo,
            @Part("type") String type,
            @Part MultipartBody.Part file
    );

    /**
     * 新闻列表
     */
    @Multipart
    @POST("a/sap/sapArticle/getAppArticleList")
    Observable<String> getNewsList(
            @Part("cardNo") String cardNo,
            @Part("page") int pageIndex,
            @Part("rows") int pageSize
    );

    /**
     * 修改用户信息
     */
    @FormUrlEncoded
    @POST("actionapi/AppHome/UpdateMyInfo")
    Observable<String> updateUserInfo(
            @Field("token") String token,
            @Field("cardNo") String cardNo,
            @Field("key") String key,
            @Field("value") String value
    );

    /**
     * 获取钱包信息
     */
    @GET("AppAgent/GetMemBerMoney")
    Observable<String> getWalletInfo(
            @Query("MemberCard") String cardNo
    );

    /**
     * 获取收支明细数据接口
     */
    @GET("AppAgent/ShouZhiMingXiList")
    Observable<String> getWalletRecord(
            @Query("KaHao") String cardNo,
            @Query("PageIndex") int pageIndex,
            @Query("PageSize") int pageSize
    );

    /**
     * 新增或修改银行卡信息
     */
    @FormUrlEncoded
    @POST("actionapi/AppHome/UpdateMyBankInfo")
    Observable<String> subAddOrUpd(
            @Field("token") String token,
            @Field("cardNo") String cardNo,
            @Field("bankCard") String bankCard,
            @Field("bankName") String bankName,
            @Field("bankUserName") String bankUserName
    );

    /**
     * 获取项目列表
     */
    @GET("api/APPProjectManger/GetWorkorderByUid")
    Observable<String> getProList(
            @Query("uid") int uid
    );

    /**
     * 获取工序列表
     */
    @GET("api/APPProjectManger/GetProjectProcess")
    Observable<String> getProcessList(
            @Query("orderno") String orderNo,
            @Query("ptype") int type,
            @Query("flag") int flag
    );

    /**
     * 获取工艺列表
     */
    @GET("api/APPProjectManger/GetConstCraft")
    Observable<String> getCraftList(
            @Query("orderno") String orderNo
    );

    /**
     * 获取工艺详情接口
     */
    @GET("api/APPProjectManger/GetConstCraftDetail")
    Observable<String> getCraftDetail(
            @Query("craft_id") int craftID,
            @Query("ptype") int type
    );

    /**
     * 上传工艺照片
     */
    @Multipart
    @POST("api/APPProjectManger/SubConstCraftPhoto")
    Observable<String> subCraftPhoto(
            @Part("craft_id") int craftID,
            @Part("craft_photo_id") int craftPhotoID,
            @Part("rec_desc") String recDesc,
            @Part("ptype") int type,
            @Part MultipartBody.Part file
    );

    /**
     * 获取工序详情接口
     */
    @GET("api/APPProjectManger/GetProcessStepDetail")
    Observable<String> getProcessDetail(
            @Query("process_id") int processID,
            @Query("ptype") int type
    );

    /**
     * 上传工序详情图片接口
     */
    @Multipart
    @POST("api/APPProjectManger/SubProcessStep")
    Observable<String> subProcessPhoto(
            @Part("step_id") int stepID,
            @Part("process_id") int processID,
            @Part("StepPhotoID") int stepPhotoID,
            @Part("ptype") int type,
            @Part MultipartBody.Part file
    );

    /**
     * 上传工序详情图片接口
     */
    @Multipart
    @POST("api/APPProjectManger/SubProcessStepNew")
    Observable<String> subProcessPhotoCamera(
            @Part("step_id") int stepID,
            @Part("process_id") int processID,
            @Part("StepPhotoID") int stepPhotoID,
            @Part("ptype") int type,
            @Part MultipartBody.Part file
    );

    /**
     * 获取支款标准状态
     */
    @GET("api/APPProjectManger/GetZhiKuanStatus")
    Observable<String> getDisbursementState(
            @Query("orderno") String orderNo,
            @Query("ptype") int type
    );

    /**
     * 获取可用款信息
     */
    @GET("api/APPProjectManger/GetMoneyInfo")
    Observable<String> getDisbursementData(
            @Query("orderno") String orderNo
    );

    /**
     * 申请支款
     */
    @Multipart
    @POST("api/APPProjectManger/SubZhiKuan")
    Observable<String> subDisbursementInfo(
            @Part("orderno") String orderNo,
            @Part("money") double money,
            @Part("reason") String reason,
            @Part("fine_id") String fine_id,
            @Part("uid") int uid
    );

    /**
     * 获取支款记录信息
     */
    @GET("api/APPProjectManger/GetZhiKuanList")
    Observable<String> getDisbursementList(
            @Query("orderno") String orderNo
    );

    /**
     * 获取项目可用资金
     */
    @GET("api/PhoneMaterial/GetWorkorderMoneyListByUid")
    Observable<String> getProMoneyList(
            @Query("uid") int uid
    );

    /**
     * 获取奖罚记录
     */
    @GET("api/PhoneMaterial/GetPMUserFineList")
    Observable<String> getPunishRecordInfo(
            @Query("uid") int uid,
            @Query("rp") int type,
            @Query("before") String before
    );

    /**
     * 获取巡检列表
     */
    @GET("api/APPProjectManger/GetInspectionList")
    Observable<String> getRoutingList(
            @Query("orderno") String orderNo,
            @Query("ptype") int type
    );

    /**
     * 获取环境巡检列表
     */
    @GET("api/APPProjectManger/GetXunjianXiangMuHuanJing")
    Observable<String> getEnvironmentList(
            @Query("orderno") String orderNo,
            @Query("xj_id") int xjID
    );

    /**
     * 获取巡检详情接口
     */
    @GET("api/APPProjectManger/GetXunjianXiangMuHuanJingDetail")
    Observable<String> getEnvironmentDetail(
            @Query("process_id") int processID,
            @Query("xj_id") int xjID
    );

    /**
     * 上传巡检详情图片接口
     */
    @Multipart
    @POST("api/APPProjectManger/SubXunjianXiangMuHuanJing")
    Observable<String> subEnvironmentDetailPhoto(
            @Part("step_id") int stepID,
            @Part("xj_id") int xjID,
            @Part("orderno") String orderNo,
            @Part("xjs_address") String address,
            @Part("xjs_x") String xjsX,
            @Part("xjs_y") String xjsY,
            @Part MultipartBody.Part file
    );

    /**
     * 上传巡检信息接口
     */
    @Multipart
    @POST("api/APPProjectManger/SubXunjian")
    Observable<String> subRoutingData(
            @Part("xj_id") int xjID,
            @Part("xj_content") String content,
            @Part("xj_tag") String tag,
            @Part("xj_address") String address,
            @Part("xj_x") double xjX,
            @Part("xj_y") double xjY,
            @Part List<MultipartBody.Part> files
    );

    /**
     * 获取巡检历史接口
     */
    @GET("api/APPProjectManger/GetXunJianList")
    Observable<String> getRoutingHistoryList(
            @Query("orderno") String orderNo,
            @Query("ptype") int pType
    );

    /**
     * 获取项目款详情
     */
    @GET("api/APPProjectManger/GetPMProjecMoneyDetail")
    Observable<String> getProMoneyInfo(
            @Query("orderno") String orderNo
    );

    /**
     * 获取材料项目里列表
     */
    @GET("api/APPProjectManger/GetWorkorderDealtWithToMaterial")
    Observable<String> getMatProList(
            @Query("uid") int uid
    );

    /**
     * 获取项目下订单集合
     */
    @GET("api/APPProjectManger/UpdateOrderToReceipt")
    Observable<String> getOrdersListByPro(
            @Query("orderno") String orderNo
    );

    /**
     * 获取项目下历史订单集合
     */
    @GET("api/APPProjectManger/GetWorkorderOrderToHistory")
    Observable<String> getHistoryOrdersListByPro(
            @Query("orderno") String orderNo
    );

    /**
     * 提交投诉建议
     */
    @Multipart
    @POST("api/APPUserInfo/SubmitSuggestionToUser")
    Observable<String> subSuggestInfo(
            @Part("user") int uid,
            @Part("uType") int uType,
            @Part("sType") int type,
            @Part("scontent") String content,
            @Part List<MultipartBody.Part> files
    );

    /**
     * 获取材料一级分类
     */
    @GET("api/APPPM/GetFirstTreeItemsByOrderNo")
    Observable<String> getFirstMat(
            @Query("orderno") String orderNo
    );

    /**
     * 获取材料二级分类
     */
    @GET("api/APPPM/GetSecondTreeItemsByOrderNo")
    Observable<String> getSecondMat(
            @Query("orderno") String orderNo,
            @Query("treeID") String treeID
    );

    /**
     * 获取材料列表
     */
    @GET("api/APPPM/GetMaterialItemsByPMAPP")
    Observable<String> getMatList(
            @Query("orderno") String orderNo,
            @Query("treeID") String treeID,
            @Query("treeTwo") String treeTwo
    );

    /**
     * 获取项目材料款项等
     */
    @GET("api/APPProjectManger/GetWorkorderStatistics")
    Observable<String> getMatMoneyInfo(
            @Query("orderno") String orderNo
    );

    /**
     * 添加材料接口
     */
    @POST("api/APPPM/AddMaterialToShoppingCart")
    Observable<String> updMat(
            @Body RequestBody json
    );

    /**
     * 获取热词
     */
    @GET("api/APPPM/GetSearchHotTitleItems")
    Observable<String> getHotWord(

    );

    /**
     * 获取模糊搜索列表
     */
    @GET("api/APPPM/GetSearchPerfectTitle")
    Observable<String> getFuzzySearch(
            @Query("orderno") String orderNo,
            @Query("search") String search
    );

    /**
     * 材料搜索结果接口
     */
    @GET("api/APPPM/GetMaterialItemsByPMAPP")
    Observable<String> getSearchMat(
            @Query("orderno") String orderNo,
            @Query("search") String search
    );

    /**
     * 获取材料商列表
     */
    @GET("api/APPProjectManger/GetSuppliersItemsToMatID")
    Observable<String> getMatMerchantList(
            @Query("matID") String matID
    );

    /**
     * 修改材料商界面
     */
    @POST("api/APPPM/CutoverSuppliersToShoppingCart")
    Observable<String> updMatMerchantInfo(
            @Body RequestBody json
    );

    /**
     * 获取购物车项目
     */
    @GET("api/APPPM/GetProInfoItemsByShoppingCart")
    Observable<String> getShopCartPro(
            @Query("uid") int uid
    );

    /**
     * 获取购物车数据
     */
    @GET("api/APPPM/GetMaterialItemsByShoppingCart")
    Observable<String> getShopCart(
            @Query("orderno") String orderNo
    );

    /**
     * 修改购物车选中状态
     */
    @POST("api/APPPM/CheckedMaterialToShoppingCart")
    Observable<String> updCheckedStatus(
            @Body RequestBody json
    );

    /**
     * 修改购物车附加费用
     */
    @POST("api/APPPM/SaveDistrbutionToShoppingCart")
    Observable<String> updSubjoin(
            @Body RequestBody json
    );

    /**
     * 移除购物车材料
     */
    @POST("api/APPPM/RemoveMaterialToShoppingCart")
    Observable<String> delMat(
            @Body RequestBody json
    );

    /**
     * 下单接口
     */
    @POST("api/APPPM/GenerateOrder")
    Observable<String> payment(
            @Body RequestBody json
    );

    /**
     * 获取待办项目列表
     */
    @GET("api/APPProjectManger/GetWorkorderDealtWithToMaterial")
    Observable<String> getOrdersPro(
            @Query("uid") int uid
    );

    /**
     * 获取订单列表
     */
//    @GET("api/APPProjectManger/GetWorkorderOrderToDealtWith")
    @GET("api/APPPM/GetWorkorderOrderItems")
    Observable<String> getOrdersList(
            @Query("orderno") String orderNo
    );

    /**
     * 获取订单详情
     */
    @GET("api/APPProjectManger/GetWorkorderOrderDetails")
    Observable<String> getOrdersDetail(
            @Query("orderID") String orderID
    );

    /**
     * 确认收货接口
     */
    @GET("api/APPProjectManger/UpdateOrderToReceipt")
    Observable<String> confirmOrders(
            @Query("orderID") String orderID
    );

    /**
     * 获取消息类型列表
     */
    @GET("api/APPMessage/APPGetApptuisongsMsgTypeCountByPmUser")
    Observable<String> getMsgType(
            @Query("uid") int uid
    );

    /**
     * 获取消息列表
     */
    @GET("api/APPMessage/APPGetApptuisongsByPmUserMsgType")
    Observable<String> getMsgList(
            @Query("uid") int uid,
            @Query("ts_msg_type") int typeID
    );

    /**
     * 获取消息详情
     */
    @GET("api/APPMessage/APPGetApptuisongDetail")
    Observable<String> getMsgDetail(
            @Query("ts_id") int tsID
    );

    /**
     * 获取证件照
     */
    @GET("api/PhoneSupervisor/GetArtPhoto")
    Observable<String> getPhotoImage(
            @Query("Uid") int tsID
    );

    /**
     * 获取工人头像
     */
    @GET("api/APPPM/WorkerImagePhoto")
    Observable<String> getWorkerPhotoImage(
            @Query("mobile") String moblie
    );

    /**
     * 获取回访项目列表
     */
    @GET("api/APPMessage/APPGetPMVisitOrderList")
    Observable<String> getVisitProList(
            @Query("uid") int uid
    );

    /**
     * 获取评价标签里列表
     */
    @GET("api/APPSuppliers/GetDistributionEvaluateMarkItems")
    Observable<String> getEvaluateMarks(
            @Query("eType") int eType
    );

    /**
     * 提交评价接口
     */
    @POST("api/APPProjectManger/SubmitEvaluateOrderByPMManager")
    Observable<String> subEvaluate(
            @Body RequestBody json
    );

    /**
     * 获取回访内容
     */
    @GET("api/APPMessage/APPGetPMVisitInfoList")
    Observable<String> getVisit(
            @Query("orderno") String orderNo
    );

    /**
     * 提交回访内容
     */
    @Multipart
    @POST("api/APPMessage/APPAddPMVisitInfo")
    Observable<String> subVisit(
            @Part("orderno") String orderNo,
            @Part("content") String content
    );

    /**
     * 获取摄像头列表
     */
    @GET("api/APPProjectManger/GetCameraByOrderno")
    Observable<String> getCameraList(
            @Query("orderno") String orderNo
    );

    /**
     * 根据状态获取摄像头列表
     *
     * @param areaID
     * @param uid
     * @param status 状态，0：空闲；1：使用中，100：所有
     * @return
     */
    @GET("api/APPProjectManger/GetEquipInfoByWhere")
    Observable<String> getCameraListByStatus(
            @Query("areaid") int areaID,
            @Query("uid") int uid,
            @Query("status") int status
    );

    /**
     * 获取摄像头数量
     */
    @GET("api/APPProjectManger/GetEquipCountByOrderno")
    Observable<String> getCameraCount(
            @Query("orderno") String orderNo
    );

    /**
     * 获取摄像头的在线状态
     */
    @GET("IntelligentWeak/getCameraState")
    Observable<String> getCameraLineStatus(
            @Query("projectId") String orderNo
    );

    /**
     * 获取摄像头异常列表
     */
    @POST("api/EngineeringDepartment/GetEquipmentAbnormal")
    Observable<String> getCameraAbnormalList(
            @Body RequestBody requestBody
    );

    //弱电抓拍请求
    @POST("api/EngineeringDepartment/ApplyCapture")
    Observable<String> getDebugData(
            @Body RequestBody requestBody
    );

    //弱电抓拍请求ApplyCaptureNoBind
    @POST("api/EngineeringDepartment/ApplyCaptureNoBind")
    Observable<String> getUnbindDebugData(
            @Body RequestBody requestBody
    );

    //弱电获取抓拍照片
    @POST("api/EngineeringDepartment/GetNewCapturePicture")
    Observable<String> getDebugImageData(
            @Body RequestBody requestBody
    );

    @GET("/api/APPProjectManger/GetAreaNameByOrderno")
    Observable<String> getAreaList(
            @Query("orderno") String orderNo
    );

    /**
     * 解绑摄像头
     */
    @GET("api/APPProjectManger/RecoveryCamera")
    Observable<String> unbindCamera(
            @Query("areaid") int areaID,
            @Query("orderno") String orderNo,
            @Query("uid") int uid,
            @Query("UserNo") String userNo,
            @Query("enumber") String eNumber,
            @Query("type") int type
    );

    //摄像头绑定区域信息  UpdateEquipmentUseAndPhoto
    @Multipart
    @POST("api/APPProjectManger/AddEquipmentUseAndPhoto")
    Observable<String> subCameraInfo(
            @Part("areaid") int areID,
            @Part("workorderno") String orderNo,
            @Part("equipmentno") String eNumber,
            @Part("equipmentname") String areaName,
            @Part("installstate") int installState,
            @Part("uid") int uid,
            @Part("userNo") String userNo,
            @Part("xingming") String userName,
            @Part MultipartBody.Part file
    );

    /**
     * 获取项目经理资料信息
     */
    @GET("api/PhoneSupervisor/ApiGetPersonFilesPictureByUid")
    Observable<String> getUploadInfo(
            @Query("Uid") int uid
    );

    /**
     * 获取银行卡列表接口
     */
    @GET("api/PhoneSupervisor/ApiGetDictionInfo")
    Observable<String> getBankList(

    );

    /**
     * 获取关系列表接口
     */
    @GET("api/PhoneSupervisor/ApiGetEmergencyRelation")
    Observable<String> getRelationList(

    );

    /**
     * 项目经理提交资料
     */
    @Multipart
    @POST("api/PhoneSupervisor/ApiSaveUploadFilesWithPmUserInfo")
    Observable<String> uploadInfo(
            @Part("Uid") int uid,
            @Part("Name") String name,
            @Part("IdCard") String idCard,
            @Part("BankCard") String bankCard,
            @Part("BankCardMaster") String bankCardMaster,
            @Part("BankType") String bankType,
            @Part("BankAddress") String bankAddress,
            @Part("EmergencyName") String emergencyName,
            @Part("EmergencyRelation") String emergencyRelation,
            @Part("Mobile") String mobile,
            @Part List<MultipartBody.Part> files
    );

    //mobile////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 获取工人信息
     */
    @GET("api/APPPM/GetPmWorkerMsg")
    Observable<String> getWorkerInfo(
            @Query("mobile") String mobile
    );

    /**
     * 获取银行信息
     */
    @GET("api/APPPM/GetBankType")
    Observable<String> getBankInfo(
    );

    /**
     * 获取工种信息
     */
    @GET("api/APPPM/GetWorkJob")
    Observable<String> getWorkInfo(
    );

    /**
     * 上传图片接口
     */
    @Multipart
    @POST("/api/APPPM/UpWorkerImageMsg")
    Observable<String> subImage(
            @Part("mobile") String mobile,
            @Part("ImgType") String ImgType,
            @Part List<MultipartBody.Part> files
    );


    /**
     * 上传图片接口
     */
    @Multipart
    @POST("api/APPPM/UpdateWorkerMsg")
    Observable<String> subData(
            @Part("mobile") String mobile,
            @Part("IdCard") String IdCard,
            @Part("BankCard") String BankCard,
            @Part("Bank") String Bank,
            @Part("BankAccountName") String BankAccountName,
            @Part("BankAddress") String BankAddress,
            @Part("RegisterPlace") String RegisterPlace,
            @Part("RefereeMobile") String RefereeMobile,
            @Part("Job") String Job
    );

    /**
     * 获取头像接口
     */
//    @Multipart
//    @POST("api/APPPM/WorkerImagePhoto")
    @GET("api/APPPM/WorkerImagePhoto")
    Observable<String> getIcon(
            @Query("mobile") String mobile
    );

    /**
     * 替换图片接口
     */
    @Multipart
    @POST("api/PhoneSupervisor/SavePMUserinfoUploadFilesByUid ")
    Observable<String> getUpdateIcon(
            @Part("AttrId") String AttrId,
            @Part("UId") String UId,
            @Part("Modelid") String Modelid,
            @Part MultipartBody.Part file
    );

    /**
     * 获取客户列表
     */
    @GET("api/PhoneApi/APP_GetProjectInfo")
    Observable<String> getCustomerlist(
            @Query("userID") String userID,
            @Query("CardNo") String CardNo,
            @Query("UserType") String UserType
    );

    /**
     * 获取客户列表详情
     */
    @GET("api/PhoneApi/APP_GetNewProjectDetails")
    Observable<String> getCustomerDlist(
            @Query("rwdID") String rwdID
    );

    /**
     * 获取分配客户列表详情
     */
    @GET("api/PhoneApi/APP_GetProjectDetails")
    Observable<String> getCustomerCDlist(
            @Query("rwdID") String rwdID,
            @Query("OrderType") int OrderType
    );
    /**
     * 上传洽谈结果
     */
    @Multipart
    @POST("api/PhoneApi/APP_UpdateState")
    Observable<String> postResultChat(
            @Part("pi_OrderId") String pi_OrderId,
            @Part("pi_Remarks") String pi_Remarks,
            @Part("pi_State") String pi_State,
            @Part List<MultipartBody.Part> files
    );

    /**
     * 项目经理添加洽谈项目
     */
    @GET("api/PhoneApi/APP_AddNewProject")
    Observable<String> addNewProject(
            @Query("pi_ClientName") String clientName,
            @Query("pi_ClientPhone") String clientPhone,
            @Query("pi_Name") String projectName,
            @Query("pi_Area") double projectArea,
            @Query("pi_ProjectType") int projectType,
            @Query("pi_State") int projectState,
            @Query("pi_Region") int mAreaId,
            @Query("pi_Uid") int mId,
            @Query("pi_UserName") String mName
    );
//    @GET("api/APPPM/WorkerImagePhoto")
//    Observable<String> getIcon(
//            @Query("mobile") String mobile
//    );

    /**
     * 项目经理添加洽谈项目
     */
    @GET("api/APPPM/GetWorkorderUserMatching")
    Observable<String> loadDataWork(
            @Query("workerid") int clientName

    );

    /**
     * 获取接单状态
     */
    @GET("api/APPPM/GetPmUserOrderReceivingInfo")
    Observable<String> getSubmit(
            @Query("uid") int uid

    );

    /**
     * 上传接单状态
     */

    @GET("api/APPPM/SavePmUserOrderReceivingInfo")
    Observable<String> postSubmit(
            @Query("startTime") String startTime,
            @Query("endTime") String endTime,
            @Query("summary") String summary,
            @Query("uid") int uid,
            @Query("state") int state
    );

    /**
     * 获取项目基本信息
     * http://wrapi.lm.cs/api/APPPM/GetProjectBasicInfomation
     */
    @GET("api/APPPM/GetProjectBasicInfomation")
    Observable<String> getReceiptData(
            @Query("orderno") String orderno,
            @Query("pmuid") int pmuid

    );

    //http://wrapi.lm.cs/api/APPPM/APPCheckPushStatus
    //项目经理操作（意向，议价，拒单，接单，退单）
    //pushstatus项目经理操作类型（1拒单 2意向 3议价 4退单 5接单）
    @Multipart
    @POST("api/APPPM/APPCheckPushStatus")
    Observable<String> getOperationData(
            @Part("orderno") String orderno,
            @Part("pmuid") int pmuid,
            @Part("pushstatus") int pushstatus,
            @Part("reason") String reason

    );
    /**api/APPPM/ShowAllProjectInfomations
     *项目经理确认接单后展示项目详细信息
     */
    @GET("api/APPPM/ShowAllProjectInfomations")
    Observable<String> getConfirmationReceipt(
            @Query("orderno") String orderno,
            @Query("pmuid") int pmuid

    );
    /**
     *工程施工图
     */
    @GET("api/APPPM/GetProjectConstructionDrawing")
    Observable<String> getEngineeringImage(
            @Query("orderno") String orderno

    );
    /**
     *工程效果图
     */
    @GET("api/APPPM/GetProjectEffectDrawing")
    Observable<String> getConstructiodrawing(
            @Query("orderno") String orderno

    );
    /**
     *安全生产协议
     */
    @GET("api/APPPM/GetProjectSafetyProtocol")
    Observable<String> getSafetprotocol(
            @Query("orderno") String orderno


    );
    /**api/APPPM/ShowAllProjectInfomations
     *装饰发包协议
     */
    @GET("api/APPPM/GetProjectDecorateProtocol")
    Observable<String> getDecorationcontract(
            @Query("orderno") String orderno


    );
    /**api/APPPM/ShowAllProjectInfomations
     *安全管理协议
     */
    @GET("api/APPPM/GetProjectSafetyManageProtocol")
    Observable<String> getSecurityProtocol(
            @Query("orderno") String orderno


    );
    /**api/APPPM/ShowAllProjectInfomations
     *效果图片地址
     */
    @GET("api/APPPM/GetProjectEffectDrawing")
    Observable<String> getEffectPicture(
            @Query("orderno") String orderno
    );
    /**api/APPPM/ShowAllProjectInfomations
     *施工图片地址
     */
    @GET("api/APPPM/GetProjectConstructionDrawing")
    Observable<String> getConstructionPicture(
            @Query("orderno") String orderno
    );
    /**api/APPPM/ShowAllProjectInfomations
     *施工量
     *///http://www.rxjy.com/api/values/QuoteArea?F_RWDID=31-99897
    @GET("api/values/QuoteArea")
    Observable<String> etQuoteIgtem(
            @Query("F_RWDID") String F_RWDID
    );
    /**
     * 得到列表分类详情
     *
     */
   // api/values/CostTotal
    @GET("api/values/GetQuoteItem")
    Observable<String> getTotalCost(
            @Query("F_RWDID") String F_RWDID,
            @Query("F_AREA_KEY") String F_AREA_KEY
    );
    //http://wrapi.lm.cs/api/APPPM/APPCheckPushStatus
    //项目经理操作（意向，议价，拒单，接单，退单）
    //pushstatus项目经理操作类型（1拒单 2意向 3议价 4退单 5接单）
    @Multipart
    @POST("api/APPPM/APPCheckPushStatus")
    Observable<String> getBarGainingData(
            @Part("orderno") String orderno,
            @Part("pmuid") int pmuid,
            @Part("pushstatus") int pushstatus,
            @Part("reason") String reason,
            @Part List<MultipartBody.Part> files
    );
}