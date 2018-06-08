package com.rxjy.pm.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.lib.WheelView;

import com.rxjy.pm.R;
import com.rxjy.pm.commons.App;
import com.rxjy.pm.commons.base.BaseActivity;
import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.OrdersBean;
import com.rxjy.pm.entity.OrdersSubmitBean;
import com.rxjy.pm.mvp.contract.OrdersContract;
import com.rxjy.pm.mvp.presenter.OrdersPresenter;
import com.rxjy.pm.widget.CustomDatePicker;
import com.rxjy.pm.widget.DatePickerPopWin;
import com.rxjy.pm.widget.TimePickerDialog;
import com.rxjy.pm.widget.data.Type;
import com.rxjy.pm.widget.listener.OnDateSetListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by asus on 2018/4/8.
 */

public class OrdersActivity extends BaseActivity<OrdersPresenter> implements OrdersContract.View {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.Customer_telephone)
    ImageView CustomerTelephone;
    @Bind(R.id.Customer_service)
    ImageView CustomerService;
    @Bind(R.id.iv_add)
    ImageView ivAdd;
    @Bind(R.id.tv_staterd)
    TextView tvStaterd;
    @Bind(R.id.scanning)
    ImageView scanning;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.show_popup)
    RelativeLayout showPopup;
    @Bind(R.id.Orders_time)
    TextView OrdersTime;
    @Bind(R.id.btn_Submit)
    Button btnSubmit;
    @Bind(R.id.End_time)
    TextView EndTime;
    @Bind(R.id.summay)
    EditText summay;
    @Bind(R.id.swich_btn)
    Switch swichBtn;
    @Bind(R.id.swich_linaer)
    LinearLayout swichLinaer;
    @Bind(R.id.Order_image)
    CheckBox OrderImage;
    @Bind(R.id.wv_options)
    WheelView wvOptions;

