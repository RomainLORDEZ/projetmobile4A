package com.esiea.projet4a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.esiea.projet4a.presentation.main.FilmActivity
import com.esiea.projet4a.presentation.main.LoginError
import com.esiea.projet4a.presentation.main.LoginSuccess
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.loginLiveData.observe(this, Observer {
            when(it){
                is LoginSuccess ->{
                    val i = Intent(this, FilmActivity::class.java)
                    startActivity(i)
                }
                    LoginError ->{
                        MaterialAlertDialogBuilder(this)
                            .setTitle("Erreur")
                            .setMessage("Compte Inconnu")
                            .setPositiveButton("OK") { dialog, which ->
                                dialog.dismiss()
                            }
                            .show()

            }
            }
        })
        login_button.setOnClickListener{
            mainViewModel.onClickedLogin(login_edit.text.toString().trim(), password_edit.text.toString())
        }
        create_account_buttom.setOnClickListener{
            mainViewModel.onClickedCreateaccount(login_edit.text.toString().trim(), password_edit.text.toString())
            //alert creation compte
        }
    }
}