package saf.moham.mammadshop.classification.source

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.CatClassification
import saf.moham.mammadshop.retrofit.ApiService

class RemoteClassificationDataSource(val apiService: ApiService):ClassificationDataSource {
    override fun getClassification() = apiService.getClassification()
}