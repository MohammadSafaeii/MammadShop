package saf.moham.mammadshop.detail.source

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.DetailProduct
import saf.moham.mammadshop.data.Message
import saf.moham.mammadshop.retrofit.ApiService

class RemoteDetailProductDataSource(val apiService: ApiService):DetailProductDataSource {
    override fun getDetailProduct(id: String, user: String)=apiService.getDetailProduct(id,user)
    override fun addToBasket(id: String) = apiService.addToBasket(id)
}