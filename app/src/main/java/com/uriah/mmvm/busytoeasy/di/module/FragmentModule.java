package com.uriah.mmvm.busytoeasy.di.module;


import com.uriah.mmvm.busytoeasy.ui.demo.MainFragment;
import com.uriah.mmvm.busytoeasy.ui.login.LoginFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Philippe on 02/03/2018.
 */

@Module
public abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract MainFragment contributeUserProfileFragment();

    @ContributesAndroidInjector
    abstract LoginFragment contributeLoginFragment();
}
