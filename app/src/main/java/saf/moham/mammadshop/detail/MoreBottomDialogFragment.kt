package saf.moham.mammadshop.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import saf.moham.mammadshop.R
import saf.moham.mammadshop.utilities.COMPARE
import saf.moham.mammadshop.utilities.GRAPH
import saf.moham.mammadshop.utilities.SHARE

class MoreBottomDialogFragment:BottomSheetDialogFragment() {
    lateinit var bottomDialogItemClicked:BottomDialogItemClicked
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.more_bottom_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val txtGraph=view.findViewById<TextView>(R.id.txt_graph)
        val txtCompare=view.findViewById<TextView>(R.id.txt_compare)
        val txtShare=view.findViewById<TextView>(R.id.txt_share)

        txtGraph.setOnClickListener{
            bottomDialogItemClicked.itemClicked(GRAPH)
            dismiss()
        }
        txtCompare.setOnClickListener{
            bottomDialogItemClicked.itemClicked(COMPARE)
            dismiss()
        }
        txtShare.setOnClickListener{
            bottomDialogItemClicked.itemClicked(SHARE)
            dismiss()
        }

    }

    fun setItemClickListener(bottomDialogItemClicked: BottomDialogItemClicked){
        this.bottomDialogItemClicked=bottomDialogItemClicked
    }

    interface BottomDialogItemClicked{
        fun itemClicked (type:String)
    }

}