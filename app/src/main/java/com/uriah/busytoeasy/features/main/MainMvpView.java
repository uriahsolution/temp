package com.uriah.busytoeasy.features.main;

import java.util.List;

import com.uriah.busytoeasy.features.base.MvpView;

public interface MainMvpView extends MvpView {

    void showPokemon(List<String> pokemon);

    void showProgress(boolean show);

    void showError(Throwable error);
}
