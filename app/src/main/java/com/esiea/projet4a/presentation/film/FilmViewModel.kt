package com.esiea.projet4a.presentation.film

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esiea.projet4a.data.Model.Movy
import com.esiea.projet4a.data.Retrofit.FilmApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FilmViewModel(
    private val filmApi: FilmApi
): ViewModel(){
    val listFilmLiveData : MutableLiveData<List<Movy>> = MutableLiveData()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val result = filmApi.getFilms()
            if(result.isSuccessful){
                withContext(Dispatchers.Main){
                    listFilmLiveData.value = result.body()?.movies
                }
            }
        }
    }
}