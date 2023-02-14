package ven.canasta.grocerylist

data class StoreLogo(
    val url: String
) {
    companion object {
        val COTO: StoreLogo = StoreLogo( "" )
        val DIA: StoreLogo = StoreLogo( "" )
        val VEA: StoreLogo = StoreLogo( "" )
        val CARREFOUR: StoreLogo = StoreLogo( "" )
    }
}
