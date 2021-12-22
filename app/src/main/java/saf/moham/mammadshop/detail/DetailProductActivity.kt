package saf.moham.mammadshop.detail

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.compose.runtime.produceState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import org.json.JSONArray
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import saf.moham.mammadshop.R
import saf.moham.mammadshop.data.RatingItem
import saf.moham.mammadshop.detail.adapter.RatingItemRWAdapter
import saf.moham.mammadshop.detail.viewModel.DetailProductViewModel
import saf.moham.mammadshop.utilities.*
import java.util.ArrayList

class DetailProductActivity : MyActivity(),MoreBottomDialogFragment.BottomDialogItemClicked {
    val detailProductViewModel: DetailProductViewModel by viewModel { parametersOf(intent.extras!!.getString("id")) }
    val imageLoading:ImageLoading by inject()
    lateinit var productId:String
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
        val goProperties=findViewById<ImageView>(R.id.go_properties_image)
        val imgMore=findViewById<ImageView>(R.id.image_more)
        val imgFavorite=findViewById<ImageView>(R.id.image_favorite)
        val imgBasket=findViewById<ImageView>(R.id.image_shop)
        val imgClose=findViewById<ImageView>(R.id.image_close)
        val ratingBar=findViewById<RatingBar>(R.id.detail_ratingBar)
        val ratingsItemRw=findViewById<RecyclerView>(R.id.ratings_rw)

        ratingsItemRw.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        detailProductViewModel.detailProductLiveData.observe(this){
            val product=it[0]
            productId=product.id
            imageLoading.loadPicture(mainImage,product.image)
            txtTitle.text=product.title
            txtPrice.text=product.price
            txtPrePrice.text=product.pprice
            txtPrePrice.paintFlags=android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
            txtColor.text=product.colors
            txtGuarantee.text=product.garantee
            ratingBar.rating=product.rating.toFloat()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                txtIntro.text= Html.fromHtml(product.introduction,Html.FROM_HTML_MODE_COMPACT)
            } else {
                txtIntro.text=Html.fromHtml(product.introduction)
            }
            val ratingItems = it[0].rating_item
            val ratingItemsList = ArrayList<RatingItem>()
            val ratingArray = JSONArray(ratingItems)
            for (i in 0 until ratingArray.length()){
                val jsonObject=ratingArray.getJSONObject(i)
                val ratingItem=RatingItem(jsonObject.getString("title"),jsonObject.getString("value"))
                ratingItemsList.add(ratingItem)
            }

            val rwAdapter = RatingItemRWAdapter(ratingItemsList)
            ratingsItemRw.adapter = rwAdapter

        }

        detailProductViewModel.showProgressBarLiveData.observe(this){
            showProgressBar(it)
        }

        goProperties.setOnClickListener{
            startActivity(Intent(this,PropertyActivity::class.java))
        }

        imgClose.setOnClickListener {
            finish()
        }

        imgMore.setOnClickListener {
            val moreBottomDialog=MoreBottomDialogFragment()
            moreBottomDialog.show(supportFragmentManager,null)
            moreBottomDialog.setItemClickListener(this)
        }

    }

    override fun itemClicked(thisType: String) {
        when(thisType){
            GRAPH->{
                val intent = Intent(applicationContext,GraphActivity::class.java).apply {
                    putExtra("id",productId)
                }
                startActivity(intent)
            }
            COMPARE->{

            }
            SHARE->{
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(
                        Intent.EXTRA_TEXT,
                        "https://www.digikala.com/product/dkp-7328010/گوشی-موبایل-شیائومی-مدل-redmi-note-10s-m2101k7bny-دو-سیم-کارت-ظرفیت-64-گیگابایت-و-رم-6-گیگابایت")
                }
                startActivity(Intent.createChooser(intent,"معرفی محصول"))
            }
        }
    }

}