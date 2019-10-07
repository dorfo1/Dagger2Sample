package rodolfo.com.br.daggermvvm.di.Modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import rodolfo.com.br.daggermvvm.di.Modules.auth.AuthModule
import rodolfo.com.br.daggermvvm.di.Modules.auth.AuthViewModelModule
import rodolfo.com.br.daggermvvm.di.Modules.main.MainFragmentBuildersModule
import rodolfo.com.br.daggermvvm.di.Modules.main.MainModule
import rodolfo.com.br.daggermvvm.di.Modules.main.MainViewModelModule
import rodolfo.com.br.daggermvvm.di.Scope.AuthScope
import rodolfo.com.br.daggermvvm.di.Scope.MainScope
import rodolfo.com.br.daggermvvm.ui.auth.AuthActivity
import rodolfo.com.br.daggermvvm.ui.main.MainActivity

@Module
abstract class ActivityBuildersModule {

    @MainScope
    @ContributesAndroidInjector(
        modules = [
            MainModule::class,
            MainViewModelModule::class,
            MainFragmentBuildersModule::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity

    @AuthScope
    @ContributesAndroidInjector(
        modules = [
            AuthModule::class,
            AuthViewModelModule::class
        ]
    )
    abstract fun contributeAuthActivity(): AuthActivity
}