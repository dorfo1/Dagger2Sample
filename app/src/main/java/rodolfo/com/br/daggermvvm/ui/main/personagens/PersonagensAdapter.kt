package rodolfo.com.br.daggermvvm.ui.main.personagens

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.row_personagem.view.*
import rodolfo.com.br.daggermvvm.R
import rodolfo.com.br.daggermvvm.model.Personagem

class PersonagensAdapter (val personagens:MutableList<Personagem>) : RecyclerView.Adapter<PersonagensAdapter.PersonagemHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonagemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_personagem,parent,false)
        return PersonagemHolder(view)
    }

    override fun getItemCount(): Int {
       return personagens.size
    }

    override fun onBindViewHolder(holder: PersonagemHolder, position: Int) {
        val personagem = personagens[position]
        Glide.with(holder.itemView).load(personagem.image).into(holder.itemView.ivPersonagem)
        holder.itemView.tvPersonagem.text = personagem.name
    }

    fun addPersonagens(data: List<Personagem>?) {
        personagens.clear()
        data?.let {
            personagens.addAll(it)
        }
        notifyDataSetChanged()
    }

    fun limparLista() {
        personagens.clear()
        notifyDataSetChanged()
    }


    class PersonagemHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}