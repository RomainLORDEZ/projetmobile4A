package com.esiea.projet4a.data.Retrofit

import com.esiea.projet4a.data.Model.Netflixou
import io.reactivex.Observable
import retrofit2.http.GET

interface IFilmList {
    @get:GET("database.json")
    val listfilm: Observable<Netflixou>
}