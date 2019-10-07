package rodolfo.com.br.daggermvvm.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("name")
    val nome:String,
    val email:String
)