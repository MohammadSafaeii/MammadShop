package saf.moham.mammadshop.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.facebook.drawee.view.SimpleDraweeView
import org.koin.android.ext.android.inject
import saf.moham.mammadshop.R
import saf.moham.mammadshop.data.Banner
import saf.moham.mammadshop.utilities.ImageLoading


private const val BANNER = "imageUrl"

class SliderFragment : Fragment() {
    val imageLoading: ImageLoading by inject()
    private var banner: Banner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            banner = it.getParcelable(BANNER)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_slider, container, false)
        banner?.let { imageLoading.loadPicture(view as SimpleDraweeView, it.pic) }
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(banner: Banner) =
            SliderFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(BANNER, banner)
                }
            }
    }
}