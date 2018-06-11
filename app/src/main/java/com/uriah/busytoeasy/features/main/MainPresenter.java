package com.uriah.busytoeasy.features.main;

import android.annotation.SuppressLint;

import javax.inject.Inject;

import com.uriah.busytoeasy.data.DataManager;
import com.uriah.busytoeasy.features.base.BasePresenter;
import com.uriah.busytoeasy.injection.ConfigPersistent;
import com.uriah.busytoeasy.util.rx.scheduler.SchedulerUtils;

@ConfigPersistent
public class MainPresenter extends BasePresenter<MainMvpView> {

    private final DataManager dataManager;

    @Inject
    public MainPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void attachView(MainMvpView mvpView) {
        super.attachView(mvpView);
    }

    @SuppressLint("CheckResult")
    public void getPokemon(int limit) {
        checkViewAttached();
        getView().showProgress(true);
        dataManager
                .getPokemonList(limit)
                .compose(SchedulerUtils.ioToMain())
                .subscribe(
                        pokemons -> {
                            getView().showProgress(false);
                            getView().showPokemon(pokemons);
                        },
                        throwable -> {
                            getView().showProgress(false);
                            getView().showError(throwable);
                        });
    }
}
