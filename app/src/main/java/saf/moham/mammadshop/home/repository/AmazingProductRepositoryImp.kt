package saf.moham.mammadshop.home.repository

import saf.moham.mammadshop.home.source.AmazingProductDataSource

class AmazingProductRepositoryImp(val remoteAmazingProductDataSource: AmazingProductDataSource):AmazingProductRepository {
    override fun getAmazingProduct() = remoteAmazingProductDataSource.getAmazingProduct()
}
