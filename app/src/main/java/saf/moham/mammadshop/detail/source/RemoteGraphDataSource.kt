package saf.moham.mammadshop.detail.source

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.PriceHistory
import saf.moham.mammadshop.retrofit.ApiService

class RemoteGraphDataSource(val apiService: ApiService):GraphDataSource {
    override fun getPriceHistory(id: String) = apiService.getPriceHistory(id)
}