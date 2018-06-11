package com.uriah.busytoeasy.features.detail;

import com.uriah.busytoeasy.data.model.response.Pokemon;
import com.uriah.busytoeasy.data.model.response.Statistic;
import com.uriah.busytoeasy.features.base.MvpView;

public interface DetailMvpView extends MvpView {

    void showPokemon(Pokemon pokemon);

    void showStat(Statistic statistic);

    void showProgress(boolean show);

    void showError(Throwable error);
}
