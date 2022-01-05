package saf.moham.mammadshop.classification.repository

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.classification.source.ClassificationDataSource
import saf.moham.mammadshop.classification.source.RemoteClassificationDataSource
import saf.moham.mammadshop.data.CatClassification
import saf.moham.mammadshop.home.source.RemoteCatDataSource

class ClassificationRepositoryImp(val remoteClassificationDataSource: ClassificationDataSource): ClassificationRepository {
    override fun getClassification() = remoteClassificationDataSource.getClassification()
}