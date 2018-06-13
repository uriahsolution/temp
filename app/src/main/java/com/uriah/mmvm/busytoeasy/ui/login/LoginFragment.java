package com.uriah.mmvm.busytoeasy.ui.login;




import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.uriah.mmvm.busytoeasy.R;
import com.uriah.mmvm.busytoeasy.data.local.entity.Item;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;


public class LoginFragment extends Fragment {

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private LoginViewModel mViewModel;

    @BindView(R.id.btn_login)
    Button btn_login;



    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.login_fragment, container, false);
        ButterKnife.bind(this,view);

        btn_login.setOnClickListener(v -> {

            mViewModel.checkNumber();
        });


        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.configureDagger();
        this.configureViewModel();

    }

    // -----------------
    // CONFIGURATION
    // -----------------

    private void configureDagger(){
        AndroidSupportInjection.inject(this);
    }

    private void configureViewModel(){

        mViewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel.class);
        mViewModel.init();
        mViewModel.getUser().observe(this, user -> updateUI(user));

    }

    private void updateUI(@Nullable Item item){
        if (item != null){

            }
    }

}
