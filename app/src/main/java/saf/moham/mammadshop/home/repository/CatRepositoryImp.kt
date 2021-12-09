package saf.moham.mammadshop.home.repository

import saf.moham.mammadshop.home.source.CatDataSource

class CatRepositoryImp(val remoteCatDataSource: CatDataSource): CatRepository {
    override fun getCats() = remoteCatDataSource.getCats()
}