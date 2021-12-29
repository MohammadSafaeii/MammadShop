package saf.moham.mammadshop.register_and_login.repository

import io.reactivex.rxjava3.core.Single
import saf.moham.mammadshop.data.Message
import saf.moham.mammadshop.data.RegisterAndLoginMessage
import saf.moham.mammadshop.register_and_login.TokenHolder
import saf.moham.mammadshop.register_and_login.source.LocalRegisterAndLoginDataSource
import saf.moham.mammadshop.register_and_login.source.RegisterAndLoginDataSource
import saf.moham.mammadshop.register_and_login.source.RemoteRegisterAndLoginDataSource

class RegisterAndLoginRepositoryImp(val remoteRegisterAndLoginDataSource: RegisterAndLoginDataSource, val localRegisterAndLoginDataSource: RegisterAndLoginDataSource): RegisterAndLoginRepository {
    override fun register(email: String, pass: String): Single<RegisterAndLoginMessage> {
        return remoteRegisterAndLoginDataSource.register(email, pass).doOnSuccess {
            TokenHolder.updateToken(it.message, it.refresh_token)
            localRegisterAndLoginDataSource.saveToken(it.message, it.refresh_token)
        }
    }

    override fun login(email: String, pass: String): Single<RegisterAndLoginMessage> {
        return remoteRegisterAndLoginDataSource.login(email, pass).doOnSuccess {
            TokenHolder.updateToken(it.message, it.refresh_token)
            localRegisterAndLoginDataSource.saveToken(it.message, it.refresh_token)
        }
    }

    override fun loadToken() {
        return localRegisterAndLoginDataSource.loadToken()
    }

    override fun checkLogin(): Boolean {
        return localRegisterAndLoginDataSource.checkLogin()
    }

    override fun addToFav(id: String): Single<Message> {
        return remoteRegisterAndLoginDataSource.addToFav(id)
    }

    override fun deleteFromFav(id: String): Single<Message> {
        return remoteRegisterAndLoginDataSource.deleteFromFav(id)
    }
}