package com.javalj.androidapp4demo.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.javalj.androidapp4demo.R;
import com.javalj.androidapp4demo.main.bean.MkBean;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by lijie on 2016/2/18.
 */
public class DemoRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<MkBean> mList;
    private Context mContext;
    private LayoutInflater inflater;

    public static final int TYPE1 = 0x001;
    public static final int TYPE2 = 0x002;


    public DemoRecycleAdapter(Context context, ArrayList<MkBean> list) {
        this.mContext = context;
        this.mList = list;
        inflater = LayoutInflater.from(context);
    }

    public void addListData(ArrayList<MkBean> list) {
        mList.addAll(list);
        notifyDataSetChanged();
    }

    public void addData(MkBean mkBean) {
        mList.add(mkBean);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).getType();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case TYPE1:
                return new ViewHolder(inflater.inflate(R.layout.xxx, parent, false));
            case TYPE2:
                return new ViewHolder(inflater.inflate(R.layout.ooo, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).text1.setText(mList.get(position).getXxxx());
            ((ViewHolder) holder).text2.setText(mList.get(position).getOooo());
        }
    }


    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.text1)
        TextView text1;
        @Bind(R.id.text2)
        TextView text2;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
