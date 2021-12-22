package saf.moham.mammadshop.detail.source

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.PriceHistory

interface GraphDataSource {
    fun getPriceHistory(id:String):Single<List<PriceHistory>>
}