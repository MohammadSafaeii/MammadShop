package saf.moham.mammadshop.detail.viewModel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import saf.moham.mammadshop.data.ComparableProductData
import saf.moham.mammadshop.detail.repository.ComparableProductsRepository
import saf.moham.mammadshop.utilities.BaseViewModel
import saf.moham.mammadshop.utilities.MySingleObserver
import saf.moham.mammadshop.utilities.singleHelper

class ComparableProductsViewModel(bundle: Bundle, comparableProductsRepository: ComparableProductsRepository): BaseViewModel() {

    val comparableProductsLiveData = MutableLiveData<List<ComparableProductData>>()
    var firstProductId:String?

    init {
        showProgressBarLiveData.value=true
        firstProductId = bundle.getString("main_product_id")
        val kind = bundle.getString("main_product_cat")

        comparableProductsRepository.getComparableProducts(kind!!)
            .singleHelper()
            .subscribe(object : MySingleObserver<List<ComparableProductData>>(compositeDisposable){
                override fun onSuccess(t: List<ComparableProductData>) {
                    comparableProductsLiveData.value=t
                    showProgressBarLiveData.value=false
                }
            })
    }
}