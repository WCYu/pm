package com.rxjy.pm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bumptech.glide.Glide;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.pm.R;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.entity.BankBean;
import com.rxjy.pm.entity.IconBean;
import com.rxjy.pm.entity.UploadInfo;
import com.rxjy.pm.entity.WorkerPersonDBean;
import com.rxjy.pm.mvp.contract.WorkerPersonDContract;
import com.rxjy.pm.mvp.presenter.WorkerPersonDPresenter;
import com.rxjy.pm.widget.OkhttpUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/2/23.
 */

public class AccountDataActivity extends BaseActivity<WorkerPersonDPresenter> implements WorkerPersonDContract.View {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_add)
    ImageView ivAdd;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_ic_card_up)
    ImageView ivIcCardUp;
    @Bind(R.id.tv_ic_card_up)
    TextView tvIcCardUp;
    @Bind(R.id.rl_ic_card_up)
    RelativeLayout rlIcCardUp;
    @Bind(R.id.iv_ic_card_down)
    ImageView ivIcCardDown;
    @Bind(R.id.tv_ic_card_down)
    TextView tvIcCardDown;
    @Bind(R.id.rl_ic_card_down)
    RelativeLayout rlIcCardDown;
    @Bind(R.id.iv_bank_up)
    ImageView ivBankUp;
    @Bind(R.id.tv_bank_up)
    TextView tvBankUp;
    @Bind(R.id.rl_bank_up)
    RelativeLayout rlBankUp;
    @Bind(R.id.iv_artistic_photo)
    ImageView ivArtisticPhoto;
    @Bind(R.id.tv_artistic_photo)
    TextView tvArtisticPhoto;
    @Bind(R.id.rl_artistic_photo)
    RelativeLayout rlArtisticPhoto;
    @Bind(R.id.tv_idcard)
    TextView tvIdcard;
    @Bind(R.id.et_idcard)
    EditText etIdcard;
    @Bind(R.id.tv_idcard_line)
    TextView tvIdcardLine;
    @Bind(R.id.tv_bankcard)
    TextView tvBankcard;
    @Bind(R.id.et_bankcard)
    EditText etBankcard;
    @Bind(R.id.tv_bankcard_line)
    TextView tvBankcardLine;
    @Bind(R.id.tv_bankname)
    TextView tvBankname;
    @Bind(R.id.et_bankname)
    TextView etBankname;
    @Bind(R.id.tv_bankname_line)
    TextView tvBanknameLine;
    @Bind(R.id.rl_bankname)
    RelativeLayout rlBankname;
    @Bind(R.id.tv_bankusername)
    TextView tvBankusername;
    @Bind(R.id.et_bankusername)
    EditText etBankusername;
    @Bind(R.id.tv_bankusername_line)
    TextView tvBankusernameLine;
    @Bind(R.id.tv_bankaddress)
    TextView tvBankaddress;
    @Bind(R.id.et_bankaddress)
    EditText etBankaddress;
    @Bind(R.id.tv_bankaddress_line)
    TextView tvBankaddressLine;
    @Bind(R.id.tv_address)
    TextView tvAddress;
    @Bind(R.id.et_address)
    EditText etAddress;
    @Bind(R.id.tv_address_line)
    TextView tvAddressLine;
    @Bind(R.id.tv_person)
    TextView tvPerson;
    @Bind(R.id.et_person)
    EditText etPerson;
    @Bind(R.id.tv_person_line)
    TextView tvPersonLine;
    @Bind(R.id.tv_workkind)
    TextView tvWorkkind;
    @Bind(R.id.et_workkind)
    TextView etWorkkind;
    @Bind(R.id.tv_workkind_line)
    TextView tvWorkkindLine;
    @Bind(R.id.rl_workkind)
    RelativeLayout rlWorkkind;
    @Bind(R.id.btn_upload_info)
    Button btnUploadInfo;
    @Bind(R.id.show_popup)
    RelativeLayout showPopup;

    private OptionsPickerView bankpicker;
    private OptionsPickerView workpicker;

    private String idcardpicone = "", idcardpictwo = "", bankpic = "", photopic = "";

    private int idcardonestatue = 0, idcardtwostatue = 0, bankstatue = 0, photostatue = 0;

    private int picone, pictwo, picthree, picfour;


    @Override
    public int getLayout() {
        return R.layout.activity_accountdata;
    }

    @Override
    public void initData() {
        tvTitle.setText("账户信息");
        mPresenter.getData(App.workerInfo.getMobile());
        urllist = new ArrayList<>();
        initBankPicker();
        initWorkPicker();
    }

    /**
     * 银行卡列表
     */
    private ArrayList<BankBean.BankItem> banklist;
    private ArrayList<String> bankslist;

    private void initBankPicker() {
        banklist = new ArrayList<>();
        bankslist = new ArrayList<>();
        bankpicker = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                banknamen = banklist.get(options1).getValue();
                etBankname.setText(bankslist.get(options1));
            }
        }).build();
        mPresenter.getBankData();
    }

    /**
     * 工种列表
     */
    private ArrayList<BankBean.BankItem> worklist;
    private ArrayList<String> workslist;

    private void initWorkPicker() {
        worklist = new ArrayList<>();
        workslist = new ArrayList<>();
        workpicker = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                workkindn = worklist.get(options1).getValue();
                etWorkkind.setText(workslist.get(options1));
            }
        }).build();
        mPresenter.getWorkData();
    }


    @Override
    protected WorkerPersonDPresenter onCreatePresenter() {
        return new WorkerPersonDPresenter(this);
    }

    @Override
    public void responsegetData(WorkerPersonDBean info) {

        if (info.getBody().getIdCard() != null)
            etIdcard.setText(info.getBody().getIdCard());
        if (info.getBody().getBankCard() != null)
            etBankcard.setText(info.getBody().getBankCard());
        if (info.getBody().getBank() != null) {
            etBankname.setText(info.getBody().getBank());
            banknamen = info.getBody().getBankId() + "";
        }
        if (info.getBody().getBankAccountName() != null)
            etBankusername.setText(info.getBody().getBankAccountName());
        if (info.getBody().getBankAddress() != null)
            etBankaddress.setText(info.getBody().getBankAddress());
        if (info.getBody().getRegisterPlace() != null)
            etAddress.setText(info.getBody().getRegisterPlace());
        if (info.getBody().getRefereeMobile() != null)
            etPerson.setText(info.getBody().getRefereeMobile());
        if (info.getBody().getJob() != null) {
            etWorkkind.setText(info.getBody().getJob());
            workkindn = info.getBody().getJobId() + "";
        }
         Log.e("tag","sssssssssssssss");
        for (int i = 0; i < info.getBody().getImageType().size(); i++) {
            if (info.getBody().getImageType().get(i).getUrl() != null) {
                switch (info.getBody().getImageType().get(i).getType()) {
                    case 9:
                        Glide.with(this).load(info.getBody().getImageType().get(i).getUrl()).into(ivBankUp);
                        bankstatue = info.getBody().getImageType().get(i).getState();
                        bankpic = info.getBody().getImageType().get(i).getUrl();
                        picthree = 1;
                        break;
                    case 4:
                        Glide.with(this).load(info.getBody().getImageType().get(i).getUrl()).into(ivIcCardUp);
                        idcardonestatue = info.getBody().getImageType().get(i).getState();
                        idcardpicone = info.getBody().getImageType().get(i).getUrl();
                        picone = 1;
                        break;
                    case 8:
                        Glide.with(this).load(info.getBody().getImageType().get(i).getUrl()).into(ivIcCardDown);
                        idcardtwostatue = info.getBody().getImageType().get(i).getState();
                        idcardpictwo = info.getBody().getImageType().get(i).getUrl();
                        pictwo = 1;
                        break;
                    case 12:
                        Glide.with(this).load(info.getBody().getImageType().get(i).getUrl()).into(ivArtisticPhoto);
                        photostatue = info.getBody().getImageType().get(i).getState();
                        photopic = info.getBody().getImageType().get(i).getUrl();
                        picfour = 1;
                        break;
                }
            }
        }
        Log.e("tag", info.getBody().isOperation() + "");
        if (info.getBody().isOperation()) {

            btnUploadInfo.setVisibility(View.GONE);
            etIdcard.setEnabled(false);
            etBankcard.setEnabled(false);
            etBankname.setEnabled(false);
            etBankusername.setEnabled(false);
            etBankaddress.setEnabled(false);
            etAddress.setEnabled(false);
            etPerson.setEnabled(false);
            etWorkkind.setEnabled(false);
            rlWorkkind.setEnabled(false);
            rlBankname.setEnabled(false);
        } else {
            btnUploadInfo.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public void responsegetDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responsegetBankData(BankBean info) {
        banklist.clear();
        bankslist.clear();
        banklist = info.getBody();
        for (int i = 0; i < info.getBody().size(); i++) {
            if (info.getBody().get(i).getKey() != null) {
                bankslist.add(info.getBody().get(i).getKey());
            }
        }
        bankpicker.setPicker(bankslist);
    }

    @Override
    public void responsegetBankDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responsegetWorkData(BankBean info) {
        worklist.clear();
        workslist.clear();
        worklist = info.getBody();
        for (int i = 0; i < info.getBody().size(); i++) {
            if (info.getBody().get(i).getKey() != null) {
                workslist.add(info.getBody().get(i).getKey());
            }
        }
        workpicker.setPicker(workslist);
    }

    @Override
    public void responsegetWorkDataError(String msg) {
        showToast(msg);
    }

    int showtype = 100;

    @Override
    public void responsegetImgData() {
        switch (showtype) {
            case 0:
                showtype = 100;
                picone = 1;
                Glide.with(this).load(idcardpicone).into(ivIcCardUp);
                break;
            case 1:
                showtype = 100;
                pictwo = 1;
                Glide.with(this).load(idcardpictwo).into(ivIcCardDown);
                break;
            case 2:
                picthree = 1;
                showtype = 100;
                Glide.with(this).load(bankpic).into(ivBankUp);
                break;
            case 3:
                showtype = 100;
                picfour = 1;
                Glide.with(this).load(photopic).into(ivArtisticPhoto);
                break;
        }
    }

    @Override
    public void responsegetImgDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responsegetSubmitData() {
        showToast("上传成功！");
        //PrefUtils.putBooleanValue(this, Constants.DATAMARK,false);
        finish();
    }

    @Override
    public void responsegetSubmitDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responsegetIconData(IconBean info) {

    }


    @Override
    public void responsegetIconDataError(String msg) {

    }

    @Override
    public void getUploadInfo(UploadInfo.Upload data) {

    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
    }


    @OnClick({R.id.iv_back, R.id.rl_ic_card_up, R.id.rl_ic_card_down, R.id.rl_bank_up, R.id.rl_artistic_photo, R.id.rl_bankname, R.id.rl_workkind, R.id.btn_upload_info})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_ic_card_up:
                if (idcardonestatue != 1) {
                    // 进入相册 以下是例子：用不到的api可以不写
                    PictureSelector.create(this)
                            .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                            .imageSpanCount(3)// 每行显示个数 int
                            .maxSelectNum(1)// 最大图片选择数量 int
                            .minSelectNum(1)// 最小选择数量 int
                            .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                            .compress(true)// 是否压缩 true or fals
                            .isCamera(true)// 是否显示拍照按钮 true or false
                            .forResult(99);//结果回调onActivityResult code 
                } else {
                    photoPreview(idcardpicone);
                }
                break;
            case R.id.rl_ic_card_down:
                if (idcardtwostatue != 1) {
                    // 进入相册 以下是例子：用不到的api可以不写
                    PictureSelector.create(this)
                            .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                            .imageSpanCount(3)// 每行显示个数 int
                            .maxSelectNum(1)// 最大图片选择数量 int
                            .minSelectNum(1)// 最小选择数量 int
                            .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                            .compress(true)// 是否压缩 true or fals
                            .isCamera(true)// 是否显示拍照按钮 true or false
                            .forResult(100);//结果回调onActivityResult code 
                } else {
                    photoPreview(idcardpictwo);
                }
                break;
            case R.id.rl_bank_up:
                if (bankstatue != 1) {
                    // 进入相册 以下是例子：用不到的api可以不写
                    PictureSelector.create(this)
                            .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                            .imageSpanCount(3)// 每行显示个数 int
                            .maxSelectNum(1)// 最大图片选择数量 int
                            .minSelectNum(1)// 最小选择数量 int
                            .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                            .compress(true)// 是否压缩 true or fals
                            .isCamera(true)// 是否显示拍照按钮 true or false
                            .forResult(101);//结果回调onActivityResult code 
                } else {
                    photoPreview(bankpic);
                }
                break;
            case R.id.rl_artistic_photo:
                if (photostatue != 1) {
                    // 进入相册 以下是例子：用不到的api可以不写
                    PictureSelector.create(this)
                            .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                            .imageSpanCount(3)// 每行显示个数 int
                            .maxSelectNum(1)// 最大图片选择数量 int
                            .minSelectNum(1)// 最小选择数量 int
                            .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                            .compress(true)// 是否压缩 true or fals
                            .isCamera(true)// 是否显示拍照按钮 true or false
                            .forResult(102);//结果回调onActivityResult code 
                } else {
                    photoPreview(photopic);
                }
                break;
            case R.id.rl_bankname:
                bankpicker.show();
                break;
            case R.id.rl_workkind:
                workpicker.show();
                break;
            case R.id.btn_upload_info:
                //提交数据
                submitData();
                break;
        }
    }

    /**
     * 提交数据
     */
    private String idcardnum, banknum, bankname, bankuser, bankaddress, address, person, workkind;
    private String banknamen, workkindn;

    private void submitData() {
        idcardnum = etIdcard.getText().toString();
        banknum = etBankcard.getText().toString();
        bankname = etBankname.getText().toString();
        bankuser = etBankusername.getText().toString();
        bankaddress = etBankaddress.getText().toString();
        address = etAddress.getText().toString();
        person = etPerson.getText().toString();
        workkind = etWorkkind.getText().toString();
        if (picone != 1 || pictwo != 1 || picthree != 1 || picfour != 1 || idcardnum.isEmpty() || banknum.isEmpty() || bankname.isEmpty() || bankname.equals("请选择") || bankuser.isEmpty() || bankaddress.isEmpty() || address.isEmpty() || workkind.isEmpty() || workkind.equals("请选择")) {
            showToast("资料未全部调整");
        } else {
            mPresenter.getsubmit(App.cardNo, idcardnum, banknum, banknamen, bankuser, bankaddress, address, person, workkindn);
        }
//        if (picone != 1)
//            showToast("请上传身份证正面！");
//        if (pictwo != 1)
//            showToast("请上传身份证反面！");
//        if (picthree != 1)
//            showToast("请上传银行卡正面！");
//        if (picfour != 1)
//            showToast("请上传形象照！");
//        if (idcardnum.isEmpty())
//            showToast("请填写身份证号！");
//        if (banknum.isEmpty())
//            showToast("请填写银行卡号！");
//        if (bankname.isEmpty() || bankname.equals("请选择"))
//            showToast("请填写开户行！");
//        if (bankuser.isEmpty())
//            showToast("请填写开户名！");
//        if (bankaddress.isEmpty())
//            showToast("请填写开户行地址！");
//        if (address.isEmpty())
//            showToast("请填写籍贯！");
//        if (person.isEmpty())
//            showToast("请填写推荐人！");
//        if (workkind.isEmpty() || workkind.equals("请选择"))
//            showToast("请填写工种！");
        //  Log.e("banknamen" + banknamen, "...workkindn" + workkindn);


    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
            switch (requestCode) {
                case 99:
                    idcardpicone = localMedias.get(0).getCompressPath();
                    //上传后显示
                    showtype = 0;
                    UploadPic(idcardpicone, "4");
//                    Glide.with(this).load(idcardpicone).into(ivIcCardUp);
                    break;
                case 100:
                    idcardpictwo = localMedias.get(0).getCompressPath();
                    showtype = 1;
                    UploadPic(idcardpictwo, "8");
//                    Glide.with(this).load(idcardpictwo).into(ivIcCardDown);
//                    uploadImageInfo.setIcCardDown(icCardDownUrl);
                    break;
                case 101:
                    bankpic = localMedias.get(0).getCompressPath();
                    showtype = 2;
                    UploadPic(bankpic, "9");
//                    Glide.with(this).load(bankpic).into(ivBankUp);
//                    uploadImageInfo.setBankCardUp(bankUpUrl);
                    break;
                case 102:
                    photopic = localMedias.get(0).getCompressPath();
                    showtype = 3;
                    UploadPic(photopic, "12");
                    break;
            }
        }
    }

    /**
     * 上传照片
     */
    ArrayList<String> urllist;

    private void UploadPic(String url, String type) {
        urllist.clear();
        urllist.add(url);
        mPresenter.getImg(App.workerInfo.getMobile(), type, urllist);
    }

}