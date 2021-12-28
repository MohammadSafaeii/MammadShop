package saf.moham.mammadshop.register_and_login

import androidx.lifecycle.MutableLiveData
import saf.moham.mammadshop.data.RegisterAndLoginMessage
import saf.moham.mammadshop.register_and_login.repository.RegisterAndLoginRepository
import saf.moham.mammadshop.utilities.BaseViewModel
import saf.moham.mammadshop.utilities.MySingleObserver
import saf.moham.mammadshop.utilities.singleHelper

class RegisterAndLoginViewModel(val registerAndLoginRepository: RegisterAndLoginRepository):BaseViewModel() {

    val registerLiveData = MutableLiveData<RegisterAndLoginMessage>()
    val loginLiveData = MutableLiveData<RegisterAndLoginMessage>()

    fun register(email:String, pass:String){
        showProgressBarLiveData.value=true
        registerAndLoginRepository.register(email, pass)
            .singleHelper()
            .subscribe(object: MySingleObserver<RegisterAndLoginMessage>(compositeDisposable){
                override fun onSuccess(t: RegisterAndLoginMessage) {
                    registerLiveData.value=t
                    showProgressBarLiveData.value=false
                }
            })
    }

    fun login(email:String, pass:String){
        showProgressBarLiveData.value=true
        registerAndLoginRepository.login(email, pass)
            .singleHelper()
            .subscribe(object: MySingleObserver<RegisterAndLoginMessage>(compositeDisposable){
                override fun onSuccess(t: RegisterAndLoginMessage) {
                    loginLiveData.value=t
                    showProgressBarLiveData.value=false
                }
            })
    }
}