package com.javalj.androidapp4demo.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.javalj.androidapp4demo.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lijie on 2016/2/16.
 */
public class BaseListAdapter extends BaseAdapter {

    private LayoutInflater mInflater;

    private Context mContext;

    private ArrayList<String> mList;


    public BaseListAdapter(Context context, ArrayList<String> list) {
        this.mList = list;
        mInflater = LayoutInflater.from(context);
        this.mContext = context;
        notifyDataSetChanged();
    }

    public ArrayList<String> getData() {
        return mList == null ? (mList = new ArrayList<>()) : mList;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.democae, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.caseName.setText(mList.get(position));
        return convertView;
    }


    static class ViewHolder {
        @Bind(R.id.caseName)
        TextView caseName;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
