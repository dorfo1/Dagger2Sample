package rodolfo.com.br.daggermvvm.di.Modules.auth

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import rodolfo.com.br.daggermvvm.api.UserAPI
import rodolfo.com.br.daggermvvm.di.Scope.AuthScope


@Module
class AuthModule {


    @AuthScope
    @Provides
    fun provideRetrofitBuilder(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @AuthScope
    @Provides
    fun provideUserAPI(retrofit: Retrofit):UserAPI{
        return retrofit.create(UserAPI::class.java)
    }

}