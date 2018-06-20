package com.uriah.mmvm.busytoeasy.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.uriah.mmvm.busytoeasy.R;
import com.uriah.mmvm.busytoeasy.ui.home.adapter.AdapterOne;


import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeFragment extends Fragment {



    public HomeFragment() {
        // Required empty public constructor
    }


    AdapterOne adapterOne;
    private HashMap<String, Integer> url_maps;
    @BindView(R.id.slider1)
    SliderLayout mDemoSlider1;
    @BindView(R.id.slider2)
    SliderLayout mDemoSlider2;
    //recycler view
    @BindView(R.id.rv_1)
    RecyclerView rv_1;
    View view;
    @BindView(R.id.ll_test)
    LinearLayout ll;


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_home, container, false);

        ButterKnife.bind(this,view);

        setSlider();

        setRecycler();
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        return  view;

    }
    private void setRecycler() {
        adapterOne=new AdapterOne(getActivity());
        rv_1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true));
        rv_1.setAdapter(adapterOne);
        rv_1.setVisibility(View.VISIBLE);

        rv_1.postDelayed(new Runnable() {
            @Override
            public void run() {
                rv_1.smoothScrollToPosition(adapterOne.getItemCount());

            }
        },1000);
    }

    private void setSlider() {
        url_maps= new HashMap<String, Integer>();
        url_maps.put("1",R.drawable.a);
        url_maps.put("2",R.drawable.aab);
        url_maps.put("3",R.drawable.aae);
        url_maps.put("4",R.drawable.aag);
        url_maps.put("5",R.drawable.aah);
        url_maps.put("6",R.drawable.aaf);

        mDemoSlider1.removeAllSliders();
        mDemoSlider2.removeAllSliders();
        for(String name : url_maps.keySet()){
            BaseSliderView textSliderView = new TextSliderView(getActivity());
            // initialize a SliderLayout
            textSliderView
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);


            //add your extra information

            /*textSliderView.getBundle()
                    .putString("extra",name);*/

            mDemoSlider1.addSlider(textSliderView);
            mDemoSlider2.addSlider(textSliderView);


        }

        mDemoSlider1.startAutoCycle();
        mDemoSlider2.startAutoCycle();
    }


}
