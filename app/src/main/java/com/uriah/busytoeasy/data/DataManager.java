package com.uriah.busytoeasy.data;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.uriah.busytoeasy.data.model.response.Pokemon;
import com.uriah.busytoeasy.data.remote.ApiService;
import io.reactivex.Single;

/**
 * Created by shivam on 29/5/17.
 */
@Singleton
public class DataManager {

    private ApiService apiService;

    @Inject
    public DataManager(ApiService pokemonService) {
        this.apiService = pokemonService;
    }

    public Single<List<String>> getPokemonList(int limit) {
        return apiService
                .getPokemonList(limit)
                .toObservable()
                .flatMapIterable(namedResources -> namedResources.results)
                .map(namedResource -> namedResource.name)
                .toList();
    }

    public Single<Pokemon> getPokemon(String name) {
        return apiService.getPokemon(name);
    }

}
