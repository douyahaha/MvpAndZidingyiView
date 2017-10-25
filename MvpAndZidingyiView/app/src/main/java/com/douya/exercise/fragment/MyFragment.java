package com.douya.exercise.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.douya.exercise.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杨圆圆 on 2017/10/25.
 */

public class MyFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager vp_fragment;
    private String[] title=new String[]{"最新日报","专栏","热门","主题日报"};
    private List<Fragment> list=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zhuye, container, false);

        initView(view);
        for (String str:title){
            tabLayout.addTab(tabLayout.newTab().setText(str));
        }
        list.add(new NewsFragment());
        list.add(new ZhuanFragment());
        list.add(new HotFragment());
        list.add(new ZhuTiFragment());
        tabLayout.setupWithViewPager(vp_fragment);
        vp_fragment.setOffscreenPageLimit(title.length);
        vp_fragment.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return title[position];
            }
        });

        return view;
    }

    private void initView(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        vp_fragment = (ViewPager) view.findViewById(R.id.vp_fragment);
    }
}
