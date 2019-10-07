package rodolfo.com.br.daggermvvm.ui.main.personagens

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import rodolfo.com.br.daggermvvm.api.PersonagemAPI
import rodolfo.com.br.daggermvvm.model.Personagem
import rodolfo.com.br.daggermvvm.ui.auth.AuthResouce
import rodolfo.com.br.daggermvvm.utils.Resource
import java.lang.Exception
import javax.inject.Inject

class PersonagensViewModel @Inject constructor(val personagemAPI: PersonagemAPI) : ViewModel() {


    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)

    var personagemSource = MutableLiveData<Resource<List<Personagem>>>()

    fun fetchPersonagens() {
        personagemSource.value = Resource.Loading()
        uiScope.launch {
            try {
                var response = personagemAPI.getPersonagens()
                personagemSource.value = Resource.Success(response.results)
            }catch (error : Exception){
                personagemSource.value = Resource.Error(null,error.message.toString())
            }
        }
    }
}