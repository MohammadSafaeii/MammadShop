package saf.moham.mammadshop.register_and_login.repository

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.RegisterAndLoginMessage

interface RegisterAndLoginRepository {
    fun register(email:String, pass:String): Single<RegisterAndLoginMessage>
    fun login(email:String, pass:String): Single<RegisterAndLoginMessage>
    fun loadToken()
    fun checkLogin():Boolean
    fun addToFav(id:String): Single<RegisterAndLoginMessage>
    fun deleteFromFav(id:String): Single<RegisterAndLoginMessage>
}