package saf.moham.mammadshop.home.source

import saf.moham.mammadshop.retrofit.ApiService

class RemoteBannerDataSource(private val apiService: ApiService): BannerDataSource {
    override fun getBanners() = apiService.getBanners()
}