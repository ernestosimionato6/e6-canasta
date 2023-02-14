package ven.canasta.grocerylist

data class ProductImage(
    val url: String = "",
    val id: String = ""
) {
    companion object {
        val EMPTY: ProductImage? = ProductImage("")
    }
}