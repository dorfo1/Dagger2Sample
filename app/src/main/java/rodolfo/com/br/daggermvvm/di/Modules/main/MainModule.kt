package rodolfo.com.br.daggermvvm.di.Modules.main


import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import rodolfo.com.br.daggermvvm.api.PersonagemAPI
import rodolfo.com.br.daggermvvm.di.Scope.MainScope
import rodolfo.com.br.daggermvvm.model.Personagem
import rodolfo.com.br.daggermvvm.ui.main.personagens.PersonagensAdapter

@Module
class MainModule{

    @MainScope
    @Provides
    fun provideRetrofitBuilder(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @MainScope
    @Provides
    fun providePersonagemAPI(retrofit: Retrofit):PersonagemAPI{
        return retrofit.create(PersonagemAPI::class.java)
    }


    @MainScope
    @Provides
    fun provideListaPersonagens(): MutableList<Personagem> {
        val lista: MutableList<Personagem> = arrayListOf()
        return lista
    }

    @MainScope
    @Provides
    fun providePersonagemAdapter(mutableList: MutableList<Personagem>): PersonagensAdapter {
        return PersonagensAdapter(mutableList)
    }
}