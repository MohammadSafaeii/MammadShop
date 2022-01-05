package saf.moham.mammadshop.shop

import androidx.lifecycle.MutableLiveData
import saf.moham.mammadshop.data.ShopResponse
import saf.moham.mammadshop.shop.repository.ShopRepository
import saf.moham.mammadshop.utilities.BaseViewModel
import saf.moham.mammadshop.utilities.MySingleObserver
import saf.moham.mammadshop.utilities.singleHelper

class ShopViewModel(shopRepository: ShopRepository):BaseViewModel() {
    val shopItemsLiveData = MutableLiveData<ShopResponse>()

    init {
        showProgressBarLiveData.value = true

        shopRepository.getItems()
            .singleHelper()
            .subscribe(object: MySingleObserver<ShopResponse>(compositeDisposable){
                override fun onSuccess(t: ShopResponse) {
                    showProgressBarLiveData.value = false
                    shopItemsLiveData.value = t
                }
            })
    }

}