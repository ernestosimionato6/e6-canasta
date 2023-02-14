package ven.canasta.grocerylist

data class StoreItem (
    val store: Store,
    val product: Product,
    var price: Price = Price.CERO,
    val id: StoreItemId,
)
