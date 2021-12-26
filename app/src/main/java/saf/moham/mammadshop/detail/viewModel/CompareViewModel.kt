package saf.moham.mammadshop.detail.viewModel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import saf.moham.mammadshop.data.DetailProduct
import saf.moham.mammadshop.data.Property
import saf.moham.mammadshop.detail.repository.DetailProductRepository
import saf.moham.mammadshop.detail.repository.PropertiesRepository
import saf.moham.mammadshop.utilities.BaseViewModel
import saf.moham.mammadshop.utilities.MySingleObserver
import saf.moham.mammadshop.utilities.singleHelper

class CompareViewModel(bundle: Bundle, propertiesRepository: PropertiesRepository, detailProductRepository: DetailProductRepository): BaseViewModel() {

    var mainProductProperties: List<Property> = ArrayList()
    val mainProductDetailLiveData = MutableLiveData<List<DetailProduct>>()
    val secondProductDetailLiveData = MutableLiveData<List<DetailProduct>>()
    val secondProductPropertiesLiveData = MutableLiveData<List<Property>>()
    var mainProductId:String?
    var secondProductId:String?


    init {
        showProgressBarLiveData.value=true
        mainProductId = bundle.getString("main_product_id")
        secondProductId = bundle.getString("second_product_id")

        detailProductRepository.getDetailProduct(mainProductId!!,"")
            .singleHelper()
            .subscribe(object: MySingleObserver<List<DetailProduct>>(compositeDisposable){
                override fun onSuccess(t: List<DetailProduct>) {
                    mainProductDetailLiveData.value = t
                }
            })

        detailProductRepository.getDetailProduct(secondProductId!!,"")
            .singleHelper()
            .subscribe(object: MySingleObserver<List<DetailProduct>>(compositeDisposable){
                override fun onSuccess(t: List<DetailProduct>) {
                    secondProductDetailLiveData.value = t
                }
            })

        propertiesRepository.getProperties()
            .singleHelper()
            .subscribe(object: MySingleObserver<List<Property>>(compositeDisposable){
                override fun onSuccess(t: List<Property>) {

                    mainProductProperties = t
                    propertiesRepository.getProperties()
                        .singleHelper()
                        .subscribe(object: MySingleObserver<List<Property>>(compositeDisposable){
                            override fun onSuccess(t: List<Property>) {
                                secondProductPropertiesLiveData.value=t
                                showProgressBarLiveData.value=false
                            }
                        })


                }
            })
    }
}