package saf.moham.mammadshop.detail.source

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.Property

interface PropertiesDataSource {
    fun getProperties():Single<List<Property>>
}