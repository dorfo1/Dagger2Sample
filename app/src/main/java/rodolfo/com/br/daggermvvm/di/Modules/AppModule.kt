package rodolfo.com.br.daggermvvm.di.Modules


import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import rodolfo.com.br.daggermvvm.SessionManager
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Singleton
    fun sessionManager() : SessionManager{
        return SessionManager()
    }


    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(StethoInterceptor()).build()
    }
}