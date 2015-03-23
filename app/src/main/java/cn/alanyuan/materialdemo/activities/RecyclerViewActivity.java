package cn.alanyuan.materialdemo.activities;

import android.app.Activity;
import android.graphics.Outline;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import cn.alanyuan.materialdemo.R;
import cn.alanyuan.materialdemo.interfaces.OnRecylerItemClickListener;
import cn.alanyuan.materialdemo.interfaces.OnRecylerItemLongClickListener;
import cn.alanyuan.materialdemo.models.SampleModel;
import cn.alanyuan.materialdemo.views.adapters.SampleRecylerViewAdapter;
import cn.alanyuan.materialdemo.views.widgets.SampleDivider;

/**
 * RecyclerView 简单示例
 * Created by alanyuan on 15/3/19.
 */
public class RecyclerViewActivity extends Activity implements OnRecylerItemClickListener, OnRecylerItemLongClickListener, View.OnClickListener {
    public final static String Tag = "RecyclerViewActivity";
    protected RecyclerView mRecyclerView;
    protected SampleRecylerViewAdapter mAdapter;
    protected List<SampleModel> models = new ArrayList<SampleModel>();
    protected LinearLayoutManager layoutManager;
    protected View fabView;
    protected FrameLayout mDeleteBar;
    protected SwipeRefreshLayout swipeRefreshLayout;
    int i = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_recycle);
        if (savedInstanceState != null) {

        }
        mDeleteBar = (FrameLayout) findViewById(R.id.deleteBar);
        initFab();
        initView();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new SampleRecylerViewAdapter(getData());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new SampleDivider(this));
        setListener();
    }

    protected void initView() {
        //findview
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        //设置卷内的颜色
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light);
        //设置下拉刷新监听
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //.......操作

                //停止刷新动画
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }


    //绘制圆形按钮
    protected void initFab() {
        ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                //获取按钮的尺寸
                int fabSize = getResources().getDimensionPixelSize(R.dimen.fab_size);
                //设置轮廓的尺寸
                outline.setOval(-4, -4, fabSize + 2, fabSize + 2);
            }
        };

        fabView = findViewById(R.id.fab_add);
        fabView.setOutlineProvider(viewOutlineProvider);
    }

    protected List<SampleModel> getData() {
        for (int i = 0; i < 100; i++) {
            models.add(new SampleModel("小新" + i + "号", i, "我叫蜡笔小新"));
        }
        return models;
    }

    protected void setListener() {
//        setScrollListener();
        mAdapter.setOnItemClickListener(this);
        mAdapter.setOnItemLongClickListener(this);
        fabView.setOnClickListener(this);
    }

    @Override
    public void onItemClick(View view, int position) {
        mAdapter.removeItem(position);
    }

    @Override
    public void onItemLongClick(View view, int position) {
        mAdapter.addItem(position);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_add:

                int position = layoutManager.findFirstCompletelyVisibleItemPosition();
                mAdapter.addItem(position);
        }
    }



    public void setScrollListener() {

        //  为RecyclerView控件设置滚动事件
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                super.onScrolled(recyclerView, dx, dy);
                //  dx：大于0，向右滚动    小于0，向左滚动
                //  dy：大于0，向上滚动    小于0，向下滚动

                if (dy > 0) {
                    //  列表向上滚动，隐藏删除面板
                    if (mDeleteBar.getVisibility() == View.VISIBLE) {
                        hideDeleteBar();
                    }
                } else {
                    // 列表向下滚动，显示删除面板
                    if (mDeleteBar.getVisibility() == View.GONE) {
                        showDeleteBar();
                    }
                }

            }
        });
    }

    private void showDeleteBar() {

        mDeleteBar.startAnimation(AnimationUtils.loadAnimation(this,
                R.anim.translate_up_on));

        mDeleteBar.setVisibility(View.VISIBLE);
    }

    private void hideDeleteBar() {

        mDeleteBar.startAnimation(AnimationUtils.loadAnimation(this,
                R.anim.translate_up_off));

        mDeleteBar.setVisibility(View.GONE);

    }

}