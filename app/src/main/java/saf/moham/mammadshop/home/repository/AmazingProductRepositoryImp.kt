package saf.moham.mammadshop.home.repository

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.AmazingProduct
import saf.moham.mammadshop.home.source.AmazingProductDataSource

class AmazingProductRepositoryImp(val amazingProductDataSource: AmazingProductDataSource):AmazingProductRepository {
    override fun getAmazingProduct() = amazingProductDataSource.getAmazingProduct()
}