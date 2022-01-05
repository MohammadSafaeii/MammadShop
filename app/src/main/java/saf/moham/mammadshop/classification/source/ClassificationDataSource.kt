package saf.moham.mammadshop.classification.source

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.CatClassification

interface ClassificationDataSource {
    fun getClassification(): Single<List<CatClassification>>
}