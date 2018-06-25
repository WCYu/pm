package com.rxjy.pm.api;


import com.rxjy.pm.commons.App;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Administrator on 2017/1/9.
 */
public class ApiEngine {

    private static final String RS_API_HOST = "https://api.dcwzg.com:9191/";
    public static final String EQ_API_LM_HOST = "http://www.rxjy.com/";
    private static final String RD_API_HOST = "http://apia.jingrenzn.com:7001/";
    private static final String ZT_API_HOST = "http://apia.jingrenzn.com:8080/";

    private static final String RX_API_HOST = "http://wpsnew.rxjy.com:9090"; //线上
    // private static final String RX_API_HOST = "http://test.news.cs/"; //测试

    //public static final String GC_API_HOST = "http://api.gc.cs/";//测试
    public static final String GC_API_HOST = "http://api.gc.rxjy.com:/";//线上

    public static String BASEURL = "http://192.168.1.170:8099/";//测试
   // public static String BASEURL = "http://wrrsnew.lm.rxjy.com:8181/"; //线上

    //  public static final String GC_API_HOST_CUSTOMER = "http://api.lm.cs/";//测试
    public static final String GC_API_HOST_CUSTOMER = "http://api.lm.rxjy.com:8034/";//线上

    // public static final String GC_API_LM_HOST="http://wrapi.lm.cs/"; //测试
    public static final String GC_API_LM_HOST = "http://wrapi.lm.rxjy.com:8036/"; //线上

    public static final String WANZHI = "http://wrxm.lm.cs";//测试
    // public static final String WANZHI = "http://wrapi.lm.rxjy.com:8036/";//线上
    //    public static final String GC_API_HOST_CUSTOMER = "http://192.168.1.167:8034/";
//    private static final String RD_API_HOST = "http://10.10.13.29:8089/";
//    private static final String RD_API_HOST = "http://115.47.122.217:8080/";
//    private static final String RD_API_HOST = "http://192.168.1.230:801/";
//    private static final String RD_API_HOST = "http://apia.jingrenzn.com:8084/";
//    private static final String RD_API_HOST = "http://apia.jingrenzn.com:8084";

    public static final String WORKER_LM_HOST = "http://192.168.1.170:8580/cs/"; //测试

    //public static final String WORKER_LM_HOST = "http://grlm.lm.rxjy.com:8580/"; //线上

    public static final String BANKCARD = "http://api.gc.cs/"; //测试
    //public static final String BANKCARD = "http://api.gc.rx"; //线上
    //判断登陆权限
    public static String LOGIN = RS_API_HOST + "actionapi/AppLogin/GetCheckUserInfo";
    //获取验证码
    public static String CODE = RS_API_HOST + "actionapi/AppLogin/GetInsideVcodeLanding";
    //登陆激活
    public static String LOGINURL = RS_API_HOST + "actionapi/AppLogin/Login";
    //认证接口
    public static String RENZHENGURL = BASEURL + "a/stration/pmUserinfoProjectMsg/GetUserInfoStrationByuid";
    //上传接口
    public static String SHANGCHUANURL = BASEURL + "a/pmUserinfo/add/addAuthentication ";
    //工人上传
    public static String GONGRANURL = BASEURL + "a/pmUserinfo/add/addWorker";
    //项目上传
    public static String XIANGMUURL = BASEURL + "a/pmUserinfo/add/addProject ";
    //入职资料
    public static String RUZHIURL = BASEURL + "a/app/GetuserinfoPhotoByuid";
    //入职资料上传
    public static String RUZHIADDURL = BASEURL + "a/app/submitEntryInformationByUidNew";
    //入职资料图片上传
    public static String RUZHIADDIMGURL = BASEURL + "a/app/userinfo/GetUserInfoPictureUploadingByUid";
    //多张图片上传
    public static String ALLIMGURL = BASEURL + "a/app/savePhotosByUid";

