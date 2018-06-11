package com.uriah.busytoeasy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import com.uriah.busytoeasy.common.TestDataFactory;
import com.uriah.busytoeasy.data.DataManager;
import com.uriah.busytoeasy.data.model.response.NamedResource;
import com.uriah.busytoeasy.data.model.response.Pokemon;
import com.uriah.busytoeasy.data.model.response.PokemonListResponse;
import com.uriah.busytoeasy.data.remote.ApiService;
import com.uriah.busytoeasy.util.RxSchedulersOverrideRule;
import io.reactivex.Single;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by shivam on 29/5/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class DataManagerTest {

    @Rule
    public final RxSchedulersOverrideRule overrideSchedulersRule = new RxSchedulersOverrideRule();

    @Mock
    private ApiService mockApiService;

    private DataManager dataManager;

    @Before
    public void setUp() {
        dataManager = new DataManager(mockApiService);
    }

    @Test
    public void getPokemonListCompletesAndEmitsPokemonList() {
        List<NamedResource> namedResourceList = TestDataFactory.makeNamedResourceList(5);
        PokemonListResponse pokemonListResponse = new PokemonListResponse();
        pokemonListResponse.results = namedResourceList;

        when(mockApiService.getPokemonList(anyInt()))
                .thenReturn(Single.just(pokemonListResponse));

        dataManager
                .getPokemonList(10)
                .test()
                .assertComplete()
                .assertValue(TestDataFactory.makePokemonNameList(namedResourceList));
    }

    @Test
    public void getPokemonCompletesAndEmitsPokemon() {
        String name = "charmander";
        Pokemon pokemon = TestDataFactory.makePokemon(name);
        when(mockApiService.getPokemon(anyString())).thenReturn(Single.just(pokemon));

        dataManager.getPokemon(name).test().assertComplete().assertValue(pokemon);
    }
}
