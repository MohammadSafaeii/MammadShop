package saf.moham.mammadshop.classification

import androidx.lifecycle.MutableLiveData
import saf.moham.mammadshop.classification.repository.ClassificationRepository
import saf.moham.mammadshop.data.CatClassification
import saf.moham.mammadshop.utilities.BaseViewModel
import saf.moham.mammadshop.utilities.MySingleObserver
import saf.moham.mammadshop.utilities.singleHelper

class ClassificationViewModel(classificationRepository: ClassificationRepository): BaseViewModel() {
    val classificationLiveData = MutableLiveData<List<CatClassification>>()

    init {
        showProgressBarLiveData.value = true

        classificationRepository.getClassification()
            .singleHelper()
            .subscribe(object: MySingleObserver<List<CatClassification>>(compositeDisposable){
                override fun onSuccess(t: List<CatClassification>) {
                    showProgressBarLiveData.value = false
                    classificationLiveData.value = t
                }
            })
    }

}