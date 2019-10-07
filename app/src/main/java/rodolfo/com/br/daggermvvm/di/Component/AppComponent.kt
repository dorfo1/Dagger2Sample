package rodolfo.com.br.daggermvvm.di.Component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import rodolfo.com.br.daggermvvm.BaseApplication
import rodolfo.com.br.daggermvvm.di.Modules.ActivityBuildersModule
import rodolfo.com.br.daggermvvm.di.Modules.AppModule
import rodolfo.com.br.daggermvvm.di.Modules.ViewModelFactoryModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuildersModule::class,
        AppModule::class,
        ViewModelFactoryModule::class
    ]

)
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application: Application) : Builder

        fun build(): AppComponent
    }

}