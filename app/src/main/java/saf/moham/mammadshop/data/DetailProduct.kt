package saf.moham.mammadshop.data

data class DetailProduct(
    val cat: String,
    val colors: String,
    val fav: List<Favorite>,
    val garantee: String,
    val id: String,
    val image: String,
    val introduction: String,
    val pprice: String,
    val price: String,
    val properties: String,
    val rating: String,
    val rating_item: String,
    val title: String,
    val weight: String
)