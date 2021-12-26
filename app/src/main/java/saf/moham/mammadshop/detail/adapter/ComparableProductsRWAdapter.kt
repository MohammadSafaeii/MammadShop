package saf.moham.mammadshop.detail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import saf.moham.mammadshop.R
import saf.moham.mammadshop.data.ComparableProductData
import saf.moham.mammadshop.utilities.ImageLoading

class ComparableProductsRWAdapter(val comparableProducts:List<ComparableProductData>, val id:String, val imageLoading: ImageLoading): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var onComparableProductListener:OnComparableProductListener?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType==0){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.null_view,parent,false)
            nullViewHolder(view)
        }else{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.comparable_product_rw,parent,false)
            ComparableProductsViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = comparableProducts[position]
        if (getItemViewType(position)==0){
        }else{
            (holder as ComparableProductsViewHolder).txtTitle.text=item.title
            holder.txtPrice.text=item.price
            imageLoading.loadPicture(holder.image,item.image)
            holder.itemView.setOnClickListener {
                onComparableProductListener?.comparableProductListened(item.id)
            }
        }
    }

    override fun getItemCount() = comparableProducts.size

    override fun getItemViewType(position: Int): Int {
        if (comparableProducts[position].id==id)
            return 0
        else
            return 1
    }

    class ComparableProductsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image = itemView.findViewById<SimpleDraweeView>(R.id.comparable_product_image)
        val txtTitle = itemView.findViewById<TextView>(R.id.comparable_product_title)
        val txtPrice = itemView.findViewById<TextView>(R.id.comparable_product_price)
    }
    class nullViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    }

    interface OnComparableProductListener{
        fun comparableProductListened(id:String)
    }

    fun setComparableProductListener(onComparableProductListener: OnComparableProductListener){
        this.onComparableProductListener=onComparableProductListener
    }

}