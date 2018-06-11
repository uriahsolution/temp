package com.uriah.busytoeasy.injection.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import com.uriah.busytoeasy.data.DataManager;
import com.uriah.busytoeasy.injection.ApplicationContext;
import com.uriah.busytoeasy.injection.module.AppModule;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    @ApplicationContext
    Context context();

    Application application();
    DataManager apiManager();
}
