package rodolfo.com.br.daggermvvm.ui.main.perfil


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_perfil.*

import rodolfo.com.br.daggermvvm.R
import rodolfo.com.br.daggermvvm.SessionManager
import javax.inject.Inject


class PerfilFragment : DaggerFragment() {


    @Inject
    lateinit var sessionManager: SessionManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfil, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val user = sessionManager.getCachedUser().value?.data


        user?.let {
            tvUser.text = "${it.nome}\n${it.email}"
        }


        btnLogout.setOnClickListener {
            sessionManager.logOut()
        }
    }

}
