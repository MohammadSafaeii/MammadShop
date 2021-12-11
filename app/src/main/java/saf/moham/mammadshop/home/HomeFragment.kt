package saf.moham.mammadshop.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import saf.moham.mammadshop.R
import saf.moham.mammadshop.home.adapter.AmazingProductRWAdapter
import saf.moham.mammadshop.home.adapter.CatRWAdapter
import saf.moham.mammadshop.home.adapter.SliderFragmentAdapter
import saf.moham.mammadshop.utilities.MyFragment

class HomeFragment : MyFragment() {
    val homeViewModel:HomeViewModel by viewModel()
    // val homeViewModel = HomeViewModel (BannerRepositoryImp(LocalBannerDataSource(), RemoteBannerDataSource()))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager = view.findViewById<ViewPager2>(R.id.homeViewPager)
        val dots_indicator=view.findViewById<DotsIndicator>(R.id.dots_indicator)
        val catsRecyclerView=view.findViewById<RecyclerView>(R.id.rv_home_cat)
        val amazingProductsRecyclerView=view.findViewById<RecyclerView>(R.id.rv_home_amazingProduct)
        catsRecyclerView.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        amazingProductsRecyclerView.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

        homeViewModel.bannerLiveData.observe(viewLifecycleOwner){
            val sliderFragmentAdapter = SliderFragmentAdapter(this,it)
            viewPager.adapter=sliderFragmentAdapter
            dots_indicator.setViewPager2(viewPager)
        }
        homeViewModel.catLiveData.observe(viewLifecycleOwner){
            val rwAdapter:CatRWAdapter by inject { parametersOf(it) }
            catsRecyclerView.adapter=rwAdapter
        }
        homeViewModel.amazingProductLiveData.observe(viewLifecycleOwner){
            val rwAdapter:AmazingProductRWAdapter by inject { parametersOf(it) }
            amazingProductsRecyclerView.adapter=rwAdapter
        }
        homeViewModel.showProgressBarLiveData.observe(viewLifecycleOwner){
            showProgressBar(it)
        }


    }

}