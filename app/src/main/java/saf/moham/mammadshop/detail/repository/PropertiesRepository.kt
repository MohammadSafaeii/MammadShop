package saf.moham.mammadshop.detail.repository

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.Property

interface PropertiesRepository {
    fun getProperties():Single<List<Property>>
}