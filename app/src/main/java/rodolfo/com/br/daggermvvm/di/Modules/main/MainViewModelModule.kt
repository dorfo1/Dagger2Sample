package rodolfo.com.br.daggermvvm.di.Modules.main

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import rodolfo.com.br.daggermvvm.di.Key.ViewModelKey
import rodolfo.com.br.daggermvvm.ui.main.personagens.PersonagensViewModel

@Module
abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PersonagensViewModel::class)
    abstract fun bindMainViewModel(personagensViewModel: PersonagensViewModel) : ViewModel

}