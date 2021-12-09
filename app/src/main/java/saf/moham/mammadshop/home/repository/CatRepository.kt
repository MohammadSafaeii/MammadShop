package saf.moham.mammadshop.home.repository

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.Cat

interface CatRepository {
    fun getCats(): Single<List<Cat>>
}