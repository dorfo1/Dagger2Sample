package rodolfo.com.br.daggermvvm.di.Modules

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import rodolfo.com.br.daggermvvm.utils.ViewModelFactory

@Module
abstract class ViewModelFactoryModule {

//    @Binds
//    @IntoMap
//    @ViewModelKey(MainViewModel::class)
//    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(AuthViewModel::class)
//    abstract fun bindAuthViewModel(authViewModel: AuthViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}