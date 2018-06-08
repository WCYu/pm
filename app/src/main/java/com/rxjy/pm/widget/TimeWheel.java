package com.rxjy.pm.widget;

import android.content.Context;
import android.view.View;


import com.rxjy.pm.R;
import com.rxjy.pm.widget.adapters.NumericWheelAdapter;
import com.rxjy.pm.widget.config.PickerConfig;
import com.rxjy.pm.widget.data.source.TimeRepository;
import com.rxjy.pm.widget.utils.PickerContants;
import com.rxjy.pm.widget.wheel.OnWheelChangedListener;
import com.rxjy.pm.widget.wheel.OnWheelScrollListener;
import com.rxjy.pm.widget.wheel.WheelView;

import java.util.Calendar;


public class TimeWheel {
    Context mContext;
     int nowyear;
     int newvalue;
    WheelView year, month, day, hour, minute;
    NumericWheelAdapter mYearAdapter, mMonthAdapter, mDayAdapter;

    PickerConfig mPickerConfig;
    TimeRepository mRepository;
    OnWheelChangedListener yearListener = new OnWheelChangedListener() {
        @Override
        public void onChanged(WheelView wheel, int oldValue, final int newValue) {
            newvalue = newValue;
            updateMonths();

        }

    };



  OnWheelScrollListener onWheelScrollListener=new OnWheelScrollListener() {
      @Override
      public void onScrollingStarted(WheelView wheel) {

      }

      @Override
      public void onScrollingFinished(WheelView wheel) {
          if(newvalue!=nowyear){
              wheel.setCurrentItem(nowyear);
          }

      }
  };



    OnWheelChangedListener monthListener = new OnWheelChangedListener() {
        @Override
        public void onChanged(WheelView wheel, int oldValue, int newValue) {
            updateDays();

        }
    };






    public TimeWheel(View view, PickerConfig pickerConfig) {
        mPickerConfig = pickerConfig;

        mRepository = new TimeRepository(pickerConfig);
        mContext = view.getContext();
        initialize(view);
    }

    public void initialize(View view) {
        initView(view);
        initYear();
        initMonth();
        initDay();

    }


    void initView(View view) {
        year = (WheelView) view.findViewById(R.id.year);
        month = (WheelView) view.findViewById(R.id.month);
        day = (WheelView) view.findViewById(R.id.day);



        year.addChangingListener(yearListener);
        year.addChangingListener(monthListener);
        month.addChangingListener(monthListener);
        year.addScrollingListener(onWheelScrollListener);





    }

    void initYear() {
        int minYear = mRepository.getMinYear();
        int maxYear = mRepository.getMaxYear();

        mYearAdapter = new NumericWheelAdapter(mContext, minYear, maxYear, PickerContants.FORMAT, mPickerConfig.mYear);
        mYearAdapter.setConfig(mPickerConfig);
        year.setViewAdapter(mYearAdapter);
        nowyear = mRepository.getDefaultCalendar().year - minYear;
        year.setCurrentItem(nowyear);
    }

    void initMonth() {
        updateMonths();
        int curYear = getCurrentYear();
        int minMonth = mRepository.getMinMonth(curYear);
        month.setCurrentItem(mRepository.getDefaultCalendar().month - minMonth);
        month.setCyclic(mPickerConfig.cyclic);
    }

    void initDay() {
        updateDays();
        int curYear = getCurrentYear();
        int curMonth = getCurrentMonth();

        int minDay = mRepository.getMinDay(curYear, curMonth);
        day.setCurrentItem(mRepository.getDefaultCalendar().day - minDay);
        day.setCyclic(mPickerConfig.cyclic);
    }




    void updateMonths() {
        if (month.getVisibility() == View.GONE)
            return;

        int curYear = getCurrentYear();
        int minMonth = mRepository.getMinMonth(curYear);
        int maxMonth = mRepository.getMaxMonth(curYear);
        mMonthAdapter = new NumericWheelAdapter(mContext, minMonth, maxMonth, PickerContants.FORMAT, mPickerConfig.mMonth);
        mMonthAdapter.setConfig(mPickerConfig);
        month.setViewAdapter(mMonthAdapter);

        if (mRepository.isMinYear(curYear)) {
            month.setCurrentItem(0, false);
        }
    }

    void updateDays() {
        if (day.getVisibility() == View.GONE)
            return;

        int curYear = getCurrentYear();
        int curMonth = getCurrentMonth();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + year.getCurrentItem());
        calendar.set(Calendar.MONTH, curMonth);

        int maxDay = mRepository.getMaxDay(curYear, curMonth);
        int minDay = mRepository.getMinDay(curYear, curMonth);
        mDayAdapter = new NumericWheelAdapter(mContext, minDay, maxDay, PickerContants.FORMAT, mPickerConfig.mDay);
        mDayAdapter.setConfig(mPickerConfig);
        day.setViewAdapter(mDayAdapter);

        if (mRepository.isMinMonth(curYear, curMonth)) {
            day.setCurrentItem(0, true);
        }

        int dayCount = mDayAdapter.getItemsCount();
        if (day.getCurrentItem() >= dayCount) {
            day.setCurrentItem(dayCount - 1, true);
        }
    }





    public int getCurrentYear() {
        return year.getCurrentItem() + mRepository.getMinYear();
    }

    public int getCurrentMonth() {
        int curYear = getCurrentYear();
        return month.getCurrentItem() + +mRepository.getMinMonth(curYear);
    }

    public int getCurrentDay() {
        int curYear = getCurrentYear();
        int curMonth = getCurrentMonth();
        return day.getCurrentItem() + mRepository.getMinDay(curYear, curMonth);
    }




}
