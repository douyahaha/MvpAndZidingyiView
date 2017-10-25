package com.douya.exercise.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.douya.exercise.R;
import com.douya.exercise.bean.NewsBean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杨圆圆 on 2017/10/25.
 */

public class MyNewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private NewsBean newsBean;
    private final DisplayImageOptions options;
    private List<NewsBean.StoriesBean> stories;
    private List<NewsBean.TopStoriesBean> top_stories;
    private List<String> list=new ArrayList<>();
    public MyNewAdapter(Context context, NewsBean newsBean,List<NewsBean.TopStoriesBean> top_stories) {
        this.context = context;
        this.newsBean = newsBean;
        this.top_stories=top_stories;
        options = new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .displayer(new CircleBitmapDisplayer())
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default
                .build();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==0){
            View view = LayoutInflater.from(context).inflate(R.layout.footer_item, parent, false);
            return new VHFooter(view);
        }else if (viewType==1){
            View view = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false);
            return new Content(view);
        }else if(viewType==2){
            View view = LayoutInflater.from(context).inflate(R.layout.mbanner, parent, false);
            return new BannerHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if(type==0){
            return;
        }
        if(type==1){
            Content content=new Content(holder.itemView);
            stories = newsBean.getStories();
            if(stories.get(position).getImages().get(0).isEmpty()){
                return;
            }
            String s = stories.get(position).getImages().get(0);
            ImageLoader.getInstance().displayImage(s,content.iv_new,options);
            content.tv_newTitle.setText(stories.get(position).getTitle());
            content.tv_newTime.setText(stories.get(position).getGa_prefix());
        }
        if(type==2){
            BannerHolder bannerHolder=new BannerHolder(holder.itemView);

            for (NewsBean.TopStoriesBean b:top_stories){
                if(b.getImage().isEmpty()){
                    return;
                }
                list.add(b.getImage());
            }
            bannerHolder.banner.setImages(list);
                             //设置图片加载器
            bannerHolder.banner.setImageLoader(new MyImageLoader());
                         //设置显示样式
            bannerHolder.banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
                         //位置
            bannerHolder.banner.setIndicatorGravity(BannerConfig.LEFT);
                         //图片默认
            bannerHolder.banner.setBannerAnimation(Transformer.ScaleInOut);
            bannerHolder.banner.start();

        }

    }

    @Override
    public int getItemCount() {
        return newsBean.getStories().size()+1;
    }

    @Override
    public int getItemViewType(int position) {

        if(position==getItemCount()-1){
            return 0;
        }else if(position==0){
            return 2;
        }else{
            return 1;
        }
    }
    private class VHFooter extends RecyclerView.ViewHolder{

        public VHFooter(View itemView) {
            super(itemView);

        }
    }
    private class BannerHolder extends RecyclerView.ViewHolder{

        private final Banner banner;

        public BannerHolder(View itemView) {
            super(itemView);
           banner = (Banner) itemView.findViewById(R.id.my_banner);
        }
    }
    private class Content extends RecyclerView.ViewHolder{

        private final ImageView iv_new;
        private final TextView tv_newTitle;
        private final TextView tv_newTime;

        public Content(View itemView) {
            super(itemView);
            iv_new = (ImageView) itemView.findViewById(R.id.iv_new);
            tv_newTitle = (TextView) itemView.findViewById(R.id.tv_newTitle);
            tv_newTime = (TextView) itemView.findViewById(R.id.tv_NewTime);
        }
    }
    public void loadMore(List<NewsBean.StoriesBean> s ){
        for (NewsBean.StoriesBean str : s){
            stories.add(str);
        }
        //更新界面
        notifyDataSetChanged();

    }
    public void refreshMore(List<NewsBean.StoriesBean> s){
        for (NewsBean.StoriesBean str : s){
            stories.add(0,str);
        }
        //更新界面
        notifyDataSetChanged();
    }
   public class MyImageLoader extends com.youth.banner.loader.ImageLoader{
       @Override
       public void displayImage(Context context, Object path, ImageView imageView) {
           Picasso.with(context).load(String.valueOf(path)).into(imageView);
       }
   }
}
