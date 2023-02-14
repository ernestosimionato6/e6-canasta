package ven.canasta.grocerylist

data class Price(
    var amount: Double = 0.0
) {
    companion object {
        val CERO: Price = Price(0.0)
    }
}
