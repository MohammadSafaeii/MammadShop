package saf.moham.mammadshop.register_and_login.source

import android.content.SharedPreferences
import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.Message
import saf.moham.mammadshop.data.RegisterAndLoginMessage
import saf.moham.mammadshop.register_and_login.TokenHolder

class LocalRegisterAndLoginDataSource(val sharedPreferences: SharedPreferences):RegisterAndLoginDataSource {
    override fun register(email: String, pass: String): Single<RegisterAndLoginMessage> {
        TODO("Not yet implemented")
    }

    override fun login(email: String, pass: String): Single<RegisterAndLoginMessage> {
        TODO("Not yet implemented")
    }

    override fun saveToken(token: String, refreshToken: String) {
        sharedPreferences.edit().apply {
            putString("token",token)
            putString("refreshToken",refreshToken)
        }.apply()
    }

    override fun loadToken() {
        TokenHolder.updateToken(sharedPreferences.getString("token", null),sharedPreferences.getString("refreshToken", null))
    }

    override fun checkLogin(): Boolean {
        if (sharedPreferences.getString("token","")=="")
            return false
        else
            return true
    }

    override fun addToFav(id: String): Single<Message> {
        TODO("Not yet implemented")
    }

    override fun deleteFromFav(id: String): Single<Message> {
        TODO("Not yet implemented")
    }
}