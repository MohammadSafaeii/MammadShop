package saf.moham.mammadshop.detail.source

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.ComparableProductData
import saf.moham.mammadshop.retrofit.ApiService

class RemoteComparableProductsDataSource(val apiService: ApiService):ComparableProductsDataSource {
    override fun getComparableProducts(kind: String) = apiService.getComparableProducts(kind)
}