//    private CustomDatePicker customDatePicker1, customDatePicker2;
//    private String now;
//    private boolean aBoolean;
//    TimePickerDialog mDialogYearMonthDay;
//    private TimePickerDialog mDialogYearMonthDayEnd;
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public int getLayout() {
        return R.layout.orders_activity;
    }

    @Override
    public void initData() {
//        mDialogYearMonthDay = new TimePickerDialog.Builder()
//                .setType(Type.YEAR_MONTH_DAY)
//                .setWheelItemTextSize(18)
//
//                .setCallBack(new OnDateSetListener() {
//                    @Override
//                    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
//                        String text = getDateToString(millseconds);
//                        OrdersTime.setText(text);
//                    }
//                })
//                .build();
//        mDialogYearMonthDayEnd = new TimePickerDialog.Builder()
//                .setType(Type.YEAR_MONTH_DAY)
//                .setWheelItemTextSize(18)
//                .setCallBack(new OnDateSetListener() {
//                    @Override
//                    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
//                        String text = getDateToString(millseconds);
//                        EndTime.setText(text);
//                    }
//                })
//                .build();
        tvTitle.setText("接单");
//        swichBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//                if (isChecked) {
//                    swichLinaer.setVisibility(View.VISIBLE);
//                    aBoolean = true;
//                } else {
//                    swichLinaer.setVisibility(View.GONE);
//                    aBoolean = false;
//                }
//            }
//        });
        OrderImage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                closeKeyboard();
                if (isChecked) {
                    swichLinaer.setVisibility(View.VISIBLE);
                } else {
                    swichLinaer.setVisibility(View.GONE);
                }
            }
        });
        Log.e("tag",App.pmUserInfo.getUid()+"");
        mPresenter.getSubmit(App.pmUserInfo.getUid());

        EndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeKeyboard();
                DatePickerPopWin pickerPopWin = new DatePickerPopWin.Builder(OrdersActivity.this, new DatePickerPopWin.OnDatePickedListener() {
                    @Override
                    public void onDatePickCompleted(int year, int month, int day, String dateDesc) {
                        //Toast.makeText(OrdersActivity.this, dateDesc, Toast.LENGTH_SHORT).show();
                        EndTime.setText(dateDesc);
                    }
                }).textConfirm("确定") //text of confirm button
                        .textCancel("取消") //text of cancel button
                        .btnTextSize(16) // button text size
                        .viewTextSize(25) // pick view text size
                        .colorCancel(Color.parseColor("#999999")) //color of cancel button
                        .colorConfirm(Color.parseColor("#009900"))//color of confirm button
                        .minYear(2018) //min year in loop
                        .maxYear(2550) // max year in loop
                        .dateChose(getTime(new Date())) // date chose when init popwindow
                        .build();
                pickerPopWin.showPopWin(OrdersActivity.this);
              //  mDialogYearMonthDayEnd.show(getSupportFragmentManager(), "year_month_day");
            }
        });
    }

    @Override
    protected OrdersPresenter onCreatePresenter() {
        return new OrdersPresenter(this);
    }


    @OnClick({R.id.iv_back, R.id.Customer_telephone, R.id.Customer_service, R.id.iv_add, R.id.tv_staterd, R.id.scanning, R.id.tv_title, R.id.show_popup, R.id.Orders_time, R.id.btn_Submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.Customer_telephone:
                break;
            case R.id.Customer_service:
                break;
            case R.id.iv_add:
                break;
            case R.id.tv_staterd:
                break;
            case R.id.scanning:
                break;
            case R.id.tv_title:
                break;
            case R.id.show_popup:
                break;
            case R.id.Orders_time:
                closeKeyboard();
                DatePickerPopWin pickerPopWin = new DatePickerPopWin.Builder(OrdersActivity.this, new DatePickerPopWin.OnDatePickedListener() {
                    @Override
                    public void onDatePickCompleted(int year, int month, int day, String dateDesc) {
                        //Toast.makeText(OrdersActivity.this, dateDesc, Toast.LENGTH_SHORT).show();
                        OrdersTime.setText(dateDesc);
                    }
                }).textConfirm("确定") //text of confirm button
                        .textCancel("取消") //text of cancel button
                        .btnTextSize(16) // button text size
                        .viewTextSize(25) // pick view text size
                        .colorCancel(Color.parseColor("#999999")) //color of cancel button
                        .colorConfirm(Color.parseColor("#009900"))//color of confirm button
                        .minYear(2018) //min year in loop
                        .maxYear(2550) // max year in loop
                        .dateChose(getTime(new Date())) // date chose when init popwindow
                        .build();
                pickerPopWin.showPopWin(OrdersActivity.this);

               // mDialogYearMonthDay.show(getSupportFragmentManager(), "year_month_day");
                break;
            case R.id.btn_Submit:
                String kaishi = OrdersTime.getText().toString();
                String s = EndTime.getText().toString();
                if (OrderImage.isChecked()) {
                    Log.e("tag",kaishi);
                   mPresenter.toSubmit(kaishi, s, summay.getText().toString(), App.pmUserInfo.getUid(), 1);
               } else {
                    mPresenter.toSubmit(kaishi, "", "", App.pmUserInfo.getUid(), 0);
                }

                break;

        }
    }


    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
    }

    @Override
    public void showMessge(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getSubmit(String body) {
        // Toast.makeText(this, bodyBean.getStaterecord_endtime(), Toast.LENGTH_SHORT).show();
        try {
            JSONObject jsonObject = new JSONObject(body);
            String booy = jsonObject.getString("Body");

            if (booy.equals("")) {
                //Log.e("aa", body);
                //  SimpleDateFormat   formatter   =   new   SimpleDateFormat   ("yyyy年MM月dd日   HH:mm:ss");
                //  Date curDate =  new Date(System.currentTimeMillis());
                OrdersTime.setText(getTime(new Date()));
                EndTime.setText("永久");
            } else {
                OrdersBean ordersBean = JSONUtils.toObject(body, OrdersBean.class);
                if (ordersBean.getStatusCode() == 1) {
                    OrdersBean.BodyBean boo = ordersBean.getBody();
                    OrdersTime.setText(boo.getStaterecord_time());
                    if (boo.getStaterecord_type() ==1 ) {
                        swichBtn.setChecked(true);
//                        aBoolean = true;
                        swichLinaer.setVisibility(View.VISIBLE);
                        OrderImage.setChecked(true);
                    } else {
                        swichBtn.setChecked(false);
//                        aBoolean = false;
                        OrderImage.setChecked(false);
                        swichLinaer.setVisibility(View.GONE);
                    }
                } else {
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void toSubmit(OrdersSubmitBean submitBean) {
        showMessge("设置成功");
    }

    public String getDateToString(long time) {
        Date d = new Date(time);
        return sf.format(d);
    }

    private void closeKeyboard() {
        View view = getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    public String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }
}
