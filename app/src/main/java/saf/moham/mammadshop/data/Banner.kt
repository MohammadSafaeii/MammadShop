package saf.moham.mammadshop.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Banner(
    val id: String,
    val pic: String,
    val type: String
):Parcelable