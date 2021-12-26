package saf.moham.mammadshop.detail

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import org.w3c.dom.Text
import saf.moham.mammadshop.R
import saf.moham.mammadshop.detail.adapter.CompareRWAdapter
import saf.moham.mammadshop.detail.viewModel.CompareViewModel
import saf.moham.mammadshop.utilities.ImageLoading
import saf.moham.mammadshop.utilities.MyActivity

class CompareActivity : MyActivity() {
    val compareViewModel: CompareViewModel by viewModel { parametersOf(intent.extras!!) }
    val imageLoading: ImageLoading by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compare)

        val backImg=findViewById<ImageView>(R.id.go_back_img)
        val mainProductImage = findViewById<SimpleDraweeView>(R.id.main_product_img)
        val mainProductTitle = findViewById<TextView>(R.id.main_product_title)
        val mainProductPrice = findViewById<TextView>(R.id.main_product_price)
        val secondProductImage = findViewById<SimpleDraweeView>(R.id.second_product_img)
        val secondProductTitle = findViewById<TextView>(R.id.second_product_title)
        val secondProductPrice = findViewById<TextView>(R.id.second_product_price)
        val compareProductsRW = findViewById<RecyclerView>(R.id.compare_products_rw)
        compareProductsRW.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)


        compareViewModel.mainProductDetailLiveData.observe(this){
            imageLoading.loadPicture(mainProductImage,it[0].image)
            mainProductTitle.text = it[0].title
            mainProductPrice.text = it[0].price
        }

        compareViewModel.secondProductDetailLiveData.observe(this){
            imageLoading.loadPicture(secondProductImage,it[0].image)
            secondProductTitle.text = it[0].title
            secondProductPrice.text = it[0].price
        }

        compareViewModel.secondProductPropertiesLiveData.observe(this){
            val rwAdapter: CompareRWAdapter by inject { parametersOf(compareViewModel.mainProductProperties,it) }
            compareProductsRW.adapter=rwAdapter
        }

        compareViewModel.showProgressBarLiveData.observe(this){
            showProgressBar(it)
        }

        backImg.setOnClickListener{
            finish()
        }

    }
}