package com.esiea.projet4a.data.Retrofit

import com.esiea.projet4a.data.Model.Netflixou
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface FilmApi {
    @GET("database.json")
    suspend fun getFilms(): Response<Netflixou>
}