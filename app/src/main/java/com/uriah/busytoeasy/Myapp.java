package com.uriah.busytoeasy;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;
import com.singhajit.sherlock.core.Sherlock;
import com.squareup.leakcanary.LeakCanary;
import com.tspoon.traceur.Traceur;

import com.uriah.busytoeasy.injection.component.AppComponent;
import com.uriah.busytoeasy.injection.component.DaggerAppComponent;
import com.uriah.busytoeasy.injection.module.AppModule;
import com.uriah.busytoeasy.injection.module.NetworkModule;
import timber.log.Timber;

public class Myapp extends Application {

    private AppComponent appComponent;

    public static Myapp get(Context context) {
        return (Myapp) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            Stetho.initializeWithDefaults(this);
            LeakCanary.install(this);
            Sherlock.init(this);
            Traceur.enableLogging();
        }
    }

    public AppComponent getComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .networkModule(new NetworkModule(this, BuildConfig.POKEAPI_API_URL,"https://www.iasshiksha.com/api/notificationslider/notification_api.php"))
                    .appModule(new AppModule(this))
                    .build();
        }
        return appComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(AppComponent appComponent) {
        this.appComponent = appComponent;
    }
}
