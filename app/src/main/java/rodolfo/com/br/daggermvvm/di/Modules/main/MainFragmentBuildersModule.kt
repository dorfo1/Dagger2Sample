package rodolfo.com.br.daggermvvm.di.Modules.main

import dagger.Module
import dagger.android.ContributesAndroidInjector
import rodolfo.com.br.daggermvvm.ui.main.personagens.PersonagensFragment
import rodolfo.com.br.daggermvvm.ui.main.perfil.PerfilFragment


@Module
abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributePerfilFragment() : PerfilFragment


    @ContributesAndroidInjector
    abstract fun contributePersonagensFragment() : PersonagensFragment
}