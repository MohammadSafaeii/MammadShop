package saf.moham.mammadshop.data

data class ShopResponse(
    var message: List<ShopItem>,
    val status: String,
    var totalPrice:Int
)