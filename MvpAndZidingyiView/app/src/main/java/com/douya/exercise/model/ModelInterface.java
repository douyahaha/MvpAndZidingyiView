package com.douya.exercise.model;

import com.douya.exercise.port.SucceedListener;

/**
 * Created by 杨圆圆 on 2017/10/25.
 */

public interface ModelInterface {
    void getData(int id,SucceedListener listener);
}
