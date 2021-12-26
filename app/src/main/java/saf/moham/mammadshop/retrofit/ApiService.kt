package saf.moham.mammadshop.retrofit

import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import saf.moham.mammadshop.data.*

interface ApiService{
    @GET("readbanner.php")
    fun getBanners():Single<List<Banner>>
    @GET("getcat.php")
    fun getCats():Single<List<Cat>>
    @GET("readamazing.php")
    fun getAmazingProducts():Single<List<AmazingProduct>>
    @GET("getdetail.php")
    fun getDetailProduct(@Query("id") id:String, @Query("user") user:String):Single<List<DetailProduct>>
    @GET("properties.php")
    fun getProperties():Single<List<Property>>
    @GET("history.php")
    fun getPriceHistory(@Query("id") id:String):Single<List<PriceHistory>>
    @GET("getcomparelist.php")
    fun getComparableProducts(@Query("cat") kind:String):Single<List<ComparableProductData>>
}

fun getClient():ApiService{
    val retrofit=Retrofit.Builder()
        .baseUrl("http://ehsanghafourian.ir/MohammadSafaei/expert-php_2/digikala/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    return retrofit.create(ApiService::class.java)
}