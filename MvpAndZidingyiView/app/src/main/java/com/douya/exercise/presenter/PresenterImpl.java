package com.douya.exercise.presenter;

import com.douya.exercise.bean.InfoBean;
import com.douya.exercise.model.ModelImpl;
import com.douya.exercise.port.SucceedListener;
import com.douya.exercise.view.ViewInterface;

/**
 * Created by 杨圆圆 on 2017/10/25.
 */

public class PresenterImpl implements PresenterInterface,SucceedListener {
    private ViewInterface viewInterface;
    private final ModelImpl model;

    public PresenterImpl(ViewInterface viewInterface) {
        this.viewInterface = viewInterface;
        model = new ModelImpl();
    }

    @Override
    public void sendId(int id) {
        model.getData(id,this);
    }

    @Override
    public void succeed(InfoBean infoBean) {
        viewInterface.onSucceed(infoBean);
    }

    @Override
    public void shiBai() {
        viewInterface.onFaild();
    }
}
