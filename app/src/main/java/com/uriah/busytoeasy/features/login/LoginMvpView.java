package com.uriah.busytoeasy.features.login;

import com.uriah.busytoeasy.features.base.MvpView;

public interface LoginMvpView extends MvpView {


    void showProgress(boolean show);
    void showError(Throwable error);

}
