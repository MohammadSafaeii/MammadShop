package saf.moham.mammadshop.classification.repository

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.CatClassification

interface ClassificationRepository {
    fun getClassification(): Single<List<CatClassification>>
}