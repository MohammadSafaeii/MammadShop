package saf.moham.mammadshop.detail.source

import saf.moham.mammadshop.retrofit.ApiService

class RemotePropertiesDataSource(val apiService: ApiService):PropertiesDataSource {
    override fun getProperties() = apiService.getProperties()
}