package saf.moham.mammadshop.detail.viewModel

import androidx.lifecycle.MutableLiveData
import saf.moham.mammadshop.data.Property
import saf.moham.mammadshop.detail.repository.PropertiesRepository
import saf.moham.mammadshop.utilities.BaseViewModel
import saf.moham.mammadshop.utilities.MySingleObserver
import saf.moham.mammadshop.utilities.singleHelper

class PropertyViewModel(propertiesRepository: PropertiesRepository):BaseViewModel() {
    val propertiesLiveData = MutableLiveData<List<Property>>()
    init {
        showProgressBarLiveData.value=true

        propertiesRepository.getProperties()
            .singleHelper()
            .subscribe(object: MySingleObserver<List<Property>>(compositeDisposable){
                override fun onSuccess(t: List<Property>) {
                    propertiesLiveData.value=t
                    showProgressBarLiveData.value=false
                }
            })
    }
}