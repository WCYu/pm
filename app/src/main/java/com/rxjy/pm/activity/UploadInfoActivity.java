package com.rxjy.pm.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.pm.R;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.utils.AutoUtils;
import com.rxjy.pm.entity.BankListInfo;
import com.rxjy.pm.entity.RelationListInfo;
import com.rxjy.pm.entity.UploadImageInfo;
import com.rxjy.pm.entity.UploadInfo;
import com.rxjy.pm.mvp.contract.UploadInfoContract;
import com.rxjy.pm.mvp.presenter.UploadInfoPresenter;
import com.rxjy.pm.widget.GlideRoundTransform;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

import static com.rxjy.pm.R.id.tv_name_line;

public class UploadInfoActivity extends BaseActivity<UploadInfoPresenter> implements UploadInfoContract.View {


    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_ic_card_up)
    ImageView ivIcCardUp;
    @Bind(R.id.tv_ic_card_up)
    TextView tvIcCardUp;
    @Bind(R.id.iv_ic_card_down)
    ImageView ivIcCardDown;
    @Bind(R.id.tv_ic_card_down)
    TextView tvIcCardDown;
    @Bind(R.id.iv_bank_up)
    ImageView ivBankUp;
    @Bind(R.id.tv_bank_up)
    TextView tvBankUp;
    @Bind(R.id.iv_medical_examination_report)
    ImageView ivMedicalExaminationReport;
    @Bind(R.id.tv_medical_examination_report)
    TextView tvMedicalExaminationReport;
    @Bind(R.id.rl_medical_examination_report)
    RelativeLayout rlMedicalExaminationReport;
    @Bind(R.id.iv_identification_photo)
    ImageView ivIdentificationPhoto;
    @Bind(R.id.tv_identification_photo)
    TextView tvIdentificationPhoto;
    @Bind(R.id.rl_identification_photo)
    RelativeLayout rlIdentificationPhoto;
    @Bind(R.id.iv_artistic_photo)
    ImageView ivArtisticPhoto;
    @Bind(R.id.tv_artistic_photo)
    TextView tvArtisticPhoto;
    @Bind(R.id.rl_artistic_photo)
    RelativeLayout rlArtisticPhoto;
    @Bind(R.id.rl_info)
    RelativeLayout rlInfo;
    @Bind(R.id.tv_name_text)
    TextView tvNameText;
    @Bind(R.id.et_name)
    EditText etName;
    @Bind(tv_name_line)
    TextView tvNameLine;
    @Bind(R.id.tv_ic_card_num_text)
    TextView tvIcCardNumText;
    @Bind(R.id.et_ic_card_num)
    EditText etIcCardNum;
    @Bind(R.id.tv_ic_card_num_line)
    TextView tvIcCardNumLine;
    @Bind(R.id.btn_upload_info)
    Button btnUploadInfo;
    @Bind(R.id.et_bank_num)
    EditText etBankNum;
    @Bind(R.id.tv_bank_num_line)
    TextView tvBankNumLine;
    @Bind(R.id.et_bank_master)
    EditText etBankMaster;
    @Bind(R.id.tv_bank_master_line)
    TextView tvBankMasterLine;
    @Bind(R.id.tv_bank_name)
    TextView tvBankName;
    @Bind(R.id.tv_bank_name_line)
    TextView tvBankNameLine;
    @Bind(R.id.et_bank_address)
    EditText etBankAddress;
    @Bind(R.id.tv_bank_address_line)
    TextView tvBankAddressLine;
    @Bind(R.id.et_emergency_contact)
    EditText etEmergencyContact;
    @Bind(R.id.tv_emergency_contact_line)
    TextView tvEmergencyContactLine;
    @Bind(R.id.tv_relation)
    TextView tvRelation;
    @Bind(R.id.tv_relation_line)
    TextView tvRelationLine;
    @Bind(R.id.et_phone)
    EditText etPhone;
    @Bind(R.id.tv_phone_line)
    TextView tvPhoneLine;

    public static final String TITLE = "个人资料";
    @Bind(R.id.iv_onestatus)
    ImageView ivOnestatus;
    @Bind(R.id.iv_twostatus)
    ImageView ivTwostatus;
    @Bind(R.id.iv_threestatus)
    ImageView ivThreestatus;
    @Bind(R.id.iv_fourstatus)
    ImageView ivFourstatus;
    @Bind(R.id.iv_sixstatus)
    ImageView ivSixstatus;
    @Bind(R.id.iv_fivestatus)
    ImageView ivFivestatus;
    @Bind(R.id.tv_staterd)
    TextView tvStaterd;

    private List<LocalMedia> medicalList = new ArrayList<>();

    private List<String> bankList;

    private List<BankListInfo.BankInfo> bankDataList;

    private List<String> relationList;

    private List<RelationListInfo.RelationInfo> relationDataList;

    //银行卡选择器
    private OptionsPickerView bankPicker;

    //关系选择器
    private OptionsPickerView relationPicker;

    private String name = "";

    private String icCardNum = "";

    private String bankNum = "";

    private String bankMaster = "";

    private String bankName = "";

    private String bankType;

    private String bankAddress = "";

    private String emergencyContact = "";

    private String relation = "";

    private String relationType;

    private String phone = "";

    private String icCardUpUrl = "";

    private String icCardDownUrl = "";

    private String bankUpUrl = "";

    private String medicalExaminationReportUrl = "";

    private String identificationPhotoUrl = "";

    private String artisticPhotoUrl = "";

    private int icCardUpPhotoView = 0;

    private int icCardDownPhotoView = 0;

    private int bankUpPhotoView = 0;

    private int medicalExaminationReportPhotoView = 0;

    private int identificationPhotoPhotoView = 0;

    private int artisticPhotoPhotoView = 0;

    private UploadImageInfo uploadImageInfo;

    public static UploadInfoActivity absuld;
    public String picupdate = "";
    private PopupWindow popupWindow;

    @Override
    public int getLayout() {
        return R.layout.activity_upload_info;
    }

    RequestOptions options;

    @Override
    public void initData() {
      //  PrefUtils.putBooleanValue(this,Constants.DATAMARK,false);
        options = new RequestOptions();
        options.centerCrop().transform(new GlideRoundTransform(this, 6));
        absuld = this;
        initTitle();
        createPopupWindow();
        initLine();
        initInfo();
        initBankPicker();
        initRelation();
        initUploadImage();

    }


    private void initTitle() {
        tvTitle.setText(TITLE);
        tvStaterd.setVisibility(View.VISIBLE);
        tvStaterd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //PopupWindow popupWindow=new PopupWindow(this, ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,false);
                darkenBackground(0.5f);
                popupWindow.showAtLocation(findViewById(R.id.show_popup), Gravity.CENTER, 0, 0);


            }
        });
    }

    private void   createPopupWindow(){
        View  popupView= getLayoutInflater().inflate(R.layout.upload_standard_popupwindow,null);
        ImageView imageView= (ImageView) popupView.findViewById(R.id.Upload_standard);
        popupWindow = new PopupWindow(popupView, AutoUtils.getDisplayWidthValue(660), AutoUtils.getDisplayHeightValue(800),true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#F8F8F8")));

        // TODO: 2016/5/17 设置可以获取焦点
        popupWindow.setFocusable(true);
        // TODO: 2016/5/17 设置可以触摸弹出框以外的区域
        popupWindow.setOutsideTouchable(true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                darkenBackground(1f);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(popupWindow.isShowing()){
                    popupWindow.dismiss();
                }
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (picupdate.equals("1")) {
            initInfo();
            picupdate = "";
        }

    }

    private void initLine() {

        EditText[] etArray = {etName, etIcCardNum, etBankNum, etBankMaster, etBankAddress, etEmergencyContact, etPhone};
        TextView[] tvArray = {tvNameLine, tvIcCardNumLine, tvBankNumLine, tvBankMasterLine, tvBankAddressLine, tvEmergencyContactLine, tvPhoneLine};

        lineSelector(etArray, tvArray);
    }

    private void initInfo() {
        mPresenter.getUploadInfo(App.pmUserInfo.getUid());
    }

    private void initBankPicker() {

        bankList = new ArrayList<>();

        bankDataList = new ArrayList<>();

        bankPicker = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                bankName = bankList.get(options1);
                bankType = bankDataList.get(options1).getDiccode();
                tvBankName.setText(bankName);
            }
        }).build();

        //获取银行卡列表
        mPresenter.getBankList();

    }

    private void initRelation() {

        relationList = new ArrayList<>();

        relationDataList = new ArrayList<>();

        relationPicker = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                relation = relationList.get(options1);
                relationType = relationDataList.get(options1).getKey();
                tvRelation.setText(relation);
            }
        }).build();

        //获取关系列表
        mPresenter.getRelationList();

    }

    private void initUploadImage() {

        uploadImageInfo = new UploadImageInfo();

    }


    private ArrayList<UploadInfo.Upload.PhotoInfo> listone;
    private ArrayList<UploadInfo.Upload.PhotoInfo> listtwo;
    private ArrayList<UploadInfo.Upload.PhotoInfo> listthree;
    private ArrayList<UploadInfo.Upload.PhotoInfo> listfour;
    private ArrayList<UploadInfo.Upload.PhotoInfo> listfive;
    private ArrayList<UploadInfo.Upload.PhotoInfo> listsix;

    int ispass, isout, nomsg;

    private void classifyType(UploadInfo.Upload data) {
        medicalList.clear();
        listone = new ArrayList<>();
        listtwo = new ArrayList<>();
        listthree = new ArrayList<>();
        listfour = new ArrayList<>();
        listfive = new ArrayList<>();
        listsix = new ArrayList<>();
        // 2 身份证正面 8 身份证反面 19 体检证明 1000 证件照 17 合作意向书
        for (UploadInfo.Upload.PhotoInfo info : data.getPhotoList()) {
            switch (info.getModelId()) {
                case 4:
                    pickind1 = 1;
                    icCardUpPhotoView = info.getCheckState();
                    icCardUpUrl = info.getPhotoUrl();
                    listone.add(info);
                    if (icCardUpPhotoView == 1) {//审核通过
                        ivOnestatus.setVisibility(View.VISIBLE);
                        ivOnestatus.setImageResource(R.mipmap.ic_pass);
                    } else if (icCardUpPhotoView == 2) {
                        ivOnestatus.setVisibility(View.VISIBLE);
                        ivOnestatus.setImageResource(R.mipmap.ic_out);
                    } else {//隐藏
                        ivOnestatus.setVisibility(View.GONE);
                    }
                    break;
                case 8:
                    pickind2 = 1;
                    icCardDownPhotoView = info.getCheckState();
                    icCardDownUrl = info.getPhotoUrl();
                    listtwo.add(info);
                    if (icCardDownPhotoView == 1) {//审核通过
                        ivTwostatus.setVisibility(View.VISIBLE);
                        ivTwostatus.setImageResource(R.mipmap.ic_pass);
                    } else if (icCardDownPhotoView == 2) {
                        ivTwostatus.setVisibility(View.VISIBLE);
                        ivTwostatus.setImageResource(R.mipmap.ic_out);
                    } else {//隐藏
                        ivTwostatus.setVisibility(View.GONE);
                    }
                    break;
                case 9:
                    pickind3 = 1;
                    bankUpPhotoView = info.getCheckState();
                    bankUpUrl = info.getPhotoUrl();
                    listthree.add(info);
                    if (bankUpPhotoView == 1) {//审核通过
                        ivThreestatus.setVisibility(View.VISIBLE);
                        ivThreestatus.setImageResource(R.mipmap.ic_pass);
                    } else if (bankUpPhotoView == 2) {
                        ivThreestatus.setVisibility(View.VISIBLE);
                        ivThreestatus.setImageResource(R.mipmap.ic_out);
                    } else {//隐藏
                        ivThreestatus.setVisibility(View.GONE);
                    }
                    break;
                case 19:
                    pickind4 = 1;
                    medicalExaminationReportPhotoView = info.getCheckState();
                    LocalMedia lmMedical = new LocalMedia();
                    lmMedical.setPath(info.getPhotoUrl());
                    medicalList.add(lmMedical);
                    listfour.add(info);
                    switch (medicalExaminationReportPhotoView) {
                        case 1:
                            ispass = 1;
                            break;
                        case 2:
                            isout = 1;
                            break;
                        default:
                            nomsg = 1;
                            break;
                    }
                    break;
                case 1000:
                    pickind6 = 1;
                    identificationPhotoPhotoView = info.getCheckState();
                    identificationPhotoUrl = info.getPhotoUrl();
                    listsix.add(info);
                    if (identificationPhotoPhotoView == 1) {//审核通过
                        ivSixstatus.setVisibility(View.VISIBLE);
                        ivSixstatus.setImageResource(R.mipmap.ic_pass);
                    } else if (identificationPhotoPhotoView == 2) {
                        ivSixstatus.setVisibility(View.VISIBLE);
                        ivSixstatus.setImageResource(R.mipmap.ic_out);
                    } else {//隐藏
                        ivSixstatus.setVisibility(View.GONE);
                    }
                    break;
                case 1001:
                    pickind5 = 1;
                    artisticPhotoPhotoView = info.getCheckState();
                    artisticPhotoUrl = info.getPhotoUrl();
                    listfive.add(info);
                    if (artisticPhotoPhotoView == 1) {//审核通过
                        ivFivestatus.setVisibility(View.VISIBLE);
                        ivFivestatus.setImageResource(R.mipmap.ic_pass);
                    } else if (artisticPhotoPhotoView == 2) {
                        ivFivestatus.setVisibility(View.VISIBLE);
                        ivFivestatus.setImageResource(R.mipmap.ic_out);
                    } else {//隐藏
                        ivFivestatus.setVisibility(View.GONE);
                    }
                    break;
            }
        }

        if (isout == 1) {
            ivFourstatus.setVisibility(View.VISIBLE);
            ivFourstatus.setImageResource(R.mipmap.ic_out);
        } else if (isout != 1 && ispass == 1) {
            ivFourstatus.setVisibility(View.VISIBLE);
            ivFourstatus.setImageResource(R.mipmap.ic_pass);
        } else {
            ivFourstatus.setVisibility(View.GONE);
        }

        if (medicalList.size() != 0) {
            medicalExaminationReportUrl = medicalList.get(0).getPath();
        }

    }

    @Override
    protected UploadInfoPresenter onCreatePresenter() {
        return new UploadInfoPresenter(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
            switch (requestCode) {
                case Constants.CAMERA_INFO_IC_CARD_UP:
                    icCardUpUrl = localMedias.get(0).getCompressPath();
                    Glide.with(this).load(icCardUpUrl).apply(options).into(ivIcCardUp);
                    uploadImageInfo.setIcCardUp(icCardUpUrl);
                    break;
                case Constants.CAMERA_INFO_IC_CARD_DOWN:
                    icCardDownUrl = localMedias.get(0).getCompressPath();
                    Glide.with(this).load(icCardDownUrl).apply(options).into(ivIcCardDown);
                    uploadImageInfo.setIcCardDown(icCardDownUrl);
                    break;
                case Constants.CAMERA_INFO_BANK_UP:
                    bankUpUrl = localMedias.get(0).getCompressPath();
                    Glide.with(this).load(bankUpUrl).apply(options).into(ivBankUp);
                    uploadImageInfo.setBankCardUp(bankUpUrl);
                    break;
                case Constants.CAMERA_INFO_MEDICAL_EXAMINATION_REPORT:
                    medicalExaminationReportUrl = localMedias.get(0).getCompressPath();
                    Glide.with(this).load(medicalExaminationReportUrl).apply(options).into(ivMedicalExaminationReport);
                    uploadImageInfo.setMedicalExaminationReport(localMedias);
                    break;
                case Constants.CAMERA_INFO_IDENTIFICATION_PHOTO:
                    identificationPhotoUrl = localMedias.get(0).getCompressPath();
                    Glide.with(this).load(identificationPhotoUrl).apply(options).into(ivIdentificationPhoto);
                    uploadImageInfo.setIdentificationPhoto(identificationPhotoUrl);
                    break;
                case Constants.CAMERA_INFO_ARTISTIC_PHOTO:
                    artisticPhotoUrl = localMedias.get(0).getCompressPath();
                    Glide.with(this).load(artisticPhotoUrl).apply(options).into(ivArtisticPhoto);
                    uploadImageInfo.setArtisticPhoto(artisticPhotoUrl);
                    break;
            }
        }
    }


    int pickind1, pickind2, pickind3, pickind4, pickind5, pickind6;

    @OnClick({R.id.iv_back, R.id.rl_ic_card_up, R.id.rl_ic_card_down, R.id.rl_bank_up, R.id.rl_medical_examination_report, R.id.rl_identification_photo, R.id.rl_artistic_photo, R.id.tv_bank_name, R.id.tv_relation, R.id.btn_upload_info})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_ic_card_up:
                if (pickind1 != 1) {
                    // 进入相册 以下是例子：用不到的api可以不写
                    PictureSelector.create(this)
                            .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                            .imageSpanCount(3)// 每行显示个数 int
                            .maxSelectNum(1)// 最大图片选择数量 int
                            .minSelectNum(1)// 最小选择数量 int
                            .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                            .compress(true)// 是否压缩 true or fals
                            .isCamera(true)// 是否显示拍照按钮 true or false
                            .forResult(Constants.CAMERA_INFO_IC_CARD_UP);//结果回调onActivityResult code 
                } else {
                    startActivity(new Intent(this, ImageShowActivity.class).putExtra("images", listone).putExtra("title", "身份证正面").putExtra("type", "4"));
                }
                break;
            case R.id.rl_ic_card_down:
                if (pickind2 != 1) {
                    // 进入相册 以下是例子：用不到的api可以不写
                    PictureSelector.create(this)
                            .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                            .imageSpanCount(3)// 每行显示个数 int
                            .maxSelectNum(1)// 最大图片选择数量 int
                            .minSelectNum(1)// 最小选择数量 int
                            .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                            .compress(true)// 是否压缩 true or fals
                            .isCamera(true)// 是否显示拍照按钮 true or false
                            .forResult(Constants.CAMERA_INFO_IC_CARD_DOWN);//结果回调onActivityResult code 
                } else {
                    startActivity(new Intent(this, ImageShowActivity.class).putExtra("images", listtwo).putExtra("title", "身份证反面").putExtra("type", "8"));
                }
                break;
            case R.id.rl_bank_up:
                if (pickind3 != 1) {
                    // 进入相册 以下是例子：用不到的api可以不写
                    PictureSelector.create(this)
                            .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                            .imageSpanCount(3)// 每行显示个数 int
                            .maxSelectNum(1)// 最大图片选择数量 int
                            .minSelectNum(1)// 最小选择数量 int
                            .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                            .compress(true)// 是否压缩 true or fals
                            .isCamera(true)// 是否显示拍照按钮 true or false
                            .forResult(Constants.CAMERA_INFO_BANK_UP);//结果回调onActivityResult code 
                } else {
                    startActivity(new Intent(this, ImageShowActivity.class).putExtra("images", listthree).putExtra("title", "银行卡正面").putExtra("type", "9"));
                }
                break;
            case R.id.rl_medical_examination_report:
                if (pickind4 != 1) {
                    // 进入相册 以下是例子：用不到的api可以不写
                    PictureSelector.create(this)
                            .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                            .imageSpanCount(3)// 每行显示个数 int
                            .maxSelectNum(10)// 最大图片选择数量 int
                            .minSelectNum(1)// 最小选择数量 int
                            .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                            .compress(true)// 是否压缩 true or fals
                            .isCamera(true)// 是否显示拍照按钮 true or false
                            .forResult(Constants.CAMERA_INFO_MEDICAL_EXAMINATION_REPORT);//结果回调onActivityResult code 
                } else {
                    startActivity(new Intent(this, ImageShowActivity.class).putExtra("images", listfour).putExtra("title", "体检报告").putExtra("type", "19"));
                }
                break;
            case R.id.rl_identification_photo:
                if (pickind6 != 1) {
                    // 进入相册 以下是例子：用不到的api可以不写
                    PictureSelector.create(this)
                            .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                            .imageSpanCount(3)// 每行显示个数 int
                            .maxSelectNum(1)// 最大图片选择数量 int
                            .minSelectNum(1)// 最小选择数量 int
                            .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                            .compress(true)// 是否压缩 true or fals
                            .isCamera(true)// 是否显示拍照按钮 true or false
                            .forResult(Constants.CAMERA_INFO_IDENTIFICATION_PHOTO);//结果回调onActivityResult code 
                } else {
                    startActivity(new Intent(this, ImageShowActivity.class).putExtra("images", listsix).putExtra("title", "证件照").putExtra("type", "1000"));
                }
                break;
            case R.id.rl_artistic_photo:
                if (pickind5 != 1) {
                    // 进入相册 以下是例子：用不到的api可以不写
                    PictureSelector.create(this)
                            .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                            .imageSpanCount(3)// 每行显示个数 int
                            .maxSelectNum(1)// 最大图片选择数量 int
                            .minSelectNum(1)// 最小选择数量 int
                            .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                            .compress(true)// 是否压缩 true or fals
                            .isCamera(true)// 是否显示拍照按钮 true or false
                            .forResult(Constants.CAMERA_INFO_ARTISTIC_PHOTO);//结果回调onActivityResult code 
                } else {
                    startActivity(new Intent(this, ImageShowActivity.class).putExtra("images", listfive).putExtra("title", "艺术照").putExtra("type", "1001"));
                }
                break;
            case R.id.tv_bank_name:
                bankPicker.show();
                break;
            case R.id.tv_relation:
                relationPicker.show();
                break;
            case R.id.btn_upload_info:
                name = etName.getText().toString().trim();
                icCardNum = etIcCardNum.getText().toString().trim();
                bankNum = etBankNum.getText().toString().trim();
                bankMaster = etBankMaster.getText().toString().trim();
                bankAddress = etBankAddress.getText().toString().trim();
                emergencyContact = etEmergencyContact.getText().toString().trim();
                phone = etPhone.getText().toString().trim();
                if (pickind1 != 1) {
//                if (icCardUpPhotoView != 1) {
                    if (uploadImageInfo.getIcCardUp() == null || uploadImageInfo.getIcCardUp().equals("")) {
                        showToast("请选择身份证正面");
                        return;
                    }
                }
                if (pickind2 != 1) {
//                if (icCardDownPhotoView != 1) {
                    if (uploadImageInfo.getIcCardDown() == null || uploadImageInfo.getIcCardDown().equals("")) {
                        showToast("请选择身份证反面");
                        return;
                    }
                }
                if (pickind3 != 1) {
//                if (bankUpPhotoView != 1) {
                    if (uploadImageInfo.getBankCardUp() == null || uploadImageInfo.getBankCardUp().equals("")) {
                        showToast("请选择银行卡正面");
                        return;
                    }
                }
                if (pickind4 != 1) {
//                if (medicalExaminationReportPhotoView != 1) {
                    if (uploadImageInfo.getMedicalExaminationReport() == null || uploadImageInfo.getMedicalExaminationReport().size() == 0) {
                        showToast("请选择体检报告");
                        return;
                    }
                }
                if (pickind5 != 1) {
//                if (artisticPhotoPhotoView != 1) {
                    if (uploadImageInfo.getArtisticPhoto() == null || uploadImageInfo.getArtisticPhoto().equals("")) {
                        showToast("请选择艺术照");
                        return;
                    }
                }
                if (pickind6 != 1) {
//                if (identificationPhotoPhotoView != 1) {
                    if (uploadImageInfo.getIdentificationPhoto() == null || uploadImageInfo.getIdentificationPhoto().equals("")) {
                        showToast("请选择证件照");
                        return;
                    }
                }
                if (name.equals("")) {
                    showToast("请输入姓名");
                    return;
                }
                if (icCardNum.equals("")) {
                    showToast("请输入身份证号");
                    return;
                }
                if (bankNum.equals("")) {
                    showToast("请输入银行账号");
                    return;
                }
                if (bankMaster.equals("")) {
                    showToast("请输入开户人");
                    return;
                }
                if (bankName.equals("")) {
                    showToast("请选择开户行");
                    return;
                }
                if (bankAddress.equals("")) {
                    showToast("请输入开户行地址");
                    return;
                }
                if (emergencyContact.equals("")) {
                    showToast("请输入紧急联系人");
                    return;
                }
                if (relation.equals("")) {
                    showToast("请选择关系");
                    return;
                }
                if (phone.equals("")) {
                    showToast("请输入电话");
                    return;
                }
                mPresenter.uploadInfo(App.pmUserInfo.getUid(), name, icCardNum, bankNum, bankMaster, bankType, bankAddress, emergencyContact, relationType, phone, uploadImageInfo);
                break;
        }
    }

    @Override
    public void responseInfoSubData() {
        finish();
    }

    @Override
    public void responseInfoSubDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseRelationData(List<RelationListInfo.RelationInfo> dataList) {
        relationList.clear();
        for (RelationListInfo.RelationInfo info : dataList) {
            relationList.add(info.getRelation());
            relationDataList.add(info);
        }
        relationPicker.setPicker(relationList);
    }

    @Override
    public void responseRelationDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseBankListData(List<BankListInfo.BankInfo> dataList) {
        bankList.clear();
        bankDataList.clear();
        for (BankListInfo.BankInfo info : dataList) {
            bankList.add(info.getDicname());
            bankDataList.add(info);
        }
        bankPicker.setPicker(bankList);
    }

    @Override
    public void responseBankListDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseUploadInfoData(UploadInfo.Upload data) {
        if (!data.isIsSubmit()) {
            etName.setEnabled(false);
            etIcCardNum.setEnabled(false);
            etBankNum.setEnabled(false);
            etBankMaster.setEnabled(false);
            tvBankName.setEnabled(false);
            etBankAddress.setEnabled(false);
            etEmergencyContact.setEnabled(false);
            tvRelation.setEnabled(false);
            etPhone.setEnabled(false);
            tvNameLine.setEnabled(false);
            tvIcCardNumLine.setEnabled(false);
            tvBankNumLine.setEnabled(false);
            tvBankMasterLine.setEnabled(false);
            tvBankNameLine.setEnabled(false);
            tvBankAddressLine.setEnabled(false);
            tvEmergencyContactLine.setEnabled(false);
            tvRelationLine.setEnabled(false);
            tvPhoneLine.setEnabled(false);
            btnUploadInfo.setEnabled(false);
            btnUploadInfo.setVisibility(View.GONE);
        } else {
            btnUploadInfo.setVisibility(View.VISIBLE);
        }
        bankType = data.getBankTypeKey() + "";
        relationType = data.getEmergencyRelationKey() + "";
        name = data.getName();
        icCardNum = data.getIdCard();
        bankNum = data.getBankCard();
        bankMaster = data.getBankCardMaster();
        bankName = data.getBankType();
        bankAddress = data.getBankAddress();
        emergencyContact = data.getEmergencyName();
        relation = data.getEmergencyRelation();
        phone = data.getMobile();
        etName.setText(name);
        etIcCardNum.setText(icCardNum);
        etBankNum.setText(bankNum);
        etBankMaster.setText(bankMaster);
        tvBankName.setText(bankName);
        etBankAddress.setText(bankAddress);
        etEmergencyContact.setText(emergencyContact);
        tvRelation.setText(relation);
        etPhone.setText(phone);
        //将照片分类
        classifyType(data);

        Glide.with(this).load(icCardUpUrl).apply(new RequestOptions().error(R.mipmap.ic_card_up_icon)).apply(options).into(ivIcCardUp);
        Glide.with(this).load(icCardDownUrl).apply(new RequestOptions().error(R.mipmap.ic_card_down_icon)).apply(options).into(ivIcCardDown);
        Glide.with(this).load(bankUpUrl).apply(new RequestOptions().error(R.mipmap.bank_card_up_icon)).apply(options).into(ivBankUp);
        Glide.with(this).load(medicalExaminationReportUrl).apply(new RequestOptions().error(R.mipmap.medical_examination_report_icon)).apply(options).into(ivMedicalExaminationReport);
        Glide.with(this).load(identificationPhotoUrl).apply(new RequestOptions().error(R.mipmap.identification_photo_icon)).apply(options).into(ivIdentificationPhoto);
        Glide.with(this).load(artisticPhotoUrl).apply(new RequestOptions().error(R.mipmap.artistic_photo_icon)).apply(options).into(ivArtisticPhoto);
    }

    @Override
    public void responseUploadInfoDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
    }
    /**
     * 改变背景颜色
     */
    private void darkenBackground(Float bgcolor){
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgcolor;

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setAttributes(lp);

    }

}
