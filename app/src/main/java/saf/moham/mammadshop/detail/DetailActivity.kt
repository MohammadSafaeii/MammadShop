package saf.moham.mammadshop.detail

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import saf.moham.mammadshop.R
import saf.moham.mammadshop.utilities.ImageLoading
import saf.moham.mammadshop.utilities.MyActivity
import java.awt.font.TextAttribute

class DetailActivity : MyActivity() {
    val detailProductViewModel:DetailProductViewModel by viewModel { parametersOf(intent.extras!!.getString("id")) }
    val imageLoading:ImageLoading by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val mainImage=findViewById<SimpleDraweeView>(R.id.image_main_product)
        val txtTitle=findViewById<TextView>(R.id.text_detail_title)
        val txtPrice=findViewById<TextView>(R.id.text_detail_price)
        val txtPrePrice=findViewById<TextView>(R.id.text_detail_prePrice)
        val txtColor=findViewById<TextView>(R.id.text_detail_color)
        val txtGuarantee=findViewById<TextView>(R.id.text_detail_guarantee)
        val txtIntro=findViewById<TextView>(R.id.text_introduction)
        val ratingBar=findViewById<RatingBar>(R.id.detail_ratingBar)
        val goProperties=findViewById<ImageView>(R.id.go_properties_image)


        detailProductViewModel.detailProductLiveData.observe(this){
            val product=it[0]
            imageLoading.loadPicture(mainImage,product.image)
            txtTitle.text=product.title
            txtPrice.text=product.price
            txtPrePrice.text=product.pprice
            txtPrePrice.paintFlags=android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
            txtColor.text=product.colors
            txtGuarantee.text=product.garantee
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                txtIntro.text= Html.fromHtml(product.introduction,Html.FROM_HTML_MODE_COMPACT)
            } else {
                txtIntro.text=Html.fromHtml(product.introduction)
            }
            ratingBar.rating=product.rating.toFloat()
        }

        detailProductViewModel.showProgressBarLiveData.observe(this){
            showProgressBar(it)
        }

        goProperties.setOnClickListener{
            startActivity(Intent(this,PropertyActivity::class.java))
        }

    }
}