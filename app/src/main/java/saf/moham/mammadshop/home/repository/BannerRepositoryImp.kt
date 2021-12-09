package saf.moham.mammadshop.home.repository

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.Banner
import saf.moham.mammadshop.home.repository.BannerRepository
import saf.moham.mammadshop.home.source.BannerDataSource

class BannerRepositoryImp(
    val localBannerDataSource: BannerDataSource,
    private val remoteBannerDataSource: BannerDataSource
) : BannerRepository {
    override fun getBanners(): Single<List<Banner>> {
        return remoteBannerDataSource.getBanners()
    }
}