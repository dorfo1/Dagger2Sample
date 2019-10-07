package rodolfo.com.br.daggermvvm.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.HttpException
import rodolfo.com.br.daggermvvm.SessionManager
import rodolfo.com.br.daggermvvm.api.UserAPI
import rodolfo.com.br.daggermvvm.model.User
import java.lang.Exception
import javax.inject.Inject

class AuthViewModel @Inject constructor(val sessionManager: SessionManager, val userAPI: UserAPI) :
    ViewModel() {

    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)


    fun loginWithId(id: Int) {
        sessionManager.autenticar(fetchUserId(id))
    }


    private fun fetchUserId(id: Int): LiveData<AuthResouce<User>> {
        var source = MutableLiveData<AuthResouce<User>>()
        uiScope.launch {
            try {
                var userById = userAPI.getUserById(id)
                source.value = AuthResouce.Authenticated(userById)
            } catch (error: Exception) {
                source.value = AuthResouce.Error(null, error.message.toString())
            }
        }
        return source
    }

    fun getAuthResource(): LiveData<AuthResouce<User>> {
        return sessionManager.getCachedUser()
    }


    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}