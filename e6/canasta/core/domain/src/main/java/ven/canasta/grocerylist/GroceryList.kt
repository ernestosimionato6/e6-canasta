package ven.canasta.grocerylist

import ven.canasta.grocerylist.DiscountType.None
import ven.canasta.grocerylist.DiscountType.Percent
import ven.canasta.grocerylist.DiscountType.Take2Percent
import ven.canasta.grocerylist.DiscountType.TakeXPayY

data class GroceryList(
    val owner: User,
    val name: String,
    val store: Store,
    val background: GroceryBackground? = GroceryBackground.EMPTY,
    val items: List<GroceryItem> = listOf<GroceryItem>(),
    val id: GroceryListId?
) {

    fun total(): Amount {
        val sum: Double = items.stream().map{it ->  (it.quantity.amount * it.storeItem.price.amount)}
            .reduce(0.0) {tot, next -> tot + next }
        return Amount(sum)
    }
}



val dummyGroceryLists = listOf(
    GroceryList(
        User.estelita,
        "Compra en dia sabado",
        Store.COTO,
        GroceryBackground.GROCERY_01,
        listOf<GroceryItem>(
            GroceryItem(
                StoreItem(
                    Store.DIA,
                    Product.MILK1,
                    Price(10.0), // Price.CERO,
                    StoreItemId("dia-leche1-1234")
                ),
                5,
                hasDiscount = true,
                discountType = Percent,
                precioJusto = true
            ),
            GroceryItem(
                StoreItem(
                    Store.DIA,
                    Product.MILK2,
                    Price(10.0), // Price.CERO,
                    StoreItemId("dia-leche1-1234")
                ),
                5,
                false,
                unavailable = true,
                precioJusto = true
            ),
            GroceryItem(
                StoreItem(
                    Store.DIA,
                    Product.MILK3,
                    Price(10.0), // Price.CERO,
                    StoreItemId("dia-leche1-1234")
                ),
                5,
                true,
                discountType = TakeXPayY,
                pocasUd = true,
            ),
                        GroceryItem(
                StoreItem(
                    Store.DIA,
                    Product.MILK1,
                    Price(10.0), // Price.CERO,
                    StoreItemId("dia-leche1-1234")
                ),
                5,
                hasDiscount = true,
                discountType = Percent,
                            pocasUd = true,
            ),
            GroceryItem(
                StoreItem(
                    Store.DIA,
                    Product.MILK2,
                    Price(10.0), // Price.CERO,
                    StoreItemId("dia-leche1-1234")
                ),
                5,
                false,
                unavailable = true
            ),
            GroceryItem(
                StoreItem(
                    Store.DIA,
                    Product.MILK3,
                    Price(10.0), // Price.CERO,
                    StoreItemId("dia-leche1-1234")
                ),
                5,
                true,
                discountType = TakeXPayY


            ),
            GroceryItem(
                StoreItem(
                    Store.DIA,
                    Product.MILK1,
                    Price(10.0), // Price.CERO,
                    StoreItemId("dia-leche1-1234")
                ),
                5,
                hasDiscount = true,
                discountType = Percent,
                pocasUd = true,
            ),
            GroceryItem(
                StoreItem(
                    Store.DIA,
                    Product.MILK2,
                    Price(10.0), // Price.CERO,
                    StoreItemId("dia-leche1-1234")
                ),
                5,
                false,
                unavailable = true
            ),
            GroceryItem(
                StoreItem(
                    Store.DIA,
                    Product.MILK3,
                    Price(10.0), // Price.CERO,
                    StoreItemId("dia-leche1-1234")
                ),
                5,
                true,
                discountType = TakeXPayY
            )


        ),
        id = GroceryListId("list-123")
    ),

    GroceryList(
        User.estelita,
        "Compra en dia para el cumple",
        Store.DIA,
        GroceryBackground.GROCERY_01,
        listOf<GroceryItem>(
            GroceryItem(
                StoreItem(
                    Store.DIA,
                    Product.LECHE_SERENISIMA_1LT,
                    Price(10.0), // Price.CERO,
                    StoreItemId("dia-leche1-1234")
                ),
                5,
                true,
                discountType = Take2Percent,
                precioJusto = true
            )
        ),
        id = GroceryListId("list-987")
    ),

//    GroceryList(
//        User.papa,
//        "Compra en vea",
//        Store.VEA,
//        GroceryBackground.GROCERY_01,
//        listOf<GroceryItem>(
//            GroceryItem(
//                StoreItem(
//                    Store.VEA,
//                    Product.LECHE_SERENISIMA_1LT,
//                    Price(10.0), // Price.CERO,
//                    StoreItemId("dia-leche1-1234")
//                ),
//                5,
//                true
//            )
//        ),
//        id = GroceryListId("list-981")
//    ),
//
//
//
  GroceryList(
      User.doe,
      "Compra en carrefour",
      Store.Carrefour,
      GroceryBackground.GROCERY_01,
      listOf<GroceryItem>(
          GroceryItem(
              StoreItem(
                  Store.Carrefour,
                  Product.LECHE_SERENISIMA_1LT,
                  Price(10.0), // Price.CERO,
                  StoreItemId("dia-leche1-1234")
              ),
              5,
              false,
              unavailable = true
          )
      ),
      id = GroceryListId("list-982")
  ),



    GroceryList(
        User.doe,
        "Compra en jumbo",
        Store.JUMBO,
        GroceryBackground.GROCERY_01,
        listOf<GroceryItem>(
            GroceryItem(
                StoreItem(
                    Store.JUMBO,
                    Product.LECHE_SERENISIMA_1LT,
                    Price(10.0), // Price.CERO,
                    StoreItemId("dia-leche1-1234")
                ),
                5,
                true
            )
        ),
        id = GroceryListId("list-983")
    ),

    )