package saf.moham.mammadshop.detail

import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.disposables.CompositeDisposable
import saf.moham.mammadshop.data.DetailProduct
import saf.moham.mammadshop.detail.repository.DetailProductRepository
import saf.moham.mammadshop.utilities.BaseViewModel
import saf.moham.mammadshop.utilities.MySingleObserver
import saf.moham.mammadshop.utilities.singleHelper

class DetailProductViewModel(id:String, detailProductRepository: DetailProductRepository):BaseViewModel() {
    val detailProductLiveData=MutableLiveData<List<DetailProduct>>()
    val idLiveData=MutableLiveData<String>()
    init {
        showProgressBarLiveData.value=true
        idLiveData.value=id
        detailProductRepository.getDetailProduct(idLiveData.value!!,"")
            .singleHelper()
            .doFinally {
                showProgressBarLiveData.value=false
            }
            .subscribe(object : MySingleObserver<List<DetailProduct>>(compositeDisposable){
                override fun onSuccess(t: List<DetailProduct>) {
                    detailProductLiveData.value=t
                }
            })
    }
}