package saf.moham.mammadshop.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        homeViewModel.bannerLiveData.observe(viewLifecycleOwner){
            Log.i("MYLOG", "onViewCreated: +$it")
        }
        homeViewModel.showProgressBarLiveData.observe(viewLifecycleOwner){
            showProgressBar(it)
        }

    }

}