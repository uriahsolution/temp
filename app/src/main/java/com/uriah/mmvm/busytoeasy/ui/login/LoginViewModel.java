package com.uriah.mmvm.busytoeasy.ui.login;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import com.uriah.mmvm.busytoeasy.data.ItemRepository;
import com.uriah.mmvm.busytoeasy.data.local.entity.Item;
import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class LoginViewModel extends ViewModel {


    private LiveData<Item> itemLiveData;
    private ItemRepository itemRepository;
    protected CompositeDisposable compositeDisposable;

    LoginFragment view;


    @Inject
    public LoginViewModel(ItemRepository itemRepository) {

        this.itemRepository = itemRepository;

    }

    public void init() {
        if (this.itemLiveData != null) {
            return;
        }
        itemLiveData = itemRepository.getItem();
    }

    public LiveData<Item> getUser() {
        return this.itemLiveData;
    }

    public void checkNumber() {


    }
}
