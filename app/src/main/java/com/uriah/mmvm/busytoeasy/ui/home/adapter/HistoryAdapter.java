package com.uriah.mmvm.busytoeasy.ui.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uriah.mmvm.busytoeasy.R;


import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Ashet on 08-02-2018.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {




    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)

    {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_history_item, parent, false);
        return new HistoryAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) { }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener

    {


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @Override
        public void onClick(View v) {


        }
    }

}



