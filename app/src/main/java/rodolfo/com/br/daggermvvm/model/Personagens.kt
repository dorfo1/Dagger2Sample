package rodolfo.com.br.daggermvvm.model

data class Personagem(
    val id:Int,
    val name:String,
    val image:String
)


data class PersonagensResponse(
    val results : List<Personagem>
)