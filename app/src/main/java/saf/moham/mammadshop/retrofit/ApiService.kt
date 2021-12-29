package saf.moham.mammadshop.retrofit

import io.reactivex.rxjava3.core.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import saf.moham.mammadshop.data.*
import saf.moham.mammadshop.register_and_login.TokenHolder

interface ApiService{
    @GET("readbanner.php")
    fun getBanners():Single<List<Banner>>
    @GET("getcat.php")
    fun getCats():Single<List<Cat>>
    @GET("readamazing.php")
    fun getAmazingProducts():Single<List<AmazingProduct>>
    @GET("getdetail2.php")
    fun getDetailProduct(@Query("id") id:String, @Query("user") user:String):Single<List<DetailProduct>>
    @GET("properties.php")
    fun getProperties():Single<List<Property>>
    @GET("history.php")
    fun getPriceHistory(@Query("id") id:String):Single<List<PriceHistory>>
    @GET("getcomparelist.php")
    fun getComparableProducts(@Query("cat") kind:String):Single<List<ComparableProductData>>
    @FormUrlEncoded
    @POST("register.php")
    fun register(@Field("email") email:String, @Field("pass") pass:String):Single<RegisterAndLoginMessage>
    @FormUrlEncoded
    @POST("login2.php")
    fun login(@Field("email") email:String, @Field("pass")pass:String):Single<RegisterAndLoginMessage>
    @GET("addfavorite.php")
    fun addToFav(@Query("id") id:String): Single<Message>
    @GET("deletefav2.php")
    fun deleteFromFav(@Query("id") id:String): Single<Message>
}

fun getClient():ApiService{

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor{
            val oldRequest = it.request()
            val newRequestBuilder = oldRequest.newBuilder()
            if (TokenHolder.Token != null)
                newRequestBuilder.addHeader("token",TokenHolder.Token)
            newRequestBuilder.addHeader("Accept", "application/json")
            newRequestBuilder.method(oldRequest.method(),oldRequest.body())
            return@addInterceptor it.proceed(newRequestBuilder.build())
        }
        .build()

    val retrofit=Retrofit.Builder()
        .baseUrl("http://ehsanghafourian.ir/MohammadSafaei/expert-php_2/digikala/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .client(okHttpClient)
        .build()

    return retrofit.create(ApiService::class.java)
}