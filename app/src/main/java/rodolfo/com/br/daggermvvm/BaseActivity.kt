package rodolfo.com.br.daggermvvm

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.lifecycle.Observer
import dagger.android.support.DaggerAppCompatActivity
import rodolfo.com.br.daggermvvm.ui.auth.AuthActivity
import rodolfo.com.br.daggermvvm.ui.auth.AuthResouce
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {


    @Inject
    lateinit var sessionManager: SessionManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observers()
    }


    fun observers() {
        sessionManager.getCachedUser().observe(this, Observer {
            println(it.message)
            when (it) {
                is AuthResouce.Authenticated -> Log.d("Ouvindo", "Autenticado")
                is AuthResouce.Loading -> Log.d("Ouvindo", "Loading")
                is AuthResouce.Error -> Log.d("Ouvindo", "Error")
                is AuthResouce.NotAuthenticated -> deslogarUsuario()
            }
        })
    }


    private fun deslogarUsuario() {
        Log.d("Ouvindo", "NotAuthenticated")
        val intent = Intent(this, AuthActivity::class.java)
        startActivity(intent)
        finish()
    }


}