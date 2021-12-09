package saf.moham.mammadshop.home.repository

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.Banner

interface BannerRepository {
    fun getBanners(): Single<List<Banner>>
}