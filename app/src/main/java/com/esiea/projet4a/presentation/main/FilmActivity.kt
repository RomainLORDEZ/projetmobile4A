package com.esiea.projet4a.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.esiea.projet4a.R
import kotlinx.android.synthetic.main.activity_film.*

class FilmActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film)

        toolbar.setTitle("tous les films")
        setSupportActionBar(toolbar)
    }
}