package saf.moham.mammadshop.detail.repository

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.PriceHistory
import saf.moham.mammadshop.detail.source.GraphDataSource
import saf.moham.mammadshop.detail.source.RemoteGraphDataSource

class GraphRepositoryImp(val remoteGraphDataSource: GraphDataSource):GraphRepository {
    override fun getPriceHistory(id: String) = remoteGraphDataSource.getPriceHistory(id)
}