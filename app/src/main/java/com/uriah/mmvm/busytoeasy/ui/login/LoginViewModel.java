package com.uriah.mmvm.busytoeasy.ui.login;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.uriah.mmvm.busytoeasy.data.ExampleRepository;

import com.uriah.mmvm.busytoeasy.data.local.entity.Datum;


import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class LoginViewModel extends ViewModel {


    private LiveData<Datum> itemLiveData;
    private ExampleRepository exampleRepository;

    @Inject
    public LoginViewModel(ExampleRepository itemRepository) {
        this.exampleRepository = itemRepository;
    }
    // ----

    public void init() {
        if (this.itemLiveData != null) {
            return;
        }
        itemLiveData = exampleRepository.getItem();
    }

    public LiveData<Datum> getUser() {
        return this.itemLiveData;
    }
}
