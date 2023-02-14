package ven.canasta.feature.grocery.inbox

import androidx.lifecycle.ViewModel
import ven.canasta.grocerylist.dummyGroceryLists

class GroceryListsViewModel(): ViewModel(), GroceryListsVM {

   override fun getGroceryLists() = dummyGroceryLists

}
