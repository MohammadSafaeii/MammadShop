package saf.moham.mammadshop.detail.source

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.DetailProduct

interface DetailProductDataSource {
    fun getDetailProduct(id:String,user:String): Single<List<DetailProduct>>
}