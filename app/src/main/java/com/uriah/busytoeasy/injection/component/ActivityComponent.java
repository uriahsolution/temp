package com.uriah.busytoeasy.injection.component;

import dagger.Subcomponent;
import com.uriah.busytoeasy.features.detail.DetailActivity;
import com.uriah.busytoeasy.features.login.LoginActivity;
import com.uriah.busytoeasy.features.main.MainActivity;
import com.uriah.busytoeasy.injection.PerActivity;
import com.uriah.busytoeasy.injection.module.ActivityModule;

@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

    void inject(DetailActivity detailActivity);

    void inject(LoginActivity loginActivity);
}
