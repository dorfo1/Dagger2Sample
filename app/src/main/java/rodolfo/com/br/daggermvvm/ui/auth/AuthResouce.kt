package rodolfo.com.br.daggermvvm.ui.auth

sealed class AuthResouce <T>(
    val data: T? = null,
    val message:String? = null
){
    class Authenticated<T>(data:T) : AuthResouce<T>(data)
    class Error<T>(data:T? = null,msg:String) : AuthResouce<T>(data,msg)
    class Loading<T>(data:T? = null) : AuthResouce<T>(data)
    class NotAuthenticated<T>(data:T? = null) : AuthResouce<T>(data)
}