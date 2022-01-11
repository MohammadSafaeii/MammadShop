package saf.moham.mammadshop.pay

import androidx.lifecycle.MutableLiveData
import saf.moham.mammadshop.data.Message
import saf.moham.mammadshop.pay.repository.PayRepository
import saf.moham.mammadshop.utilities.BaseViewModel
import saf.moham.mammadshop.utilities.MySingleObserver
import saf.moham.mammadshop.utilities.singleHelper

class PayViewModel(payRepository: PayRepository, orderId: String): BaseViewModel() {
    val payLiveData = MutableLiveData<Message>()
    init {
        showProgressBarLiveData.value = true
        payRepository.pay(orderId)
            .singleHelper()
            .subscribe(object: MySingleObserver<Message>(compositeDisposable){
                override fun onSuccess(t: Message) {
                    payLiveData.value = t
                    showProgressBarLiveData.value = false
                }
            })
    }
}