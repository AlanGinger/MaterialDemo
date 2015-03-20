package cn.alanyuan.materialdemo.views.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;

import cn.alanyuan.materialdemo.interfaces.OnRecylerItemClickListener;
import cn.alanyuan.materialdemo.interfaces.OnRecylerItemLongClickListener;

/**
 * BaseRecyclerViewHolder
 * Created by alanyuan on 15/3/20.
 */
public class BaseRecyclerViewHolder extends RecyclerView.ViewHolder implements OnClickListener, OnLongClickListener {
    private OnRecylerItemClickListener onRecylerItemClickListener;
    private OnRecylerItemLongClickListener onRecylerItemLongClickListener;

    public BaseRecyclerViewHolder(View itemView, OnRecylerItemClickListener onRecylerItemClickListener, OnRecylerItemLongClickListener onRecylerItemLongClickListener) {
        super(itemView);
        this.onRecylerItemClickListener = onRecylerItemClickListener;
        this.onRecylerItemLongClickListener = onRecylerItemLongClickListener;
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    /**
     * 点击事件监听
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        if (onRecylerItemClickListener != null) {
            onRecylerItemClickListener.onItemClick(v, getPosition());
        }
    }

    /**
     * 长按事件监听
     *
     * @param v
     * @return
     */
    @Override
    public boolean onLongClick(View v) {
        if (onRecylerItemLongClickListener != null) {
            onRecylerItemLongClickListener.onItemLongClick(v, getPosition());
        }
        return false;
    }
}
