package com.douya.exercise.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.douya.exercise.R;
import com.douya.exercise.fragment.MyFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp_main;
    private RadioGroup rg_mian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        vp_main.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return new MyFragment();
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
        rg_mian.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.rbt_zhuYe:
                        vp_main.setCurrentItem(0);
                        break;

                }
            }
        });
        vp_main.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position){
                    case 0:
                        rg_mian.check(R.id.rbt_zhuYe);
                        break;
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView() {
        vp_main = (ViewPager) findViewById(R.id.vp_main);
        rg_mian = (RadioGroup) findViewById(R.id.rg_mian);
    }
}
