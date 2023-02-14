package ven.canasta.feature.grocery.inbox.mock.inbox

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Magenta
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ven.canasta.core.designsystem.theme.enia
import ven.canasta.core.designsystem.theme.eniaBold
import ven.canasta.core.ui.mock.Black60
import ven.canasta.core.ui.mock.Black80
import ven.canasta.core.ui.mock.Gray40
import ven.canasta.core.ui.mock.Green60
import ven.canasta.core.ui.mock.Orange60
import ven.canasta.core.ui.mock.Orange70
import ven.canasta.feature.grocery.inbox.GroceryListsVM
import ven.canasta.feature.grocery.inbox.R
import ven.canasta.grocerylist.DiscountType
import ven.canasta.grocerylist.GroceryItem
import ven.canasta.grocerylist.GroceryList
import ven.canasta.grocerylist.Store
import ven.canasta.grocerylist.User
import ven.canasta.grocerylist.dummyGroceryLists

@Composable
fun InboxContent(
    viewModel: GroceryListsVM
) {

    var groceryLists by rememberSaveable { mutableStateOf(viewModel.getGroceryLists()) }

    val isEmpty by remember { mutableStateOf(viewModel.getGroceryLists().isEmpty()) }

    if(isEmpty)
        EmptyInbox()
    else
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(
                    rememberScrollState()
                ),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,

        ) {
            groceryLists.forEach {  GroListOverview(it) }
        }
}

@Composable
fun GroListOverview(groceryList: GroceryList) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(380.dp)
                .border(1.dp, Gray40)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .background(Color.Transparent)
                        .padding(bottom = 12.dp)
                ) {
                    UserAvatarView(groceryList.owner)
                    val username : String = if (groceryList.owner.me)
                        "@${groceryList.owner.username} (You)"
                    else
                        "@${groceryList.owner.username}"

                    Column(
                        modifier = Modifier.padding(start = 8.dp)
                    ) {
                        Text(groceryList.name, color = Black80, fontFamily = eniaBold)
                        Text(
                            username,
                            color = Black60,
                            fontSize = 16.sp,
                            fontFamily = eniaBold
                        )
                    }
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState())
                        .background(Color.Transparent),
                    horizontalArrangement = Arrangement.Start,
                ) {
                    groceryList.items.forEach { GroItemComponent(it) }
                    if(groceryList.items.size > 6) {
                        MoreGroceryItem(
                            Modifier
                                .fillMaxHeight()
                                .width(120.dp)
                                // .weight(0.30f, true)
                                .padding(16.dp))
                    }
                }
            }
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    Modifier
                        .height(52.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    StoreImageView(groceryList.store)

                    Box(
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .background(color = Gray40)
                            .height(52.dp)
                            .width(380.dp)
                            .align(Alignment.CenterVertically),
                        contentAlignment = Alignment.Center

                    ) {
                        Text(
                            "Ver todos ${groceryList.items.size} articulos",
                            color = Black80,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Medium,
                            fontFamily = eniaBold, // Eina1Family,
                        )
                    }
                }
            }
        }
//    }
}

@Composable
fun UserAvatarView(user: User) {
    var resource  = painterResource(R.drawable.avatar1)
    when(user.username) {
//        "estelita" -> resource = painterResource(R.drawable.mama)
//        "ernesto" -> resource = painterResource(R.drawable.papa)
    }
    Image(
        painter = resource,
        contentDescription = "Owner",
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape)
            .border(2.dp, Companion.Gray, CircleShape)
    )
}

@Composable
fun StoreImageView(store: Store) {
    var resource  = painterResource(R.drawable.store2)
    when(store.id.id) {
        "coto123" -> resource = painterResource(R.drawable.coto123)
        "dia123" -> resource = painterResource(R.drawable.dia123)
        "carrefour123" -> resource = painterResource(R.drawable.carrefour123)
        "jumbo123" -> resource = painterResource(R.drawable.jumbo123)
        "vea123" -> resource = painterResource(R.drawable.vea123)
    }

    Image(
        painter = resource,
        contentDescription = "Owner",
        modifier = Modifier
            //.padding(4.dp)
            .size(48.dp)
            .clip(CircleShape)
            // .border(2.dp, Gray120, CircleShape)
            .background(Companion.White.copy(alpha = 0.95F)) // Companion.Transparent)
    )
}

