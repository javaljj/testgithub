package com.javalj.androidapp4demo.main.ui.RecycleRefreshViewDemo;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by lijie on 2016/2/29.
 */
public class JavaljSwipeRefreshLayout<T> extends SwipeRefreshLayout {

    public static final int NO_ITEM = 0x001;
    public static final int LOAD_MORE = 0x002;
    public static final int NO_MORE = 0x003;
    private ListView listView;

    private ArrayList<T> mList;

    private LoadMoreLinstener loadMoreLinstener;

    public JavaljSwipeRefreshLayout(Context context) {
        super(context);
    }

    public JavaljSwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void addListView(ListView listView) {
        this.listView = listView;
        loadMore();
    }

    public void addAll(ListView listView, ArrayList<T> list) {
        this.listView = listView;
        this.mList = list;
        loadMore();
    }

    public void setLoadMoreLinstener(LoadMoreLinstener loadMoreLinstener) {
        this.loadMoreLinstener = loadMoreLinstener;
    }

    private void loadMore() {
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem + visibleItemCount == totalItemCount) {
                    if (totalItemCount > 0) {
                        setRefreshing(true);
                        loadMoreLinstener.loadMore();
                    }
                }
            }
        });
    }

    abstract class LoadMoreLinstener {
        abstract void loadMore();
    }
}
