package saf.moham.mammadshop.home.source

import saf.moham.mammadshop.retrofit.ApiService

class RemoteAmazingProductDataSource(val apiService: ApiService):AmazingProductDataSource {
    override fun getAmazingProduct() = apiService.getAmazingProducts()
}