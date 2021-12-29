package saf.moham.mammadshop.detail.viewModel

import androidx.lifecycle.MutableLiveData
import saf.moham.mammadshop.data.DetailProduct
import saf.moham.mammadshop.data.Favorite
import saf.moham.mammadshop.detail.repository.DetailProductRepository
import saf.moham.mammadshop.register_and_login.TokenHolder
import saf.moham.mammadshop.register_and_login.repository.RegisterAndLoginRepository
import saf.moham.mammadshop.utilities.BaseViewModel
import saf.moham.mammadshop.utilities.MySingleObserver
import saf.moham.mammadshop.utilities.singleHelper

class DetailProductViewModel(id:String, detailProductRepository: DetailProductRepository, registerAndLoginRepository: RegisterAndLoginRepository):BaseViewModel() {
    val detailProductLiveData = MutableLiveData<List<DetailProduct>>()
    val idLiveData = MutableLiveData<String>()
    val favoriteLiveData = MutableLiveData<List<Favorite>>()
    init {
        showProgressBarLiveData.value=true
        idLiveData.value=id
        registerAndLoginRepository.loadToken()
        val token = TokenHolder.Token
        if (token == null) {
            detailProductRepository.getDetailProduct(idLiveData.value!!, "")
                .singleHelper()
                .subscribe(object : MySingleObserver<List<DetailProduct>>(compositeDisposable) {
                    override fun onSuccess(t: List<DetailProduct>) {
                        showProgressBarLiveData.value = false
                        detailProductLiveData.value = t
                        favoriteLiveData.value = t[0].fav
                    }
                })
        }else{
            detailProductRepository.getDetailProduct(idLiveData.value!!, token)
                .singleHelper()
                .subscribe(object : MySingleObserver<List<DetailProduct>>(compositeDisposable) {
                    override fun onSuccess(t: List<DetailProduct>) {
                        showProgressBarLiveData.value = false
                        detailProductLiveData.value = t
                        favoriteLiveData.value = t[0].fav
                    }
                })
        }
    }
}