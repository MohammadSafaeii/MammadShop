package saf.moham.mammadshop.retrofit

import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import saf.moham.mammadshop.data.Banner
import saf.moham.mammadshop.data.Cat

interface ApiService{
    @GET("readbanner.php")
    fun getBanners():Single<List<Banner>>
    @GET("getcat.php")
    fun getCats():Single<List<Cat>>
}

fun getClient():ApiService{
    val retrofit=Retrofit.Builder()
        .baseUrl("http://ehsanghafourian.ir/MohammadSafaei/expert-php_2/digikala/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    return retrofit.create(ApiService::class.java)
}