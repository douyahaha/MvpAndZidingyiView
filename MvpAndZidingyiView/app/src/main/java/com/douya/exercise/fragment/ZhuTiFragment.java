package com.douya.exercise.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.douya.exercise.R;
import com.douya.exercise.activity.InfoActivity;
import com.douya.exercise.adapter.MyZhuTiAdapter;
import com.douya.exercise.bean.ZhuTiBean;
import com.douya.okhttplibrary.utils.GsonObjectCallback;
import com.douya.okhttplibrary.utils.OkHttp3Utils;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;

/**
 * Created by 杨圆圆 on 2017/10/25.
 */

public class ZhuTiFragment extends Fragment {
    private RecyclerView recycle_zhuTi;
    private String url="http://news-at.zhihu.com/api/4/themes";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zhuti, container, false);
        initView(view);
        getData();
        return view;
    }

    private void getData() {
        OkHttp3Utils.doGet(url, new GsonObjectCallback<ZhuTiBean>() {
            @Override
            public void onUi(ZhuTiBean zhuTiBean) {
                final List<ZhuTiBean.OthersBean> others = zhuTiBean.getOthers();
                MyZhuTiAdapter adapter=new MyZhuTiAdapter(getContext(),others);
                recycle_zhuTi.setAdapter(adapter);
                adapter.setOnItemCheckListener(new MyZhuTiAdapter.OnItemCheckListener() {
                    @Override
                    public void onItemClick(int position) {
                        ZhuTiBean.OthersBean bean = others.get(position);
                        Intent intent=new Intent(getContext(), InfoActivity.class);
                        intent.putExtra("ID",bean.getId());
                        getContext().startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }


    private void initView(View view) {
        recycle_zhuTi = (RecyclerView) view.findViewById(R.id.recycle_zhuTi);
        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),2);
        recycle_zhuTi.setLayoutManager(layoutManager);
    }
}
