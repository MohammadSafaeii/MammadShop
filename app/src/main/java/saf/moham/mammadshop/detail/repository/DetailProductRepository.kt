package saf.moham.mammadshop.detail.repository

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.DetailProduct

interface DetailProductRepository {
    fun getDetailProduct(id:String,user:String): Single<List<DetailProduct>>
}