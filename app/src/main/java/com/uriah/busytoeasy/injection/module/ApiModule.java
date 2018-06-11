package com.uriah.busytoeasy.injection.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import com.uriah.busytoeasy.data.remote.ApiService;

import retrofit2.Retrofit;

/**
 * Created by shivam on 29/5/17.
 */
@Module(includes = {NetworkModule.class})
public class ApiModule {

    @Provides
    @Singleton
    ApiService providePokemonApi(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }
}
