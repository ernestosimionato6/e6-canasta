package ven.canasta.grocerylist

data class GroceryItem(
    val storeItem: StoreItem,
    val product: Product,
    val productName: String,
    val productImage: ProductImage?,
    var quantity: Quantity = Quantity(1),
    var hasDiscount: Boolean = false,
    var discountType: DiscountType = DiscountType.None,
    val unavailable: Boolean = false,
    val pocasUd: Boolean = false,
    val precioJusto: Boolean = false,
) {


    fun itHasADiscount(): Boolean {
        return hasDiscount;
    }

    constructor(
        storeItem: StoreItem,
        quantity: Int = 1,
        hasDiscount: Boolean = false,
        discountType: DiscountType = DiscountType.None,
        unavailable: Boolean = false,
        pocasUd: Boolean = false,
        precioJusto: Boolean = false,

    ) : this(
            storeItem,
            storeItem.product,
            storeItem.product.name,
            storeItem.product.image,
            Quantity(quantity),
            hasDiscount,
            discountType,
            unavailable,
            pocasUd,
            precioJusto = precioJusto
    )


}
