package saf.moham.mammadshop.classification

import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import saf.moham.mammadshop.R
import saf.moham.mammadshop.utilities.MyFragment

class ClassificationFragment : MyFragment() {
    val classificationViewModel: ClassificationViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_classification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val parent = view.findViewById<LinearLayout>(R.id.classification_linearLayout)

        classificationViewModel.classificationLiveData.observe(viewLifecycleOwner){
            for (item in it){
                val recyclerView = RecyclerView(requireContext())
                val txtTitle = TextView(requireContext())
                txtTitle.text = item.cat
                txtTitle.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
                txtTitle.textSize = 16f

                //val myFont: Typeface? = ResourcesCompat.getFont(requireContext(),R.font.primary_bold)
                //txtTitle.typeface = myFont

                val paddingDp=8
                val topPadding=4
                val density=requireContext().resources.displayMetrics.density
                val paddingPixel=(paddingDp*density).toInt()
                val topPaddingPixel=(topPadding*density).toInt()
                txtTitle.setPadding(0,topPaddingPixel,paddingPixel,0)


                recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
                val classificationRWAdapter: ClassificationRWAdapter by inject { parametersOf(item.catProducts) }
                recyclerView.adapter = classificationRWAdapter

                parent.addView(txtTitle)
                parent.addView(recyclerView)
            }
        }

        classificationViewModel.showProgressBarLiveData.observe(viewLifecycleOwner){
            showProgressBar(it)
        }

    }

}