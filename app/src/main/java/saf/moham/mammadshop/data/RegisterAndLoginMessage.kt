package saf.moham.mammadshop.data

data class RegisterAndLoginMessage(
    val message: String,
    val refresh_token: String,
    val status: String
)