package com.rxjy.pm.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.rxjy.pm.activity.OrdersDetailActivity;
import com.rxjy.pm.adapter.MsgDetailActivity;
import com.rxjy.pm.commons.Constants;
import com.rxjy.pm.commons.utils.JSONUtils;
import com.rxjy.pm.entity.PushInfo;
import com.rxjy.pm.entity.PushMsgDetailInfo;
import com.rxjy.pm.entity.PushOrdersInfo;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by AAA on 2017/10/23.
 */

public class JPushReceiver extends BroadcastReceiver {

    private static final String TAG = "JPushReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            Bundle bundle = intent.getExtras();

            if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {
                String regId = bundle.getString(JPushInterface.EXTRA_REGISTRATION_ID);
//                Log.d(TAG, "[JPushReceiver] 接收Registration Id : " + regId);
                //send the Registration Id to your server...

            } else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
//                Log.d(TAG, "[JPushReceiver] 接收到推送下来的自定义消息: " + bundle.getString(JPushInterface.EXTRA_MESSAGE));

            } else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())) {
//                Log.d(TAG, "[JPushReceiver] 接收到推送下来的通知");
                int notifactionId = bundle.getInt(JPushInterface.EXTRA_NOTIFICATION_ID);
//                Log.d(TAG, "[JPushReceiver] 接收到推送下来的通知的ID: " + notifactionId);

            } else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
                Log.d(TAG, "[JPushReceiver] 用户点击打开了通知");

                String json = bundle.getString(JPushInterface.EXTRA_EXTRA);

                Log.d(TAG, "[JPushReceiver] 用户点击打开了通知 = " + json);

                PushInfo info = JSONUtils.toObject(json, PushInfo.class);

                String parameter = info.getParameter();

                if (info.getJMP().equals("order")) {
                    PushOrdersInfo ordersInfo = JSONUtils.toObject(parameter, PushOrdersInfo.class);
                    Intent ordersIntent = new Intent(context, OrdersDetailActivity.class);
                    ordersIntent.putExtra(Constants.ACTION_TO_ORDERS_DETAIL_ORDER_ID, ordersInfo.getOrderID());
                    ordersIntent.putExtra(Constants.ACTION_TO_ORDERS_DETAIL_ORDERS_STATUS, ordersInfo.getOrderState());
                    ordersIntent.putExtra(Constants.ACTION_TO_ORDERS_DETAIL_PRO_NAME, ordersInfo.getProName());
                    ordersIntent.putExtra(Constants.ACTION_TO_ORDERS_DETAIL_PRO_ADDRESS, ordersInfo.getProAddr());
                    ordersIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    context.startActivity(ordersIntent);
                } else if (info.getJMP().equals("message")) {
                    PushMsgDetailInfo msgDetailInfo = JSONUtils.toObject(parameter, PushMsgDetailInfo.class);
                    Intent msgDetailIntent = new Intent(context, MsgDetailActivity.class);
                    msgDetailIntent.putExtra(Constants.ACTION_TO_MSG_DETAIL_TS_ID, Integer.parseInt(msgDetailInfo.getTs_id()));
                    msgDetailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    context.startActivity(msgDetailIntent);
                }

//                //打开自定义的Activity
//                Intent i = new Intent(context, TestActivity.class);
//                i.putExtras(bundle);
//                //i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP );
//                context.startActivity(i);

            } else if (JPushInterface.ACTION_RICHPUSH_CALLBACK.equals(intent.getAction())) {
                Log.d(TAG, "[JPushReceiver] 用户收到到RICH PUSH CALLBACK: " + bundle.getString(JPushInterface.EXTRA_EXTRA));
                //在这里根据 JPushInterface.EXTRA_EXTRA 的内容处理代码，比如打开新的Activity， 打开一个网页等..

            } else if (JPushInterface.ACTION_CONNECTION_CHANGE.equals(intent.getAction())) {
                boolean connected = intent.getBooleanExtra(JPushInterface.EXTRA_CONNECTION_CHANGE, false);
                Log.w(TAG, "[JPushReceiver]" + intent.getAction() + " connected state change to " + connected);
            } else {
                Log.d(TAG, "[JPushReceiver] Unhandled intent - " + intent.getAction());
            }
        } catch (Exception e) {

        }
    }

    // 打印所有的 intent extra 数据
    private static String printBundle(Bundle bundle) {
        StringBuilder sb = new StringBuilder();
        for (String key : bundle.keySet()) {
            if (key.equals(JPushInterface.EXTRA_NOTIFICATION_ID)) {
                sb.append("\nkey:" + key + ", value:" + bundle.getInt(key));
            } else if (key.equals(JPushInterface.EXTRA_CONNECTION_CHANGE)) {
                sb.append("\nkey:" + key + ", value:" + bundle.getBoolean(key));
            } else if (key.equals(JPushInterface.EXTRA_EXTRA)) {
                if (TextUtils.isEmpty(bundle.getString(JPushInterface.EXTRA_EXTRA))) {
                    Log.i(TAG, "This message has no Extra data");
                    continue;
                }

                try {
                    JSONObject json = new JSONObject(bundle.getString(JPushInterface.EXTRA_EXTRA));
                    Iterator<String> it = json.keys();

                    while (it.hasNext()) {
                        String myKey = it.next();
                        sb.append("\nkey:" + key + ", value: [" +
                                myKey + " - " + json.optString(myKey) + "]");
                    }
                } catch (JSONException e) {
                    Log.e(TAG, "Get message extra JSON error!");
                }

            } else {
                sb.append("\nkey:" + key + ", value:" + bundle.getString(key));
            }
        }
        return sb.toString();
    }

}
