package com.uriah.mmvm.busytoeasy.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;


import com.uriah.mmvm.busytoeasy.di.key.ViewModelKey;
import com.uriah.mmvm.busytoeasy.ui.MainViewModel;
import com.uriah.mmvm.busytoeasy.ui.login.LoginViewModel;
import com.uriah.mmvm.busytoeasy.viewmodel.FactoryViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by Philippe on 02/03/2018.
 */

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindMainViewModel(MainViewModel repoViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    abstract ViewModel bindLoginViewModel(LoginViewModel loginViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(FactoryViewModel factory);
}
