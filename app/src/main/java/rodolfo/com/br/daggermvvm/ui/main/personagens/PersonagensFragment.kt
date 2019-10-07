package rodolfo.com.br.daggermvvm.ui.main.personagens


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.activity_auth.*
import kotlinx.android.synthetic.main.fragment_personagens.*

import rodolfo.com.br.daggermvvm.R
import rodolfo.com.br.daggermvvm.model.Personagem
import rodolfo.com.br.daggermvvm.utils.Resource
import rodolfo.com.br.daggermvvm.utils.ViewModelFactory
import javax.inject.Inject


class PersonagensFragment : DaggerFragment() {

    @Inject
    lateinit var provider: ViewModelFactory
    @Inject
    lateinit var adapter: PersonagensAdapter

    private lateinit var personagensViewModel: PersonagensViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_personagens, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvPersonagens.layoutManager = LinearLayoutManager(context)
        rvPersonagens.adapter = adapter

        personagensViewModel = ViewModelProviders.of(this, provider).get(PersonagensViewModel::class.java)
        setupObservers()
        adapter.limparLista()
        personagensViewModel.fetchPersonagens()
    }

    private fun setupObservers() {
        personagensViewModel.personagemSource.removeObservers(viewLifecycleOwner)
        personagensViewModel.personagemSource.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> populaLista(it.data)
                is Resource.Loading -> showProgressBar()
                is Resource.Error -> showErrorMsg(it.msg)
            }
        })

    }

    private fun showErrorMsg(msg: String?) {
        msgErroPersonagem.visibility = View.VISIBLE
        msg?.let {
            msgErroPersonagem.text = it
        }
        pb.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        msgErroPersonagem.visibility = View.INVISIBLE
        pb.visibility = View.VISIBLE
    }

    private fun populaLista(data: List<Personagem>?) {
        adapter.addPersonagens(data)
        pb.visibility = View.INVISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()

    }




}
