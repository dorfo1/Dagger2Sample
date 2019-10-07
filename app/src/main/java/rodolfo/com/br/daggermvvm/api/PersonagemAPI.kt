package rodolfo.com.br.daggermvvm.api

import retrofit2.http.GET
import rodolfo.com.br.daggermvvm.model.PersonagensResponse

interface PersonagemAPI {

    @GET("character")
    suspend fun getPersonagens() : PersonagensResponse
}