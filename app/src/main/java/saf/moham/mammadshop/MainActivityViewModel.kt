package saf.moham.mammadshop

import org.greenrobot.eventbus.EventBus
import saf.moham.mammadshop.data.BasketItemCount
import saf.moham.mammadshop.register_and_login.TokenHolder
import saf.moham.mammadshop.shop.repository.ShopRepository
import saf.moham.mammadshop.utilities.BaseViewModel
import saf.moham.mammadshop.utilities.MySingleObserver
import saf.moham.mammadshop.utilities.singleHelper

class MainActivityViewModel(val shopRepository: ShopRepository):BaseViewModel() {
    fun getBasketItemCount(){
        if (!TokenHolder.Token.isNullOrEmpty()){
            shopRepository.getBasketItemCount()
                .singleHelper()
                .subscribe(object: MySingleObserver<BasketItemCount>(compositeDisposable){
                    override fun onSuccess(t: BasketItemCount) {
                        EventBus.getDefault().postSticky(t)
                    }
                })
        }
    }
}