package cn.alanyuan.materialdemo.views.viewholders;

import android.view.View;
import android.widget.TextView;

import cn.alanyuan.materialdemo.R;
import cn.alanyuan.materialdemo.interfaces.OnRecylerItemClickListener;
import cn.alanyuan.materialdemo.interfaces.OnRecylerItemLongClickListener;

/**
 * Created by alanyuan on 15/3/20.
 */
public class SampleViewHolder extends BaseRecyclerViewHolder {
    public TextView name;
    public TextView content;
    public TextView index;


    public SampleViewHolder(View itemView, OnRecylerItemClickListener onRecylerItemClickListener, OnRecylerItemLongClickListener onRecylerItemLongClickListener) {
        super(itemView, onRecylerItemClickListener, onRecylerItemLongClickListener);
        name = (TextView) itemView.findViewById(R.id.name_tv);
        content = (TextView) itemView.findViewById(R.id.content_tv);
        index = (TextView) itemView.findViewById(R.id.index_tv);
    }
}
