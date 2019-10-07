package rodolfo.com.br.daggermvvm

import android.app.Application
import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import rodolfo.com.br.daggermvvm.di.Component.DaggerAppComponent

class BaseApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
       return DaggerAppComponent.builder().application(this).build()
    }


}