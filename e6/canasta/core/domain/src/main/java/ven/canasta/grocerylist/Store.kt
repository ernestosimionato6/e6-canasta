/*
 * Copyright 2023 The Android Open Source Project
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package ven.canasta.grocerylist

data class Store(
    val id: StoreId,
    val name: StoreName,
    val logo: StoreLogo
) {
    companion object {
        val COTO: Store = Store(
            id = StoreId("coto123"),
            name = StoreName("Coto"),
            logo = StoreLogo.COTO
        )
        val DIA: Store = Store(
            id = StoreId("dia123"),
            name = StoreName("DIA"),
            logo = StoreLogo.DIA
        )
        val Carrefour: Store = Store(
            id = StoreId("carrefour123"),
            name = StoreName("Carrefour"),
            logo = StoreLogo.CARREFOUR
        )
        val VEA: Store = Store(
            id = StoreId("vea123"),
            name = StoreName("Vea"),
            logo = StoreLogo.VEA
        )
        val JUMBO: Store = Store(
            id = StoreId("jumbo123"),
            name = StoreName("Jumbo"),
            logo = StoreLogo.VEA
        )
    }
}
