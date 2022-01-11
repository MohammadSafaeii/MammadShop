package saf.moham.mammadshop.pay.source

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.Message

interface PayDataSource {
    fun pay(orderId: String): Single<Message>
}