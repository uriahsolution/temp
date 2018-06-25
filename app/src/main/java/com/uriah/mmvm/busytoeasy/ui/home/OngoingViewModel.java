package com.uriah.mmvm.busytoeasy.ui.home;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.uriah.mmvm.busytoeasy.data.ExampleRepository;
import com.uriah.mmvm.busytoeasy.data.local.entity.Datum;


import javax.inject.Inject;



public class OngoingViewModel extends ViewModel {
    private LiveData<Datum> itemLiveData;
    private ExampleRepository itemRepository;


    @Inject
    public OngoingViewModel(ExampleRepository itemRepository) {

        this.itemRepository = itemRepository;

    }

    public void init() {
        if (this.itemLiveData != null) {
            return;
        }
        itemLiveData = itemRepository.getItem();
    }

    public LiveData<Datum> getUser() {
        return this.itemLiveData;
    }

    public void checkNumber() {

    }
}
