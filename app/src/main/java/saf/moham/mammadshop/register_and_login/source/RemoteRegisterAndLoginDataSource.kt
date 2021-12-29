package saf.moham.mammadshop.register_and_login.source

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.Message
import saf.moham.mammadshop.data.RegisterAndLoginMessage
import saf.moham.mammadshop.retrofit.ApiService

class RemoteRegisterAndLoginDataSource(val apiService: ApiService):RegisterAndLoginDataSource {
    override fun register(email: String, pass: String): Single<RegisterAndLoginMessage> {
        return apiService.register(email, pass)
    }

    override fun login(email: String, pass: String): Single<RegisterAndLoginMessage> {
        return apiService.login(email, pass)
    }

    override fun saveToken(token: String, refreshToken: String) {
        TODO("Not yet implemented")
    }

    override fun loadToken() {
        TODO("Not yet implemented")
    }

    override fun checkLogin(): Boolean {
        TODO("Not yet implemented")
    }

    override fun addToFav(id: String): Single<Message> {
        return apiService.addToFav(id)
    }

    override fun deleteFromFav(id: String): Single<Message> {
        return apiService.deleteFromFav(id)
    }
}