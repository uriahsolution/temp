package com.uriah.mmvm.busytoeasy.ui.home;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.uriah.mmvm.busytoeasy.R;
import com.uriah.mmvm.busytoeasy.ui.demo.MainViewModel;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;


public class ProfileFragment extends Fragment {


    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private ProfileViewModel viewModel;

    public ProfileFragment() {

        // Required empty public constructor

    }

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.configureDagger();
        this.configureViewModel();

    }
    private void configureDagger(){
        AndroidSupportInjection.inject(this);
    }

    private void configureViewModel(){

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ProfileViewModel.class);
        }

}
