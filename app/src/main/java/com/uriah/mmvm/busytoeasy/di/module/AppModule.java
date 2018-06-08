package com.uriah.mmvm.busytoeasy.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.uriah.mmvm.busytoeasy.data.remote.ApiInterface;
import com.uriah.mmvm.busytoeasy.data.ItemRepository;
import com.uriah.mmvm.busytoeasy.data.local.MyDatabase;
import com.uriah.mmvm.busytoeasy.data.local.dao.ItemDao;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Philippe on 02/03/2018.
 */

@Module(includes = ViewModelModule.class)
public class AppModule {

    // --- DATABASE INJECTION ---

    @Provides
    @Singleton
    MyDatabase provideDatabase(Application application) {
        return Room.databaseBuilder(application,
                MyDatabase.class, "MyDatabase.db")
                .build();
    }

    @Provides
    @Singleton
    ItemDao provideItemDao(MyDatabase database) { return database.itemDao(); }

    // --- REPOSITORY INJECTION ---

    @Provides
    Executor provideExecutor() {
        return Executors.newSingleThreadExecutor();
    }


    @Provides
    @Singleton
    ItemRepository provideUserRepository(ApiInterface webservice, ItemDao userDao, Executor executor) {
        return new ItemRepository(webservice, userDao, executor);
    }

    // --- NETWORK INJECTION ---

    private static String BASE_URL = "https://www.iasshiksha.com/api/";

    @Provides
    Gson provideGson() { return new GsonBuilder().create(); }

    @Provides
    Retrofit provideRetrofit(Gson gson) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .baseUrl(BASE_URL)
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    ApiInterface provideApiInterface(Retrofit restAdapter) {
        return restAdapter.create(ApiInterface.class);
    }
}
