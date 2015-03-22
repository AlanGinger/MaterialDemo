package cn.alanyuan.materialdemo.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.alanyuan.materialdemo.R;
import cn.alanyuan.materialdemo.interfaces.OnRecylerItemClickListener;
import cn.alanyuan.materialdemo.interfaces.OnRecylerItemLongClickListener;
import cn.alanyuan.materialdemo.models.SampleModel;
import cn.alanyuan.materialdemo.views.adapters.SampleRecylerViewAdapter;

/**
 * RecyclerView
 * Created by alanyuan on 15/3/19.
 */
public class RecyclerViewActivity extends Activity implements OnRecylerItemClickListener, OnRecylerItemLongClickListener {
    public final static String Tag = "RecyclerViewActivity";
    protected RecyclerView mRecyclerView;
    protected SampleRecylerViewAdapter mAdapter;
    protected List<SampleModel> models = new ArrayList<SampleModel>();
    int i = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        if (savedInstanceState!=null){

        }
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new SampleRecylerViewAdapter(getData());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        setListener();
    }

    protected List<SampleModel> getData() {
        for (int i = 0; i < 50; i++) {
            models.add(new SampleModel("小新" + i + "号", i, "我叫蜡笔小新"));
        }
        return models;
    }

    protected void setListener() {
        mAdapter.setOnItemClickListener(this);
        mAdapter.setOnItemLongClickListener(this);
    }

    @Override
    public void onItemClick(View view, int postion) {
        models.remove(postion);
        mAdapter.notifyItemRemoved(postion);
    }

    @Override
    public void onItemLongClick(View view, int position) {
        models.add(position, new SampleModel("哆啦A梦", 101, "哆啦A梦爱吃铜锣烧"));
        mAdapter.notifyItemInserted(position);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
