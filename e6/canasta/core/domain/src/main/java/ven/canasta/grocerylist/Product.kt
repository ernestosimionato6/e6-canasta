package ven.canasta.grocerylist

import ven.canasta.grocerylist.MeasurementUnit.UNIT

data class Product(
   val name: String,
   val image: ProductImage? = ProductImage.EMPTY,
   val productUnit: ProductUnit = ProductUnit(UNIT, 0F),
   val sku: Sku? = Sku.EMPTY,
) {
    companion object {
        val LECHE_SERENISIMA_1LT: Product = Product(
            "Leche la serenisima 1 lt",
            ProductImage(
                "http://"
            )

        )
        val CHETOS: Product = Product(
            "Chicken of the Sea Salmon, Pink, Chunk Style, Skinless Bneless",
            ProductImage(
                "http://"
            )
        )

        val MILK1: Product = Product(
            "Kirkland Signature 2% Lowfat Milk, 1 Gal",
            ProductImage(
                "http://",
                "milk1"
            ),
            ProductUnit( MeasurementUnit.GAL, 1f) // measurementUnit
        )
        val MILK2: Product = Product(
            "Lactaid 2% Reduced Fat Milk, 96 fl oz",
            ProductImage(
                "http://",
                "milk2"
            ),
            ProductUnit( MeasurementUnit.OZ, 96f) // measurementUnit
        )
        val MILK3: Product = Product(
            "Lactaid Lactose Free, Fat Free Milk, 96 oz",
            ProductImage(
                "http://",
                "milk3"
            ),
            ProductUnit( MeasurementUnit.OZ, 96f) // measurementUnit
        )
    }
}
