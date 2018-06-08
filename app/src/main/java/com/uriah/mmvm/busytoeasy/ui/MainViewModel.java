package com.uriah.mmvm.busytoeasy.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.uriah.mmvm.busytoeasy.data.ItemRepository;
import com.uriah.mmvm.busytoeasy.data.local.entity.Item;

import javax.inject.Inject;

public class MainViewModel extends ViewModel {

    private LiveData<Item> itemLiveData;
    private ItemRepository itemRepository;

    @Inject
    public MainViewModel(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    // ----

    public void init() {
        if (this.itemLiveData != null) {
            return;
        }
        itemLiveData = itemRepository.getItem();
    }

    public LiveData<Item> getUser() {
        return this.itemLiveData;
    }

}
