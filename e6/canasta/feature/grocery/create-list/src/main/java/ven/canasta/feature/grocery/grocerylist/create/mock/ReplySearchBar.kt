package ven.canasta.feature.grocery.grocerylist.create.mock

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ven.canasta.core.designsystem.theme.CanastaTheme
import ven.canasta.feature.grocery.R

//
//
// @SuppressLint("DesignSystem")
// @OptIn(ExperimentalMaterial3Api::class)
// @Composable
// fun ReplySearchBar(modifier: Modifier = Modifier) {
//     var text by remember { mutableStateOf("Titulo") }
//
//     Row(
//         modifier = modifier
//             .fillMaxWidth()
//             .padding(top = 24.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
//             .background(MaterialTheme.colorScheme.surface, CircleShape),
//         verticalAlignment = Alignment.CenterVertically
//     ) {
//         Icon(
//             imageVector = Icons.Default.Search,
//             contentDescription = "icon", // stringResource(id = R.string.search),
//             modifier = Modifier.padding(start = 16.dp),
//             tint = MaterialTheme.colorScheme.outline
//         )
//         OutlinedTextField(
//             value = text,
//             modifier = Modifier
//                 //.border(0.dp, Color.White)
//                 //.background(Color.Transparent)
//                 .clip(RoundedCornerShape(12.dp)),
//             onValueChange = { text = it },
//             colors = TextFieldDefaults.textFieldColors(
//                 containerColor = Color.Transparent,
//             ),
//             label = { },
//
//         )
//         // Text(
//         //     text = "Search replies", // stringResource(id = R.string.search_replies),
//         //     modifier = Modifier
//         //         .weight(1f)
//         //         .padding(16.dp),
//         //     style = MaterialTheme.typography.bodyMedium,
//         //     color = MaterialTheme.colorScheme.outline
//         // )
//         ReplyProfileImage(
//             drawableResource = R.drawable.canasta3, // avatar_6,
//             description = "avatar", /// stringResource(id = R.string.profile),
//             modifier = Modifier
//                 .padding(12.dp)
//                 .size(32.dp)
//         )
//     }
// }
//
// @Composable
// }
//
// @Composable
// fun ReplyProfileImage(
//     drawableResource: Int,
//     description: String,
//     modifier: Modifier = Modifier
// ) {
//     Image(
//         modifier = modifier
//             .size(40.dp)
//             .clip(CircleShape),
//         painter = painterResource(id = drawableResource),
//         contentDescription = description,
//     )
// }
//
//
// @Preview(name="reply-search-bar", showBackground = true)
// @Composable
// fun ReplySearchBarPreview() {
//
//     CanastaTheme() {
//
//         Surface(Modifier.fillMaxWidth()) {
//             ReplySearchBar()
//         }
//     }
// }