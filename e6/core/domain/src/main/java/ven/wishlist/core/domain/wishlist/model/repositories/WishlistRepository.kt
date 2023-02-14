package ven.wishlist.core.domain.wishlist.model.repositories

import kotlinx.coroutines.flow.Flow

interface WishlistRepository {

    fun saveWishlist(wishList: CachedWishlist)
    fun getWishlists(): Flow<List<CachedWishlist>>
    fun getWishlist(id: Int): Flow<CachedWishlist>
    fun saveWishlistItem(wishList: CachedWishlist)
}