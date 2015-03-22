package cn.alanyuan.materialdemo.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.alanyuan.materialdemo.R;
import cn.alanyuan.materialdemo.interfaces.OnRecylerItemClickListener;
import cn.alanyuan.materialdemo.interfaces.OnRecylerItemLongClickListener;
import cn.alanyuan.materialdemo.models.SampleModel;
import cn.alanyuan.materialdemo.views.viewholders.BaseRecyclerViewHolder;
import cn.alanyuan.materialdemo.views.viewholders.SampleViewHolder;

/**
 * RecyclerView 的示例 Adapter
 * Created by alanyuan on 15/3/19.
 */
public class SampleRecylerViewAdapter extends RecyclerView.Adapter<SampleViewHolder> {
    private List<SampleModel> models = new ArrayList<SampleModel>();
    private SampleModel model;
    private OnRecylerItemClickListener onRecylerItemClickListener;
    private OnRecylerItemLongClickListener onRecylerItemLongClickListener;

    public SampleRecylerViewAdapter(List<SampleModel> models) {
        this.models = models;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public SampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_sample_recyclerview
                , parent
                , false);
        SampleViewHolder viewHodler = new SampleViewHolder(view, onRecylerItemClickListener, onRecylerItemLongClickListener);
        return viewHodler;
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(SampleViewHolder holder, int position) {
        model = models.get(position);
        holder.name.setText(model.name);
        holder.content.setText(model.content);
        holder.index.setText(position + "");
    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return models.size();
    }

    //增加Item
    public void addItem(int postion){

        notifyItemInserted(postion);
    }

    //删除Item
    public void removeItem(int postion){


        notifyItemRemoved(postion);
    }

    //设置点击监听事件
    public void setOnItemClickListener(OnRecylerItemClickListener onRecylerItemClickListener) {
        this.onRecylerItemClickListener = onRecylerItemClickListener;
    }

    public void setOnItemLongClickListener(OnRecylerItemLongClickListener onRecylerItemLongClickListener) {
        this.onRecylerItemLongClickListener = onRecylerItemLongClickListener;
    }

}
