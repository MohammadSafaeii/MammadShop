package saf.moham.mammadshop.detail.repository

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.PriceHistory

interface GraphRepository {
    fun getPriceHistory(id:String):Single<List<PriceHistory>>
}