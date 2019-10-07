package rodolfo.com.br.daggermvvm.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.facebook.stetho.Stetho
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*
import rodolfo.com.br.daggermvvm.R
import rodolfo.com.br.daggermvvm.ui.main.MainActivity
import rodolfo.com.br.daggermvvm.utils.ViewModelFactory
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var provides : ViewModelFactory
    lateinit var authViewModel : AuthViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        Stetho.initializeWithDefaults(this)

        authViewModel = ViewModelProviders.of(this,provides).get(AuthViewModel::class.java)




        btnLogin.setOnClickListener {
            authViewModel.loginWithId(Integer.parseInt(etLogin.text.toString()))
        }

        setUpObserver()
    }

    private fun setUpObserver() {
        authViewModel.getAuthResource().observe(this, Observer {
            when(it){
                is AuthResouce.Authenticated -> usuarioAutenticado()
                is AuthResouce.Loading -> showProgressBar()
                is AuthResouce.Error -> showErrorMsg(it.message)
            }
        })
    }

    private fun usuarioAutenticado() {
        val intent = Intent(this@AuthActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun showErrorMsg(msg:String?) {
        progressBar.visibility = View.INVISIBLE
        msgErro.visibility = View.VISIBLE
        msgErro.text = msg
        btnLogin.visibility = View.VISIBLE
    }

    private fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
        msgErro.visibility = View.INVISIBLE
        btnLogin.visibility = View.INVISIBLE
    }
}
