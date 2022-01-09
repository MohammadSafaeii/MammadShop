package saf.moham.mammadshop.shop.source

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.BasketItemCount
import saf.moham.mammadshop.data.Message
import saf.moham.mammadshop.data.ShopResponse

interface ShopDataSource {
    fun getItems(): Single<ShopResponse>
    fun changeItemCount(id: String, count: Int): Single<Message>
    fun addItemToBasket(id: String): Single<Message>
    fun removeItemFromBasket(id: String): Single<Message>
    fun getBasketItemCount(): Single<BasketItemCount>
}