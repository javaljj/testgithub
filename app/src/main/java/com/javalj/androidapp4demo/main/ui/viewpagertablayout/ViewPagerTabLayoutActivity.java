package com.javalj.androidapp4demo.main.ui.viewpagertablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.javalj.androidapp4demo.R;
import com.javalj.androidapp4demo.main.customwidgets.LTCustomViewPager;
import com.javalj.androidapp4demo.main.ui.MainActivity;
import com.javalj.androidapp4demo.main.ui.viewpagerfragment.FragmentViewPageAdapter;
import com.javalj.androidapp4demo.utils.Utils;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ViewPagerTabLayoutActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.viewPager)
    LTCustomViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_tab_layout);
        ButterKnife.bind(this);

        ArrayList<String> mList = Utils.getArrayData();
        for (int i = 0; i < mList.size(); i++) {
            TabLayout.Tab tab = tabLayout.newTab()
                    .setText(mList.get(i))
                    .setIcon(getResources().getIdentifier("ic_launcher", "mipmap", getPackageName()));
            tabLayout.addTab(tab);
        }
        FragmentViewPageAdapter fragmentViewPageAdapter = new FragmentViewPageAdapter(getSupportFragmentManager(), mList);
        //关联viewpager到tablayout
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setAdapter(fragmentViewPageAdapter);
        //app:tabMode="scrollable" 可以滚动
        tabLayout.setTabsFromPagerAdapter(fragmentViewPageAdapter);
        //设置指示器颜色
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorAccent));
        //关联tablayout 到viewpager
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.colorAccent));
        initActionbar();
    }

    private void initActionbar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(getIntent().getStringExtra(MainActivity.TITLE_NAME));
    }

}
