package saf.moham.mammadshop.detail.viewModel

import androidx.lifecycle.MutableLiveData
import saf.moham.mammadshop.data.PriceHistory
import saf.moham.mammadshop.detail.repository.GraphRepository
import saf.moham.mammadshop.utilities.BaseViewModel
import saf.moham.mammadshop.utilities.MySingleObserver
import saf.moham.mammadshop.utilities.singleHelper

class GraphViewModel(id:String,graphRepository: GraphRepository): BaseViewModel() {
    val graphLiveData = MutableLiveData<List<PriceHistory>>()
    init {
        showProgressBarLiveData.value=true

        graphRepository.getPriceHistory(id)
            .singleHelper()
            .subscribe(object: MySingleObserver<List<PriceHistory>>(compositeDisposable) {
                override fun onSuccess(t: List<PriceHistory>) {
                    graphLiveData.value = t
                    showProgressBarLiveData.value = false
                }
            })
    }
}