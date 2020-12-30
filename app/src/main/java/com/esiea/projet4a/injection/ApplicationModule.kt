package com.esiea.projet4a.injection

import android.content.Context
import androidx.room.Room
import com.esiea.projet4a.MainViewModel
import com.esiea.projet4a.data.Retrofit.FilmApi
import com.esiea.projet4a.data.local.AppDatabase
import com.esiea.projet4a.data.local.DatabaseDao
import com.esiea.projet4a.data.repository.UserRepository
import com.esiea.projet4a.domain.UseCase.CreateUserUseCase
import com.esiea.projet4a.domain.UseCase.GetUserUseCase
import com.esiea.projet4a.presentation.film.FilmViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val presentationModule = module  {
    factory { MainViewModel(get(),get()) }
    factory { FilmViewModel(get()) }
}

val domainModule= module {
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
}

val dataModule = module {
    single {  UserRepository(get()) }
    single { createDataBase(androidContext())}
    single { createApiRest() }
}

fun createApiRest() : FilmApi {
    val builder = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/RomainLORDEZ/projetmobile4A/master/")
        .addConverterFactory((GsonConverterFactory.create()))
        .build()

    return builder.create(FilmApi::class.java)
}

fun createDataBase(context: Context): DatabaseDao {

    val appDatabaseDao :AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDatabaseDao.databaseDao()



}
