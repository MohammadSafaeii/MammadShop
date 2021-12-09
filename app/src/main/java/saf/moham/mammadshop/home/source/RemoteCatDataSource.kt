package saf.moham.mammadshop.home.source


import saf.moham.mammadshop.retrofit.ApiService

class RemoteCatDataSource(val apiService: ApiService):CatDataSource {
    override fun getCats()=apiService.getCats()
}