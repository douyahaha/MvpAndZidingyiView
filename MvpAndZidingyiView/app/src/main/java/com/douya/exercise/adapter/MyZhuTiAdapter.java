package com.douya.exercise.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.douya.exercise.R;
import com.douya.exercise.bean.ZhuTiBean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import java.util.List;

/**
 * Created by 杨圆圆 on 2017/10/25.
 */

public class MyZhuTiAdapter extends RecyclerView.Adapter<MyZhuTiAdapter.MyViewHolder>{
    private Context context;
    private List<ZhuTiBean.OthersBean> others;
    private final DisplayImageOptions options;
    public MyZhuTiAdapter(Context context, List<ZhuTiBean.OthersBean> others) {
        this.context = context;
        this.others = others;
        options = new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default
                .build();
    }

    @Override
    public MyZhuTiAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.zhuti_item, parent, false);
        final MyViewHolder viewHolder=new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    listener.onItemClick(viewHolder.getLayoutPosition());
                }
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyZhuTiAdapter.MyViewHolder holder, int position) {
        ZhuTiBean.OthersBean othersBean = others.get(position);
        ImageLoader.getInstance().displayImage(othersBean.getThumbnail(),holder.iv_zhuTi,options);
        holder.tv_zhuTi.setText(othersBean.getName());
    }

    @Override
    public int getItemCount() {
        return others.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView iv_zhuTi;
        private final TextView tv_zhuTi;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv_zhuTi = (ImageView) itemView.findViewById(R.id.iv_zhuTi);
            tv_zhuTi = (TextView) itemView.findViewById(R.id.tv_zhuTi);
        }
    }
    private OnItemCheckListener listener;
    //定义一个接口
    public interface OnItemCheckListener{
        void onItemClick(int position);
    }
    public void setOnItemCheckListener(OnItemCheckListener listener){
        this.listener=listener;
    }
}
