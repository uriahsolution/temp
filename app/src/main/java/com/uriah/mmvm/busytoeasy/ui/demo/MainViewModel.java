package com.uriah.mmvm.busytoeasy.ui.demo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.uriah.mmvm.busytoeasy.data.ItemRepository;
import com.uriah.mmvm.busytoeasy.data.local.entity.Item;
import com.uriah.mmvm.busytoeasy.data.remote.ApiInterface;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel {

    private LiveData<Item> itemLiveData;

    public LiveData<Item> getUsers() {
        if (itemLiveData == null) {
            itemLiveData = new MutableLiveData<Item>();
            loadUsers();
        }
        return itemLiveData;
    }

    private void loadUsers() {




    }

}
