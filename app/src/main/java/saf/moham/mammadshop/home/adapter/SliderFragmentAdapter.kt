package saf.moham.mammadshop.home.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import saf.moham.mammadshop.data.Banner
import saf.moham.mammadshop.home.SliderFragment

class SliderFragmentAdapter(fragment: Fragment, private val banners:List<Banner>):FragmentStateAdapter(fragment) {
    override fun getItemCount() = banners.size

    override fun createFragment(position: Int) = SliderFragment.newInstance(banners[position])
}