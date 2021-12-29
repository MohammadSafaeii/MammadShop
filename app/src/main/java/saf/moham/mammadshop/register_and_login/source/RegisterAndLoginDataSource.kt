package saf.moham.mammadshop.register_and_login.source

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.Message
import saf.moham.mammadshop.data.RegisterAndLoginMessage

interface RegisterAndLoginDataSource {
    fun register(email:String, pass:String): Single<RegisterAndLoginMessage>
    fun login(email:String, pass:String): Single<RegisterAndLoginMessage>
    fun saveToken(token:String, refreshToken:String)
    fun loadToken()
    fun checkLogin():Boolean
    fun addToFav(id:String):Single<Message>
    fun deleteFromFav(id:String):Single<Message>
}