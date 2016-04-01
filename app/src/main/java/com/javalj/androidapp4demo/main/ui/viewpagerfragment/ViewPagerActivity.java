package com.javalj.androidapp4demo.main.ui.viewpagerfragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.javalj.androidapp4demo.R;
import com.javalj.androidapp4demo.main.customwidgets.LTCustomViewPager;
import com.javalj.androidapp4demo.main.ui.MainActivity;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ViewPagerActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.viewPager)
    LTCustomViewPager viewPager;
    private ArrayList<String> mList = new ArrayList<>();
    public static final int A = 0x001;
    public int status = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        ButterKnife.bind(this);
        String[] arrays = getResources().getStringArray(R.array.democase);
        for (String array : arrays) {
            mList.add(array);
        }
        FragmentViewPageAdapter fragmentViewPageAdapter = new FragmentViewPageAdapter(getSupportFragmentManager(), mList);
        viewPager.setAdapter(fragmentViewPageAdapter);
        viewPager.setOffscreenPageLimit(3);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(ViewPagerActivity.this, String.valueOf(position) + " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        initActionbar();
    }

    private void initActionbar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(getIntent().getStringExtra(MainActivity.TITLE_NAME));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.view_pager_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            this.finish();

        switch (item.getItemId()) {
            case R.id.view_pager_menu:
                status = A;
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
