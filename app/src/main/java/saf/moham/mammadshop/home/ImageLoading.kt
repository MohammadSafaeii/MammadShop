package saf.moham.mammadshop.home

import com.facebook.drawee.view.SimpleDraweeView
import saf.moham.mammadshop.data.Banner

interface ImageLoading {
    fun loadPicture (imageViewPlate:SimpleDraweeView,banner:Banner)
}