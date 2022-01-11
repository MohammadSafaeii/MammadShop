package saf.moham.mammadshop.pay.repository

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.Message
import saf.moham.mammadshop.pay.source.PayDataSource
import saf.moham.mammadshop.pay.source.RemotePayDataSource

class PayRepositoryImp(val remotePayDataSource: PayDataSource): PayRepository {
    override fun pay(orderId: String) = remotePayDataSource.pay(orderId)
}