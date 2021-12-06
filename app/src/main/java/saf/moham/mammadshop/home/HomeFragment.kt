package saf.moham.mammadshop.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import org.koin.androidx.viewmodel.ext.android.viewModel
import saf.moham.mammadshop.R
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

        homeViewModel.bannerLiveData.observe(viewLifecycleOwner){
            val sliderFragmentAdapter = SliderFragmentAdapter(this,it)
            viewPager.adapter=sliderFragmentAdapter
            dots_indicator.setViewPager2(viewPager)
        }
        homeViewModel.showProgressBarLiveData.observe(viewLifecycleOwner){
            showProgressBar(it)
        }

    }

}