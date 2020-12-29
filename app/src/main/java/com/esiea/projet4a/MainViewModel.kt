package com.esiea.projet4a

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esiea.projet4a.domain.UseCase.CreateUserUseCase
import com.esiea.projet4a.domain.UseCase.GetUserUseCase
import com.esiea.projet4a.presentation.main.LoginError
import com.esiea.projet4a.presentation.main.LoginStatus
import com.esiea.projet4a.presentation.main.LoginSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase

): ViewModel(){
    val loginLiveData : MutableLiveData<LoginStatus> = MutableLiveData()

    fun onClickedLogin(emailUser: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.invoke(emailUser)

            val loginStatus =if (user != null){
                LoginSuccess(user.email)
            }else{
                LoginError

            }
            withContext(Dispatchers.Main){
                loginLiveData.value = loginStatus
            }




        }
    }

}

// val user = getUserUseCase.invoke("test")
/*user?.let {

}
  init {
        counter.value = 0
    }

val toto = "debug"*/