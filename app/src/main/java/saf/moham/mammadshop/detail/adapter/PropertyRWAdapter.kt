package saf.moham.mammadshop.detail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import saf.moham.mammadshop.R
import saf.moham.mammadshop.data.Property

class PropertyRWAdapter(val properties:List<Property>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType==0){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.property_title,parent,false)
            PropertyTitleViewHolder(view)
        }else{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.property_detail,parent,false)
            PropertyDetailViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = properties[position]
        if (getItemViewType(position)==0){
            (holder as PropertyTitleViewHolder).txtTitle.text=item.title
        }else{
            (holder as PropertyDetailViewHolder).txtTitle.text=item.title
            holder.txtDetail.text=item.value
        }
    }

    override fun getItemCount()=properties.size

    override fun getItemViewType(position: Int): Int {
        return if (properties[position].value=="")
            0
        else
            1
    }

    class PropertyTitleViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val txtTitle=itemView.findViewById<TextView>(R.id.property_title_title)
    }

    class PropertyDetailViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val txtTitle=itemView.findViewById<TextView>(R.id.property_detail_title)
        val txtDetail=itemView.findViewById<TextView>(R.id.property_detail_detail)
    }

}