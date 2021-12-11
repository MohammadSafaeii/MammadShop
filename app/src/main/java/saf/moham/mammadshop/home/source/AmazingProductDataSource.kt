package saf.moham.mammadshop.home.source

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.AmazingProduct

interface AmazingProductDataSource {
    fun getAmazingProduct(): Single<List<AmazingProduct>>
}