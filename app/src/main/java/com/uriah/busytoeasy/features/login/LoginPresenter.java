package com.uriah.busytoeasy.features.login;

import com.uriah.busytoeasy.data.DataManager;
import com.uriah.busytoeasy.features.base.BasePresenter;

import javax.inject.Inject;

public class LoginPresenter extends BasePresenter<LoginMvpView> {

    private final DataManager dataManager;

    @Inject
    public LoginPresenter(DataManager dataManager){

        this.dataManager=dataManager;
    }

    @Override
    public void attachView(LoginMvpView mvpView) {
        super.attachView(mvpView);
    }

    public void sendMobileNumber(String mobileNumber){

    }

    public void validateOtp(String MobileNumber){


    }
}
