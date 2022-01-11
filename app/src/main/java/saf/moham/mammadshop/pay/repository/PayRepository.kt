package saf.moham.mammadshop.pay.repository

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.Message

interface PayRepository {
    fun pay(orderId: String): Single<Message>
}