package com.uriah.mmvm.busytoeasy.data.remote;

import android.arch.lifecycle.LiveData;
import android.util.Log;
import android.widget.Toast;


import com.uriah.mmvm.busytoeasy.data.remote.ApiInterface;
import com.uriah.mmvm.busytoeasy.data.remote.local.dao.ItemDao;
import com.uriah.mmvm.busytoeasy.data.remote.local.entity.AlertResponse;
import com.uriah.mmvm.busytoeasy.data.remote.local.entity.Item;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
public class ItemRepository {

    private static int FRESH_TIMEOUT_IN_MINUTES = 1;

    private final ApiInterface webservice;
    private final ItemDao itemDao;
    private final Executor executor;

    @Inject
    public ItemRepository(ApiInterface webservice, ItemDao itemDao, Executor executor) {
        this.webservice = webservice;
        this.itemDao = itemDao;
        this.executor = executor;
    }

    // ---

    public LiveData<Item> getItem() {
        refreshItem(); // try to refresh data if possible from Github Api
        return itemDao.load(); // return a LiveData directly from the database.
    }

    // ---

    private void refreshItem() {
        executor.execute(() -> {
            // Check if user was fetched recently
            boolean userExists = (itemDao.hasUser(getMaxRefreshTime(new Date())) != null);
            // If user have to be updated
            if (!userExists) {
                webservice.getAlerts().enqueue(new Callback<List<AlertResponse>>() {
                    @Override
                    public void onResponse(Call<List<AlertResponse>> call, Response<List<AlertResponse>> response) {


                    }

                    @Override
                    public void onFailure(Call<List<AlertResponse>> call, Throwable t) {



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
