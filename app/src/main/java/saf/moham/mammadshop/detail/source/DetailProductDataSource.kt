package saf.moham.mammadshop.detail.source

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.DetailProduct
import saf.moham.mammadshop.data.Message

interface DetailProductDataSource {
    fun getDetailProduct(id:String,user:String): Single<List<DetailProduct>>
    fun addToBasket(id: String): Single<Message>
}