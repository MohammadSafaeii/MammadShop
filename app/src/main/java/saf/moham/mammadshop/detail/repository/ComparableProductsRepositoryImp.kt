package saf.moham.mammadshop.detail.repository

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.ComparableProductData
import saf.moham.mammadshop.detail.source.ComparableProductsDataSource
import saf.moham.mammadshop.detail.source.RemoteComparableProductsDataSource

class ComparableProductsRepositoryImp(val remoteComparableProductsDataSource: ComparableProductsDataSource):ComparableProductsRepository {
    override fun getComparableProducts(kind: String) = remoteComparableProductsDataSource.getComparableProducts(kind)
}