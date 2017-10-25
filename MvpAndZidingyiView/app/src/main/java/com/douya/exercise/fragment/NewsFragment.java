package com.douya.exercise.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.douya.exercise.R;
import com.douya.exercise.adapter.MyNewAdapter;
import com.douya.exercise.bean.NewsBean;
import com.douya.okhttplibrary.utils.GsonObjectCallback;
import com.douya.okhttplibrary.utils.OkHttp3Utils;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;

/**
 * Created by 杨圆圆 on 2017/10/25.
 */

public class NewsFragment extends Fragment {

    private RecyclerView recycle_news;
    private SwipeRefreshLayout sr_layout;
    private String url="http://news-at.zhihu.com/api/4/news/latest";
    private String urlMore="http://news-at.zhihu.com/api/4/news/before/20131119";
    private MyNewAdapter adapter;
    private LinearLayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        initView(view);
        getServerData();
        sr_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                OkHttp3Utils.doGet(urlMore, new GsonObjectCallback<NewsBean>() {
                    @Override
                    public void onUi(NewsBean newsBean) {
                        List<NewsBean.StoriesBean> stories = newsBean.getStories();
                        adapter.refreshMore(stories);
                    }

                    @Override
                    public void onFailed(Call call, IOException e) {
                    }
                });
                if(sr_layout.isRefreshing()){
                    //隐藏掉下拉刷新进度条
                    sr_layout.setRefreshing(false);
                }
            }
        });
        //给RecycleView添加滚动监听
       recycle_news.addOnScrollListener(new RecyclerView.OnScrollListener(){
           private int lastPOsition;
           @Override
           public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
               super.onScrollStateChanged(recyclerView, newState);

               if(lastPOsition+1==adapter.getItemCount()&&newState==RecyclerView.SCROLL_STATE_IDLE){
                   OkHttp3Utils.doGet(urlMore, new GsonObjectCallback<NewsBean>() {
                       @Override
                       public void onUi(NewsBean newsBean) {
                           List<NewsBean.StoriesBean> stories = newsBean.getStories();
                           adapter.loadMore(stories);
                       }
                       @Override
                       public void onFailed(Call call, IOException e) {
                       }
                   });
               }
           }

           @Override
           public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
               super.onScrolled(recyclerView, dx, dy);
               lastPOsition = layoutManager.findLastVisibleItemPosition();
           }
       });
        return view;
    }


    private void getServerData() {
        OkHttp3Utils.doGet(url, new GsonObjectCallback<NewsBean>() {
            @Override
            public void onUi(NewsBean newsBean) {

                if(adapter==null){
                    List<NewsBean.TopStoriesBean> top_stories = newsBean.getTop_stories();
                    adapter = new MyNewAdapter(getContext(),newsBean,top_stories);
                    recycle_news.setAdapter(adapter);
                }else{
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }

    private void initView(View view) {
        recycle_news = (RecyclerView) view.findViewById(R.id.recycle_news);
        sr_layout = (SwipeRefreshLayout) view.findViewById(R.id.sr_layout);
        layoutManager = new LinearLayoutManager(getContext());
        recycle_news.setLayoutManager(layoutManager);

    }
}
