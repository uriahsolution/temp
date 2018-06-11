package com.uriah.busytoeasy.data.remote;

import com.uriah.busytoeasy.data.model.response.Pokemon;
import com.uriah.busytoeasy.data.model.response.PokemonListResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

   /* https://www.iasshiksha.com/api/notificationslider/notification_api.php*/

    @GET("pokemon")
    Single<PokemonListResponse> getPokemonList(@Query("limit") int limit);

    @GET("notification_api.php")
    Single<Pokemon> getPokemon(@Path("name") String name);


}
