package saf.moham.mammadshop.shop.repository

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.BasketItemCount
import saf.moham.mammadshop.data.Message
import saf.moham.mammadshop.data.ShopResponse
import saf.moham.mammadshop.shop.source.ShopDataSource

class ShopRepositoryImp(val shopDataSource: ShopDataSource): ShopRepository {
    override fun getItems() = shopDataSource.getItems()
    override fun changeItemCount(id: String, count: Int) = shopDataSource.changeItemCount(id, count)
    override fun addItemToBasket(id: String) = shopDataSource.addItemToBasket(id)
    override fun removeItemFromBasket(id: String) = shopDataSource.removeItemFromBasket(id)
    override fun getBasketItemCount() = shopDataSource.getBasketItemCount()
}