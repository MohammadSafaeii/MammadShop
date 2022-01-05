package saf.moham.mammadshop.data

data class ShopItem(
    var count: String,
    val image: String,
    val price: String,
    val product_id: String,
    val title: String,
    val user_id: String,
    var progressBarLoading:Boolean=false
)