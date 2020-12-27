package com.esiea.projet4a.injection

import com.esiea.projet4a.MainViewModel
import org.koin.dsl.module

val presentaionModule = module  {
    factory { MainViewModel() }

}