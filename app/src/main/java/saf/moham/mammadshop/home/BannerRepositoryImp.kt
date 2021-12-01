package saf.moham.mammadshop.home

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.Banner

class BannerRepositoryImp(
    val localBannerDataSource: BannerDataSource,
    private val remoteBannerDataSource: BannerDataSource
) : BannerRepository {
    override fun getBanners(): Single<List<Banner>> {
        return remoteBannerDataSource.getBanners()
    }
}