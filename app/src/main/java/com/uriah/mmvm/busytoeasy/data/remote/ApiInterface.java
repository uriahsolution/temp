package com.uriah.mmvm.busytoeasy.data.remote;


import com.uriah.mmvm.busytoeasy.data.remote.local.entity.AlertResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("notificationslider/notification_api.php")
    Call<AlertResponse> getAlerts();


}


