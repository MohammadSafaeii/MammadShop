package saf.moham.mammadshop.home

import com.facebook.drawee.view.SimpleDraweeView
import saf.moham.mammadshop.data.Banner

class ImageLoadingImp:ImageLoading {
    override fun loadPicture(imageViewPlate: SimpleDraweeView, banner: Banner) {
        imageViewPlate.setImageURI(banner.pic)
    }
}