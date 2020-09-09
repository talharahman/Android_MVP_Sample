package com.example.planetsmvp.presenter

import com.example.planetsmvp.model.Planet
import com.example.planetsmvp.model.PlanetsWrapper
import com.example.planetsmvp.network.PlanetAPI
import com.example.planetsmvp.presenter.MainContract.Presenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainPresenter(private val view: MainContract.View,
                    private val api: PlanetAPI?) : Presenter {
    override val planets: Unit
        get() {
            api!!.getPlanets()
                    .enqueue(object : Callback<PlanetsWrapper> {
                        override fun onResponse(call: Call<PlanetsWrapper>, response: Response<PlanetsWrapper>) {
                            val planets: List<Planet?> = response.body()!!.planets
                            if (planets.isNotEmpty()) {
                                view.onSuccess(planets)
                            }
                        }

                        override fun onFailure(call: Call<PlanetsWrapper>, t: Throwable) {
                            view.onError(t.cause)
                        }
                    })
        }

}
