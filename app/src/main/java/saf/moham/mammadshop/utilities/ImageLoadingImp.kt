package saf.moham.mammadshop.utilities

import com.facebook.drawee.view.SimpleDraweeView
import saf.moham.mammadshop.utilities.ImageLoading

class ImageLoadingImp: ImageLoading {
    override fun loadPicture(imageViewPlate: SimpleDraweeView,imageUrl:String) {
        imageViewPlate.setImageURI(imageUrl)
    }
}