@Composable
fun GroItemComponent(
    item: GroceryItem,
    modifier : Modifier = Modifier
) {
    var containerModifier = Modifier
        .padding(end = 4.dp)
        .width(135.dp)
        .height(280.dp)
        .then(modifier)


    Box(
        modifier = containerModifier
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(135.dp),
                // .border(0.1.dp, Companion.Black),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Image(
                    painter = painterResource(R.drawable.chetos1),
                    contentDescription = "product-image",
                    modifier = Modifier
                        .size(125.dp)
                        .padding(4.dp),
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(36.dp)
            ) {
                var bgColor: Color =  Color.Transparent
                if (item.hasDiscount) bgColor = Color(255, 220, 35, 255)

                Row(
                    modifier = Modifier
                        .background(bgColor)
                        .padding(top = 2.dp, bottom = 8.dp, end = 4.dp, start = 4.dp),

                    verticalAlignment = Alignment.Top

                ) {
                    Text( "$", color = Black80, fontSize = 12.sp, fontFamily = eniaBold)
                    Text("1.350", color = Black80, fontSize = 22.sp, fontFamily = eniaBold)
                    Text("00", color = Black80, fontSize = 12.sp, fontFamily = eniaBold)
                }
//                Row(
//                    modifier = Modifier
//                        .fillMaxHeight()
//                        .padding(vertical = 0.dp, horizontal = 4.dp),
//                    verticalAlignment = Alignment.Bottom
//                ) {
//                    Text(
//                        "$4.09",
//                        fontSize = 16.sp,
//                        style = TextStyle(textDecoration = TextDecoration.LineThrough),
//                        modifier = Modifier
//                            .align(Alignment.Bottom)
//                    )
//                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
                    .height(120.dp)
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {

                    if (item.unavailable) {
                        Row(
                            modifier = Modifier
                                .padding(vertical = 0.dp, horizontal = 0.dp),
                            verticalAlignment = Alignment.Bottom
                        ) {
                            Text(
                                "Sin stock",
                                fontSize = 14.sp,
                                color = Black60,
                                fontFamily = eniaBold,
                                modifier = Modifier
                                    .background(Gray40)
                                    .padding(horizontal = 22.dp)
                                    .align(Alignment.Bottom)
                            )
                        }
                    }

                    if (item.pocasUd) {
                        Row(
                            modifier = Modifier
                                .padding(vertical = 0.dp, horizontal = 0.dp),
                            verticalAlignment = Alignment.Bottom
                        ) {
                            Image(
                                painter = painterResource(ven.canasta.core.designsystem.R.drawable.sin_ud2),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(20.dp)
                            )

                            Text(
                                "Pocas ud.",
                                fontSize = 14.sp,
                                color = Orange70,
                                fontFamily = eniaBold,
                                modifier = Modifier
                                    .align(Alignment.Bottom)
                            )
                        }
                    }

                    if (item.hasDiscount) {
                        Row(
                            modifier = Modifier
                                .padding(vertical = 0.dp, horizontal = 4.dp),
                            verticalAlignment = Alignment.Bottom
                        ) {
                            Text(
                                "$ 1.700,09",
                                fontSize = 14.sp,
                                style = TextStyle(textDecoration = TextDecoration.LineThrough),
                                fontFamily = enia,
                                modifier = Modifier
                                    .align(Alignment.Bottom)
                            )
                            if(DiscountType.Percent.equals(item.discountType)) {
                                Text(
                                    "-15%",
                                    fontSize = 14.sp,
                                    color = Blue.copy(alpha = 0.75f),
                                    fontFamily = eniaBold,
                                    modifier = Modifier
                                        .padding(start = 4.dp)
                                        .align(Alignment.Bottom)
                                )
                            }
                        }

                        if(DiscountType.TakeXPayY.equals(item.discountType)) {

                            Row(
                                modifier = Modifier
                                    .padding(vertical = 0.dp, horizontal = 4.dp),
                                verticalAlignment = Alignment.Bottom
                            ) {
                                Text(
                                    "Lleva 4 Paga 3",
                                    fontSize = 14.sp,
                                    color = Blue.copy(alpha = 0.75f),
                                    fontFamily = eniaBold,
                                    modifier = Modifier
                                        .align(Alignment.Bottom)
                                )
                            }
                        }
                        if(DiscountType.Take2Percent.equals(item.discountType)) {

                            Row(
                                modifier = Modifier
                                    .padding(vertical = 0.dp, horizontal = 4.dp),
                                verticalAlignment = Alignment.Bottom
                            ) {
                                Text(
                                    "-70% en la 2da",
                                    fontSize = 14.sp,
                                    color = Blue.copy(alpha = 0.75f),
                                    fontFamily = eniaBold,
                                    modifier = Modifier
                                        .align(Alignment.Bottom)
                                )
                            }
                        }
                    }

                    Text(
                        item.productName,
                        textAlign = TextAlign.Start,
                        fontFamily = enia, //Eina1Family,
                        maxLines = 5,
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()

                    )
                }
            }
        }

        if(item.precioJusto) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopStart)
            ) {
                Spacer(Modifier.height(100.dp))
                Image(
                    painter = painterResource(id = ven.canasta.core.designsystem.R.drawable.preciosjustos),
                    contentDescription = "Owner",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .padding(2.dp)
                        .height(26.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(White.copy(alpha = 0.90f))
                )
            }
        }

        if(item.unavailable) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    // .border(2.dp, Green60, CircleShape)
                    .background(White.copy(alpha = 0.65f))
                    .fillMaxSize()
            ) {
            }
        }


            if(item.unavailable) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .height(48.dp)
                        //.clip(CircleShape)
                        // .border(2.dp, Green60, CircleShape)
                        .clip(RoundedCornerShape(15.dp))
                        .background(Green60)
                ) {

                    Text(
                        "Ver similares",
                        color = Color.White,
                        fontSize = 14.sp,
                        fontFamily = eniaBold, // Eina1Family,
                        textAlign = TextAlign.Center,
                         maxLines = 2,
                         lineHeight = 15.sp,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(horizontal = 8.dp)

                    )
                }

            } else {

                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(Green60)
                ) {
                    Text(
                        "+",
                        color = Color.White,
                        fontSize = 28.sp,
                        fontFamily = eniaBold, // Eina1Family,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.TopCenter)

                    )
                }
            }
        }

    }






@Preview(name="inbox-content", showBackground=true)
@Composable
fun InboxContentPreview() {

    Surface(
        modifier = Modifier.fillMaxWidth()
    ) {
        InboxContent(
            viewModel = object : GroceryListsVM {
                override fun getGroceryLists(): List<GroceryList> {
                    return dummyGroceryLists
                }
            }
        )
    }
}

@Preview(name="inbox-grocery-list-overview", showBackground=true)
@Composable
fun GroceryListOverviewPreview() {

    Surface(
        modifier = Modifier.fillMaxWidth()
    ) {
       GroListOverview(
                   dummyGroceryLists.get(0)
       )
    }
}