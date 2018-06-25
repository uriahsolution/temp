package com.uriah.mmvm.busytoeasy.data.remote;



import com.uriah.mmvm.busytoeasy.data.local.entity.Example;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


   /*Demo Api--- https://reqres.in/api/users/2

    {
        "page": 2,
            "per_page": 3,
            "total": 12,
            "total_pages": 4,
            "data": [
        {
            "id": 4,
                "first_name": "Eve",
                "last_name": "Holt",
                "avatar": "https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg"
        },
        {
            "id": 5,
                "first_name": "Charles",
                "last_name": "Morris",
                "avatar": "https://s3.amazonaws.com/uifaces/faces/twitter/stephenmoon/128.jpg"
        },
        {
            "id": 6,
                "first_name": "Tracey",
                "last_name": "Ramos",
                "avatar": "https://s3.amazonaws.com/uifaces/faces/twitter/bigmancho/128.jpg"
        }
    ]
    }
    */


    @GET("users/2")
    Call<Example> getDemoData();


}


