package saf.moham.mammadshop.detail.repository

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.ComparableProductData

interface ComparableProductsRepository {
    fun getComparableProducts (kind:String): Single<List<ComparableProductData>>
}