    //入职资料
    public static String RUZHIZILIAOURL = BASEURL + "a/app/appCooperationRedirect";
    //是否同意入职条件
    public static String ADDISRUZHIURL = BASEURL + "a/app/updateIntention";
     //获取工人资料
    //a/wokersApp/findWorkerInfobyId
    public static  String WORKERSINFORMATION=WORKER_LM_HOST+"a/wokersApp/findWorkerInfobyId";
    //获取工人的银行卡列表
    public static  String WORKERBankCard=BANKCARD+"api/PhoneSupervisor/ApiGetDictionInfo";
    //获取工人工种
    public static  String GONRENTYPE=WORKER_LM_HOST+"a/wokersApp/selectPmWokerMajorJobs";
    //获取工人图片
    public static  String WORKERPHOTO=WORKER_LM_HOST+"a/PmAttrInfo/findWokerPhotosbyId";
    //修改工人信息
    ///a/wokersApp/updatePmWokerInfo
    public static  String WORKERINFO=WORKER_LM_HOST+"/a/wokersApp/updatePmWokerInfo";
    //修改工人图片
    public static  String WORKERUPDATEPHOTO=WORKER_LM_HOST+"a/PmAttrInfo/addSinglePhoto";
    private Retrofit rxRetrofit;
    private Retrofit rsRetrofit;
    private Retrofit gcRetrofit;
    private Retrofit gcRetrofitcustomer;
    private Retrofit rdRetrofit;
    private Retrofit ztRetrofit;

    private Retrofit lmRetrofit;
    private Retrofit eqRetrofit;

    //这里更好的保证单例的线程安全
    private volatile static ApiEngine apiEngine;
    private Retrofit retrofit;

    private ApiEngine() {

        //日志拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        //设置查看类别
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //设置缓存位置与缓存的大小
        int size = 1024 * 1024 * 100;
        File cacheFile = new File(App.getContext().getCacheDir(), "okHttpCache");
        Cache cache = new Cache(cacheFile, size);

        //添加日志拦截器，并且添加网络缓存
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(12, TimeUnit.SECONDS)
                .writeTimeout(12, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addNetworkInterceptor(new NetWorkInterceptor())
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();

        rxRetrofit = new Retrofit.Builder()
                .baseUrl(RX_API_HOST)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        //初始化材料的Retrofit对象
        rsRetrofit = new Retrofit.Builder()
                .baseUrl(RS_API_HOST)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        gcRetrofit = new Retrofit.Builder()
                .baseUrl(GC_API_HOST)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        gcRetrofitcustomer = new Retrofit.Builder()
                .baseUrl(GC_API_HOST_CUSTOMER)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        rdRetrofit = new Retrofit.Builder()
                .baseUrl(RD_API_HOST)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        ztRetrofit = new Retrofit.Builder()
                .baseUrl(ZT_API_HOST)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        lmRetrofit = new Retrofit.Builder()
                .baseUrl(GC_API_LM_HOST)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        eqRetrofit = new Retrofit.Builder()
                .baseUrl(EQ_API_LM_HOST)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    //将网络请求对象封装为单例模式
    public static ApiEngine getInstance() {
        if (apiEngine == null) {
            synchronized (ApiEngine.class) {
                if (apiEngine == null) {
                    apiEngine = new ApiEngine();
                }
            }
        }
        return apiEngine;
    }

    public ApiService getRsApiService() {
        // ApiService apiService = rsRetrofit.create(ApiService.class);
        return rsRetrofit.create(ApiService.class);
    }

    public ApiService getRxApiService() {
        return rxRetrofit.create(ApiService.class);
    }

    public ApiService getGcApiService() {
        return gcRetrofit.create(ApiService.class);
    }

    public ApiService getGccApiService() {
        return gcRetrofitcustomer.create(ApiService.class);
    }

    public ApiService getRdApiService() {
        return rdRetrofit.create(ApiService.class);
    }

    public ApiService getZtApiService() {
        return ztRetrofit.create(ApiService.class);
    }

    public ApiService getLmApiService() {
        return lmRetrofit.create(ApiService.class);
    }

    public ApiService getEqApiService() {
        return eqRetrofit.create(ApiService.class);
    }
}
