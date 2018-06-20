package com.uriah.mmvm.busytoeasy.ui.home.services;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import com.uriah.mmvm.busytoeasy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ashet on 08-02-2018.
 */

public class BlankAdapter extends RecyclerView.Adapter<BlankAdapter.ViewHolder> {

    private Context ctx;
    public BlankAdapter(Context ctx){
        this.ctx=ctx;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)


    {
        View v = LayoutInflater.from(ctx)
                .inflate(R.layout.temp_row, parent, false);
        return new BlankAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.ll_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener

    {

        @BindView(R.id.ll_service)
        LinearLayout ll_service;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }

        @Override
        public void onClick(View v) {


        }
    }

}


