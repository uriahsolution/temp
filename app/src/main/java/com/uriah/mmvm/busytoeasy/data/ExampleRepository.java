package com.uriah.mmvm.busytoeasy.data;

import android.arch.lifecycle.LiveData;
import android.util.Log;


import com.uriah.mmvm.busytoeasy.data.local.dao.ExampleDao;

import com.uriah.mmvm.busytoeasy.data.local.entity.Datum;
import com.uriah.mmvm.busytoeasy.data.local.entity.Example;

import com.uriah.mmvm.busytoeasy.data.remote.ApiInterface;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Philippe on 02/03/2018.
 */

@Singleton
public class ExampleRepository {

    private static int FRESH_TIMEOUT_IN_MINUTES = 1;

    private final ApiInterface webservice;
    private final ExampleDao exampleDao;
    private final Executor executor;


    @Inject
    public ExampleRepository(ApiInterface webservice, ExampleDao itemDao, Executor executor) {
        this.webservice = webservice;
        this.exampleDao = itemDao;
        this.executor = executor;
    }

    // ---

    public LiveData<Datum> getItem() {
        refreshItem(); // try to refresh data if possible from Github Api
        return exampleDao.load(); // return a LiveData directly from the database.
    }

    // ---

    private void refreshItem() {
        executor.execute(() -> {
            // Check if user was fetched recently
            boolean userExists = (exampleDao.hasUser(getMaxRefreshTime(new Date())) != null);
            // If user have to be updated
            if (!userExists) {
                webservice.getDemoData().enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        Example alertResponse = response.body();

                        executor.execute(() -> {
                            Datum datum = alertResponse.getData().get(0);
                            datum.setLastRefresh(new Date());
                            exampleDao.save(datum);
                        });
                    }

                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {

                    }


        });


            }
        });
    }

    // ---

    private Date getMaxRefreshTime(Date currentDate){
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.MINUTE, -FRESH_TIMEOUT_IN_MINUTES);
        return cal.getTime();
    }
}

