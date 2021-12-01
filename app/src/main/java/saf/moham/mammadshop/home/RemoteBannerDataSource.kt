package saf.moham.mammadshop.home

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.Banner
import saf.moham.mammadshop.retrofit.ApiService

class RemoteBannerDataSource(private val apiService: ApiService):BannerDataSource {
    override fun getBanners(): Single<List<Banner>> = apiService.getBanners()
}