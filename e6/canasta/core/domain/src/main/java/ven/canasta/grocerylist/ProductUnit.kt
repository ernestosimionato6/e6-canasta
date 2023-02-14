package ven.canasta.grocerylist

data class ProductUnit(
    val unit: MeasurementUnit,
    val value: Float = 0.0F // unit multiplier
) {

}
