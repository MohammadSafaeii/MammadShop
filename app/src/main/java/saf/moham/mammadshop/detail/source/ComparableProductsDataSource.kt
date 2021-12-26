package saf.moham.mammadshop.detail.source

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.ComparableProductData

interface ComparableProductsDataSource {
    fun getComparableProducts (kind:String): Single<List<ComparableProductData>>
}