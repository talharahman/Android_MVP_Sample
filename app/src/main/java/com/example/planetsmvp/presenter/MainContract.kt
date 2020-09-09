package com.example.planetsmvp.presenter

import com.example.planetsmvp.model.Planet

interface MainContract {

    interface View {
        fun onSuccess(planetList: List<Planet?>?)
        fun onError(t: Throwable?)
    }

    interface Presenter {
        val planets: Unit
    }
}