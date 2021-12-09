package saf.moham.mammadshop.home.source

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.Banner
import saf.moham.mammadshop.home.source.BannerDataSource
import saf.moham.mammadshop.retrofit.ApiService

class LocalBannerDataSource(private val apiService: ApiService): BannerDataSource {
    override fun getBanners(): Single<List<Banner>> = apiService.getBanners()
}