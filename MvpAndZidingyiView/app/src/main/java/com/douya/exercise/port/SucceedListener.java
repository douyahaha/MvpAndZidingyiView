package com.douya.exercise.port;

import com.douya.exercise.bean.InfoBean;

/**
 * Created by 杨圆圆 on 2017/10/25.
 */

public interface SucceedListener {
    void succeed(InfoBean infoBean);
    void shiBai();
}
