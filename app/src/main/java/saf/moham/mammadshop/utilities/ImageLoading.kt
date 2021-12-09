package saf.moham.mammadshop.utilities

import com.facebook.drawee.view.SimpleDraweeView
import saf.moham.mammadshop.data.Banner

interface ImageLoading {
    fun loadPicture (imageViewPlate:SimpleDraweeView,imageUrl:String)
}