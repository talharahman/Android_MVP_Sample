package com.example.planetsmvp;

import com.example.planetsmvp.model.Planet;
import com.example.planetsmvp.model.PlanetsWrapper;
import com.example.planetsmvp.network.PlanetAPI;
import com.example.planetsmvp.presenter.MainContract;
import com.example.planetsmvp.presenter.MainPresenter;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import retrofit2.Call;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PresenterTest {

    private MainContract.View view = mock(MainContract.View.class);
    private PlanetAPI api = mock(PlanetAPI.class);
    private MainContract.Presenter presenter = new MainPresenter(view, api);


    @Test
    public void when_list_is_empty_show_error(){
        //Given
        PlanetsWrapper response = new PlanetsWrapper(new ArrayList<Planet>());
        when(api.planets).thenReturn((Call<PlanetsWrapper>) response);

        //When
        presenter.planets;

        //Then
        verify(view, never()).onSuccess(Mockito.<Planet>anyList());
    }


}
