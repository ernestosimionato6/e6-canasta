package ven.canasta.grocerylist

data class GroceryBackground(
    val resource: BackgroundResource?,
    val imageLink: String?
) {

    constructor(resource: BackgroundResource) : this( resource, null )

    companion object {
        val EMPTY: GroceryBackground = GroceryBackground(
                resource = BackgroundResource.CLEAN
        )
        val GROCERY_01: GroceryBackground = GroceryBackground(
                resource = BackgroundResource.GROCERY_01
        )
    }
}

enum class BackgroundResource {
    CLEAN,
    GROCERY_01,
    GROCERY_02,
    GROCERY_03,
    GROCERY_04,
}
