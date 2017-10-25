package com.douya.exercise.view;

import com.douya.exercise.bean.InfoBean;

/**
 * Created by 杨圆圆 on 2017/10/25.
 */

public interface ViewInterface {
    void onSucceed(InfoBean infoBean);
    void  onFaild();
}
