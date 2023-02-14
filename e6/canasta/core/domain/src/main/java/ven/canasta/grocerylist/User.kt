package ven.canasta.grocerylist

data class User(
    val username: String,
    val me: Boolean = false
) {
    companion object {
        val doe: User = User( "esimionato" )
        val estelita: User = User( "estelita" )
        val papa: User = User( "ernesto", me= true)
    }
}
