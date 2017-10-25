package com.douya.exercise.model;

import com.douya.exercise.bean.InfoBean;
import com.douya.exercise.port.SucceedListener;
import com.douya.okhttplibrary.utils.GsonObjectCallback;
import com.douya.okhttplibrary.utils.OkHttp3Utils;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by 杨圆圆 on 2017/10/25.
 */

public class ModelImpl implements ModelInterface {
    @Override
    public void getData(int id, final SucceedListener listener) {
        OkHttp3Utils.doGet("http://news-at.zhihu.com/api/4/theme/" + id, new GsonObjectCallback<InfoBean>() {
            @Override
            public void onUi(InfoBean infoBean) {
                if(infoBean==null){
                    listener.shiBai();
                }
                listener.succeed(infoBean);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }
}
