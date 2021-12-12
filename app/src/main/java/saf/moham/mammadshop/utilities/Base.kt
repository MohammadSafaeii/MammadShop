package saf.moham.mammadshop.utilities

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import saf.moham.mammadshop.R

abstract class BaseViewModel:ViewModel(){
    val compositeDisposable=CompositeDisposable()
    val showProgressBarLiveData = MutableLiveData<Boolean>()

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

}

abstract class MySingleObserver<T>(private val compositeDisposable: CompositeDisposable):SingleObserver<T>{
    override fun onSubscribe(d: Disposable) {
        compositeDisposable.add(d)
    }

    override fun onError(e: Throwable) {
        Log.i("LOG", "onError: $e")
    }
}


interface MyView {
    val root:CoordinatorLayout?
    val myContext:Context?
    fun showProgressBar (show:Boolean){
        root?.let { rootView->
            myContext?.let { viewContext->
                var progressBarView=rootView.findViewById<View>(R.id.frameProgressBar)
                if(progressBarView==null && show){
                    progressBarView=LayoutInflater.from(viewContext).inflate(R.layout.progressbar,rootView,false)
                    rootView.addView(progressBarView)
                }
                progressBarView?.visibility=if(show) View.VISIBLE else View.GONE
            }
        }
    }
}

abstract class MyActivity:AppCompatActivity(),MyView{

}

abstract class MyFragment:Fragment(),MyView{
    override val root: CoordinatorLayout?
        get() = view as CoordinatorLayout?
    override val myContext: Context?
        get() = context
}

fun <T> Single<T>.singleHelper():Single<T> {
    return subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}