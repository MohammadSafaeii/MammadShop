package saf.moham.mammadshop.pay.source

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.Message
import saf.moham.mammadshop.retrofit.ApiService

class RemotePayDataSource(val apiService: ApiService): PayDataSource {
    override fun pay(orderId: String) = apiService.pay(orderId)
}