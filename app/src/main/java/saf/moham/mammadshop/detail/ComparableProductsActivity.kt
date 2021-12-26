package saf.moham.mammadshop.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import saf.moham.mammadshop.R
import saf.moham.mammadshop.detail.adapter.ComparableProductsRWAdapter
import saf.moham.mammadshop.detail.viewModel.ComparableProductsViewModel
import saf.moham.mammadshop.utilities.MyActivity

class ComparableProductsActivity : MyActivity(),ComparableProductsRWAdapter.OnComparableProductListener {
    val comparableProductsViewModel: ComparableProductsViewModel by viewModel { parametersOf(intent.extras!!) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comparable_products)

        val backImg=findViewById<ImageView>(R.id.go_back_img)
        val comparableProductsRW = findViewById<RecyclerView>(R.id.comparable_product_rw)
        comparableProductsRW.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        comparableProductsViewModel.comparableProductsLiveData.observe(this){
            val rwAdapter: ComparableProductsRWAdapter by inject { parametersOf(it,comparableProductsViewModel.firstProductId) }
            comparableProductsRW.adapter = rwAdapter
        }

        comparableProductsViewModel.showProgressBarLiveData.observe(this){
            showProgressBar(it)
        }

        backImg.setOnClickListener{
            finish()
        }

    }

    override fun comparableProductListened(id: String) {
        val intent = Intent(applicationContext,CompareActivity::class.java).apply {
            putExtra("main_product_id",comparableProductsViewModel.firstProductId)
            putExtra("second_product_id",id)
        }
        startActivity(intent)
    }


}