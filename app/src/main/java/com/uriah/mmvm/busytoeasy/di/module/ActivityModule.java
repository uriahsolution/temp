package com.uriah.mmvm.busytoeasy.di.module;


import com.uriah.mmvm.busytoeasy.ui.demo.MainActivity;
import com.uriah.mmvm.busytoeasy.ui.home.HomeActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Philippe on 02/03/2018.
 */

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract HomeActivity contributeHomeActivity();


}
