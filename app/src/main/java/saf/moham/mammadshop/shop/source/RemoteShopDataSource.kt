package saf.moham.mammadshop.shop.source

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.Message
import saf.moham.mammadshop.data.ShopResponse
import saf.moham.mammadshop.retrofit.ApiService

class RemoteShopDataSource(val apiService: ApiService): ShopDataSource {
    override fun getItems() = apiService.getBasketList()
    override fun changeItemCount(id: String, count: Int) = apiService.changeItemCount(id, count)
    override fun addItemToBasket(id: String) = apiService.addToBasket(id)
    override fun removeItemFromBasket(id: String) = apiService.removeItemFromBasket(id)
}