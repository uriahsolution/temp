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
import android.widget.Toast;

import com.uriah.mmvm.busytoeasy.R;
import com.uriah.mmvm.busytoeasy.data.local.entity.Item;
import com.uriah.mmvm.busytoeasy.ui.login.bus.Events;
import com.uriah.mmvm.busytoeasy.ui.login.bus.GlobalBus;


import org.greenrobot.eventbus.Subscribe;

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

            Events.FragmentActivityMessage fragmentActivityMessageEvent =
                    new Events.FragmentActivityMessage(
                            "Test ");
            GlobalBus.getBus().post(fragmentActivityMessageEvent);



        });

        // Register the event to subscribe.
        GlobalBus.getBus().register(this);


        return view;

    }

    //Event Bus
    @Subscribe
    public void getMessage(Events.ActivityFragmentMessage activityFragmentMessage) {
        //Write code to perform action after event is received.

        Toast.makeText(getActivity(),
                "aaaaaaaaaaa" +
                        " " + activityFragmentMessage.getMessage(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Unregister the registered event.
        GlobalBus.getBus().unregister(this);
    }


    //Event Bus ends

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
