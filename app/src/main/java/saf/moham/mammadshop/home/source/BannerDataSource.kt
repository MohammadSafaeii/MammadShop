package saf.moham.mammadshop.home.source

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.Banner

interface BannerDataSource {
    fun getBanners(): Single<List<Banner>>
}