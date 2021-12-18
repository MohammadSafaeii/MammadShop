package saf.moham.mammadshop.detail.repository

import saf.moham.mammadshop.detail.source.PropertiesDataSource
import saf.moham.mammadshop.detail.source.RemotePropertiesDataSource

class PropertiesRepositoryImp(val remotePropertiesDataSource: PropertiesDataSource):PropertiesRepository {
    override fun getProperties() = remotePropertiesDataSource.getProperties()
}