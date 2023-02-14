package com.google.samples.apps.niacatalog.demo

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.samples.apps.nowinandroid.core.designsystem.theme.NiaTheme

@Composable
fun VnList( items: List<String> ) {

    Column(
        modifier = Modifier.width(180.dp)
            .padding(horizontal = 2.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        for ( item in items ) {
            Text(item)
            Divider( color = Black)
        }
    }
}

@Preview(name= "vn-list", showBackground = true)
@Composable
fun VnListPreview() {

   NiaTheme() {

       Surface(modifier = Modifier.fillMaxSize()
           .padding(8.dp)
           .border(1.dp, Black)
           .padding(8.dp)
       ) {
           Column(horizontalAlignment = Alignment.CenterHorizontally) {
               Text("[ vn-list ]")
               val pasillos = listOf(
                   "Ofertas",
                   "Combos",
                   "Frutas y verduras",
                   "Bebidas sin alcohol",
                   "Lacteos",
                   "Carniceria",
                   "Almacen",
                   "Quesos y fiambres",
                   "Limpieza y hogar",
                   "Panaderia y reposteria",
                   "Galletitas y snacks",
                   "Bebidas con alcohol",
                   "Congelados",
                   "Comida preparada",
                   "Cuidado personal",
                   "Mascotas",
                   "Mundo bebe",
                   "Libreria y hogar",
                   "Ferreteria y jardin",
                   "Otros",
               )
               var columnA = ArrayList<String>();
               var columnB = ArrayList<String>();
               for (i in 0..pasillos.size-1 step 2) {
                   columnA.add(pasillos.get(i))
                   columnB.add(pasillos.get(i+1))
               }

               Row(
                   modifier = Modifier.fillMaxWidth(),
                   horizontalArrangement = Arrangement.Center,
                   verticalAlignment = Alignment.Top
               ) {
                   VnList( columnA )
                   VnList( columnB )
               }
           }
       }

   }
}