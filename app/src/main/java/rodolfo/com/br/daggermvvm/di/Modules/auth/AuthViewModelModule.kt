package rodolfo.com.br.daggermvvm.di.Modules.auth

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import rodolfo.com.br.daggermvvm.di.Key.ViewModelKey
import rodolfo.com.br.daggermvvm.ui.auth.AuthViewModel

@Module
abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(authViewModel: AuthViewModel): ViewModel
}