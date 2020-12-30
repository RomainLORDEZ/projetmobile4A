package com.esiea.projet4a.data.Retrofit

import com.esiea.projet4a.data.Model.Netflixou
import retrofit2.http.GET
import java.util.*

interface IFilmList {
    @get:GET("database.json")
    val listfilm:Observable<Netflixou>
}