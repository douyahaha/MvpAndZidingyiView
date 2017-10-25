package com.douya.exercise.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.douya.exercise.R;
import com.douya.exercise.adapter.MyStoresAdapter;
import com.douya.exercise.bean.InfoBean;
import com.douya.exercise.myView.RoundImageView;
import com.douya.exercise.presenter.PresenterImpl;
import com.douya.exercise.utils.TwoImageUtils;
import com.douya.exercise.view.ViewInterface;
import com.squareup.picasso.Picasso;

import java.util.List;

public class InfoActivity extends AppCompatActivity implements ViewInterface {

    private RoundImageView iv_info;
    private TextView tv_infoName;
    private TextView tv_infoDescription;
    private RecyclerView recycle_stores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        initView();
        Intent intent = getIntent();
        int id = intent.getIntExtra("ID", 13);
        PresenterImpl presenter=new PresenterImpl(this);
        presenter.sendId(id);
    }

    private void initView() {
        iv_info = (RoundImageView) findViewById(R.id.iv_info);

        tv_infoName = (TextView) findViewById(R.id.tv_infoName);
        tv_infoDescription = (TextView) findViewById(R.id.tv_infoDescription);
        recycle_stores = (RecyclerView) findViewById(R.id.recycle_stores);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recycle_stores.setLayoutManager(layoutManager);

    }

    @Override
    public void onSucceed(InfoBean infoBean) {
        Picasso.with(InfoActivity.this).load(infoBean.getImage()).into(iv_info);
        TwoImageUtils.loadImage(infoBean.getImage(),iv_info);

        tv_infoName.setText(infoBean.getName());
        tv_infoDescription.setText(infoBean.getDescription());
        List<InfoBean.StoriesBean> stories = infoBean.getStories();
        MyStoresAdapter adapter=new MyStoresAdapter(InfoActivity.this,stories);
        recycle_stores.setAdapter(adapter);
    }

    @Override
    public void onFaild() {
        Toast.makeText(InfoActivity.this,"加载失败",Toast.LENGTH_SHORT).show();
    }
}
