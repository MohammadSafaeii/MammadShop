package saf.moham.mammadshop.home.repository

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.AmazingProduct

interface AmazingProductRepository {
    fun getAmazingProduct(): Single<List<AmazingProduct>>
}