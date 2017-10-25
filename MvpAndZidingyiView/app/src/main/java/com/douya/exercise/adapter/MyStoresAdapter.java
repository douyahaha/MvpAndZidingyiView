package com.douya.exercise.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.douya.exercise.R;
import com.douya.exercise.bean.InfoBean;
import com.douya.exercise.myView.RoundImageView;
import com.douya.exercise.utils.TwoImageUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 杨圆圆 on 2017/10/25.
 */

public class MyStoresAdapter extends RecyclerView.Adapter<MyStoresAdapter.MyViewHolder> {
    private Context context;
    private List<InfoBean.StoriesBean> stories;

    public MyStoresAdapter(Context context, List<InfoBean.StoriesBean> stories) {
        this.context = context;
        this.stories = stories;
    }

    @Override
    public MyStoresAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.stores_item, parent, false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyStoresAdapter.MyViewHolder holder, int position) {
        InfoBean.StoriesBean storiesBean = stories.get(position);
        if(storiesBean.getImages().size()!=0){
            List<String> s = storiesBean.getImages();
            if(s.size()!=0){
                String s1 = s.get(0);
                if(s1.isEmpty()){
                    return;
                }
                Picasso.with(context).load(s1).into(holder.iv_stores);
                TwoImageUtils.loadImage(s1,holder.iv_stores);
            }
        }


        holder.tv_stores.setText(storiesBean.getTitle());
    }
    @Override
    public int getItemCount() {
        return stories.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final RoundImageView iv_stores;
        private final TextView tv_stores;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv_stores = (RoundImageView) itemView.findViewById(R.id.iv_stores);
            tv_stores = (TextView) itemView.findViewById(R.id.tv_stores);
        }
    }
}
