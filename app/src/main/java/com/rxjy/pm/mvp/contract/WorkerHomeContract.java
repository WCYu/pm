package com.rxjy.pm.mvp.contract;

import com.rxjy.pm.commons.base.BaseModel;
import com.rxjy.pm.commons.base.BasePresenter;
import com.rxjy.pm.commons.base.BaseView;

/**
 * Created by AAA on 2018/3/13.
 */

public interface WorkerHomeContract  {

    interface View extends BaseView{

    }
    interface  Model extends BaseModel{

    }
    abstract class   Presenter  extends BasePresenter<View,Model>{

    }
}
