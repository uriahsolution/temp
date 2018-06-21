package com.uriah.mmvm.busytoeasy.ui.home;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uriah.mmvm.busytoeasy.R;
import com.uriah.mmvm.busytoeasy.ui.home.adapter.HistoryAdapter;
import com.uriah.mmvm.busytoeasy.ui.home.adapter.OngoingAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class HistoryFragment extends Fragment {

    private HistoryViewModel mViewModel;

    private HistoryAdapter ongoingAdapter;

    @BindView(R.id.rv_ongoing)
    RecyclerView rv_history;

    public static HistoryFragment newInstance() {
        return new HistoryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ongoing_fragment,container, false);

        ButterKnife.bind(this,view);
        ongoingAdapter=new HistoryAdapter(getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rv_history.setLayoutManager(mLayoutManager);
        rv_history.setAdapter(ongoingAdapter);

        return view;
    }
    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HistoryViewModel.class);
        // TODO: Use the ViewModel
    }

}
