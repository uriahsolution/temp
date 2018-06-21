package com.uriah.mmvm.busytoeasy.ui.home;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.uriah.mmvm.busytoeasy.R;
import com.uriah.mmvm.busytoeasy.ui.home.adapter.OngoingAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class OngoingFragment extends Fragment {
    private OngoingViewModel mViewModel;
    private OngoingAdapter ongoingAdapter;
    SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.rv_ongoing)
    RecyclerView rv_ongoing;

    public static OngoingFragment newInstance() {
        return new OngoingFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.ongoing_fragment,container, false);
        Timber.d("onCreate view ");

        ButterKnife.bind(this,view);
        ongoingAdapter=new OngoingAdapter(getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rv_ongoing.setLayoutManager(mLayoutManager);

        rv_ongoing.setAdapter(ongoingAdapter);

        // SwipeRefreshLayout
        mSwipeRefreshLayout = view.findViewById(R.id.swipe_container);
        mSwipeRefreshLayout.setColorSchemeResources(

                R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark );

        mSwipeRefreshLayout.setOnRefreshListener(() -> Toast.makeText(getContext(), "Refresh", Toast.LENGTH_SHORT).show());

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(OngoingViewModel.class);
        Timber.d("on activity created ");
        // TODO: Use the ViewModel
    }


}
