package rodolfo.com.br.daggermvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import rodolfo.com.br.daggermvvm.model.User
import rodolfo.com.br.daggermvvm.ui.auth.AuthResouce
import javax.inject.Singleton

@Singleton
class SessionManager {

    private val usuarioNoCache : MediatorLiveData<AuthResouce<User>> = MediatorLiveData()

    fun autenticar(resouce: LiveData<AuthResouce<User>>?){
        resouce?.let {source->
            usuarioNoCache.value = AuthResouce.Loading()
            usuarioNoCache.addSource(resouce){authResource ->
                usuarioNoCache.value = authResource
                usuarioNoCache.removeSource(resouce)
            }
        }
    }

    fun logOut(){
        usuarioNoCache.value = AuthResouce.NotAuthenticated()
    }

    fun getCachedUser():LiveData<AuthResouce<User>>{
        return usuarioNoCache
    }

}