package com.javalj.androidapp4demo.main.ui.recycleview;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.javalj.androidapp4demo.R;
import com.javalj.androidapp4demo.main.adapter.DemoRecycleAdapter;
import com.javalj.androidapp4demo.main.bean.MkBean;
import com.javalj.androidapp4demo.main.ui.MainActivity;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecycleViewDemoActivity extends AppCompatActivity {

    @Bind(R.id.recycleView)
    RecyclerView recycleView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private ArrayList<MkBean> mList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_demo);
        ButterKnife.bind(this);
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0) {
                mList.add(new MkBean(String.valueOf(i), String.valueOf(1000 - i), 0x002));
            } else {
                mList.add(new MkBean(String.valueOf(i), String.valueOf(1000 - i), 0x001));
            }
        }
        recycleView.setAdapter(new DemoRecycleAdapter(this, mList));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycleView.setLayoutManager(linearLayoutManager);
        initActionbar();
    }

    private void initActionbar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(getIntent().getStringExtra(MainActivity.TITLE_NAME));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            this.finish();

        return super.onOptionsItemSelected(item);
    }
}
