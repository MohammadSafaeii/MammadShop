package saf.moham.mammadshop.shop

import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.core.Single
import org.greenrobot.eventbus.EventBus
import saf.moham.mammadshop.data.BasketItemCount
import saf.moham.mammadshop.data.Message
import saf.moham.mammadshop.data.ShopResponse
import saf.moham.mammadshop.shop.repository.ShopRepository
import saf.moham.mammadshop.utilities.BaseViewModel
import saf.moham.mammadshop.utilities.MySingleObserver
import saf.moham.mammadshop.utilities.singleHelper

class ShopViewModel(val shopRepository: ShopRepository):BaseViewModel() {
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

    fun getItems(){
        shopRepository.getBasketItemCount()
            .singleHelper()
            .subscribe(object: MySingleObserver<BasketItemCount>(compositeDisposable){
                override fun onSuccess(basketItemCount: BasketItemCount) {
                    shopRepository.getItems()
                        .singleHelper()
                        .subscribe(object: MySingleObserver<ShopResponse>(compositeDisposable){
                            override fun onSuccess(shopResponse: ShopResponse) {
                                shopItemsLiveData.value = shopResponse
                                EventBus.getDefault().postSticky(basketItemCount)
                            }
                        })
                }
            })
    }

    fun removeItemFromBasket(id: String): Single<Message>{
        return shopRepository.removeItemFromBasket(id)
    }

    fun changeItemCount(id: String, count: Int): Single<Message>{
        return shopRepository.changeItemCount(id, count)
    }

}