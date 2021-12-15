package saf.moham.mammadshop.detail.repository

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.DetailProduct
import saf.moham.mammadshop.detail.source.DetailProductDataSource
import saf.moham.mammadshop.detail.source.RemoteDetailProductDataSource

class DetailProductRepositoryImp(val remoteDetailProductDataSource: DetailProductDataSource):DetailProductRepository {
    override fun getDetailProduct(id: String, user: String) = remoteDetailProductDataSource.getDetailProduct(id,user)
}