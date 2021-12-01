package saf.moham.mammadshop.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import saf.moham.mammadshop.data.Banner
import saf.moham.mammadshop.utilities.BaseViewModel
import saf.moham.mammadshop.utilities.MySingleObserver

class HomeViewModel(bannerRepository: BannerRepository): BaseViewModel() {
    val bannerLiveData = MutableLiveData <List<Banner>>()

    init {
        showProgressBarLiveData.value=true
        bannerRepository.getBanners()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally {
                showProgressBarLiveData.value=false
            }
            .subscribe(object : MySingleObserver<List<Banner>>(compositeDisposable){
                override fun onSuccess(t: List<Banner>) {
                    bannerLiveData.value=t
                }
            })
    }
}