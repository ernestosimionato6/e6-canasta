package ven.wishlist.core.domain.wishlist.model

data class Wishlist(
    var receiver: String,
    var wishes: List<String> = listOf(),
    var id: Int = -1
)