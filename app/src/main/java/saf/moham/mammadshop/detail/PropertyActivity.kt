package saf.moham.mammadshop.detail

import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import saf.moham.mammadshop.R
import saf.moham.mammadshop.detail.adapter.PropertyRWAdapter
import saf.moham.mammadshop.detail.viewModel.PropertyViewModel
import saf.moham.mammadshop.utilities.MyActivity

class PropertyActivity : MyActivity() {
    val propertyViewModel: PropertyViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property)

        val propertyRecyclerView=findViewById<RecyclerView>(R.id.rw_properties)
        val backImg=findViewById<ImageView>(R.id.go_back_img)
        propertyRecyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        propertyViewModel.propertiesLiveData.observe(this){
            val rwAdapter: PropertyRWAdapter by inject { parametersOf(it) }
            propertyRecyclerView.adapter=rwAdapter
        }

        propertyViewModel.showProgressBarLiveData.observe(this){
            showProgressBar(it)
        }

        backImg.setOnClickListener{
            finish()
        }

    }
}