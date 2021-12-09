package saf.moham.mammadshop.home.source

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.Cat

interface CatDataSource {
    fun getCats():Single<List<Cat>>
}