package com.example.planetsmvp.network

import com.example.planetsmvp.model.PlanetsWrapper
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PlanetAPI {

    @GET(END_POINT)
    fun getPlanets(): Call<PlanetsWrapper>

    companion object {
        const val END_POINT = "JDVila/storybook/master/planets.json"
    }
}

object PlanetRetrofit {

    private const val BASE_URL = "https://raw.githubusercontent.com/"
    @JvmStatic
    var instance: Retrofit? = null
        get() {
            if (field == null) {
                field = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return field
        }
        private set
}