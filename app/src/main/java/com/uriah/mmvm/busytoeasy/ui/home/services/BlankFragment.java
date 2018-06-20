package com.uriah.mmvm.busytoeasy.ui.home.services;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uriah.mmvm.busytoeasy.R;


import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    @BindView(R.id.rv_blanc)
    RecyclerView rv_1;
    BlankAdapter adapterOne;
    View view;
    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_blank, container, false);

        ButterKnife.bind(this,view);
        adapterOne=new BlankAdapter(getActivity());
        rv_1.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_1.setAdapter(adapterOne);
        rv_1.setVisibility(View.VISIBLE);

        return view;
    }

}
