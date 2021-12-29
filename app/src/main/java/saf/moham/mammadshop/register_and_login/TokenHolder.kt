package saf.moham.mammadshop.register_and_login

object TokenHolder {
    var Token:String? = null
    private set
    var refreshToken:String? = null
    private set

    fun updateToken(token:String?, refreshToken:String?){
        this.Token=token
        this.refreshToken=refreshToken
    }

}
