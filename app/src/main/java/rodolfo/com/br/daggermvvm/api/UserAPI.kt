package rodolfo.com.br.daggermvvm.api

import retrofit2.http.GET
import retrofit2.http.Path
import rodolfo.com.br.daggermvvm.model.User

interface UserAPI {

    @GET("/users/{id}")
    suspend fun getUserById(@Path("id") id:Int) : User

}