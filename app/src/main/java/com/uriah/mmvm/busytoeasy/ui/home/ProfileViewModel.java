package com.uriah.mmvm.busytoeasy.ui.home;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.uriah.mmvm.busytoeasy.data.ExampleRepository;
import com.uriah.mmvm.busytoeasy.data.local.entity.Datum;


import javax.inject.Inject;

public class ProfileViewModel extends ViewModel {

    private LiveData<Datum> itemLiveData;
    private ExampleRepository exampleRepository;

    @Inject
    public ProfileViewModel(ExampleRepository itemRepository) {
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
