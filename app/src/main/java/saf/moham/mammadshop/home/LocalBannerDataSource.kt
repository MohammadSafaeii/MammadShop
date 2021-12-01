package saf.moham.mammadshop.home

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.Banner

class LocalBannerDataSource:BannerDataSource {
    override fun getBanners(): Single<List<Banner>> {
        TODO("Not yet implemented")
    }
}