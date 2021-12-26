package saf.moham.mammadshop.detail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import saf.moham.mammadshop.R
import saf.moham.mammadshop.data.Property

class CompareRWAdapter(val mainProductProperties:List<Property>,val secondProductProperty:List<Property>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType==0){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.property_title,parent,false)
            return mainTitlePropertyViewHolder(view)
        }else{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.compare_detail_rw,parent,false)
            return detailPropertyViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mainItem = mainProductProperties[position]
        val secondItem = secondProductProperty[position]

        if (getItemViewType(position)==0){
            (holder as mainTitlePropertyViewHolder).txtTitle.text=mainItem.title
        }else{
            (holder as detailPropertyViewHolder).txtMainProduct.text="${mainItem.title} : ${mainItem.value}"
            holder.txtSecondProduct.text="${secondItem.title} : ${secondItem.value}"
        }
    }

    override fun getItemCount() = mainProductProperties.size

    override fun getItemViewType(position: Int): Int {
        if (mainProductProperties[position].value==""){
            return 0
        }else{
            return 1
        }
    }

    class detailPropertyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val txtMainProduct = itemView.findViewById<TextView>(R.id.compare_main_product)
        val txtSecondProduct = itemView.findViewById<TextView>(R.id.compare_second_product)
    }

    class mainTitlePropertyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val txtTitle = itemView.findViewById<TextView>(R.id.property_title_title)
    }


}