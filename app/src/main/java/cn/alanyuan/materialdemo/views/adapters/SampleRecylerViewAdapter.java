package cn.alanyuan.materialdemo.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.alanyuan.materialdemo.models.SampleModel;

/**
 * Created by alanyuan on 15/3/19.
 */
public class SampleRecylerViewAdapter extends RecyclerView.Adapter<SampleRecylerViewAdapter.ViewHodler> {
    private List<SampleModel> models;

    public SampleRecylerViewAdapter(List<SampleModel> models) {
        this.models = models;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHodler holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public static class ViewHodler extends RecyclerView.ViewHolder {
        public TextView name;

        public ViewHodler(View itemView) {
            super(itemView);
        }
    }

}
