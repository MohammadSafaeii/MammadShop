package saf.moham.mammadshop.home

import androidx.lifecycle.MutableLiveData
import saf.moham.mammadshop.data.Banner
import saf.moham.mammadshop.data.Cat
import saf.moham.mammadshop.home.repository.BannerRepository
import saf.moham.mammadshop.home.repository.CatRepository
import saf.moham.mammadshop.utilities.BaseViewModel
import saf.moham.mammadshop.utilities.MySingleObserver
import saf.moham.mammadshop.utilities.singleHelper

class HomeViewModel(bannerRepository: BannerRepository,catRepository: CatRepository): BaseViewModel() {
    val bannerLiveData = MutableLiveData <List<Banner>>()
    val catLiveData = MutableLiveData <List<Cat>>()

    init {
        showProgressBarLiveData.value=true
        bannerRepository.getBanners()
            .singleHelper()
            .doFinally {
                showProgressBarLiveData.value=false
            }
            .subscribe(object : MySingleObserver<List<Banner>>(compositeDisposable){
                override fun onSuccess(t: List<Banner>) {
                    bannerLiveData.value=t
                }
            })

        catRepository.getCats()
            .singleHelper()
            .subscribe(object : MySingleObserver<List<Cat>>(compositeDisposable) {
                override fun onSuccess(t: List<Cat>) {
                    catLiveData.value=t
                }
            })
    }
}