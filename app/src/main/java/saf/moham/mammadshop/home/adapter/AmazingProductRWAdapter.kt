package saf.moham.mammadshop.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.producers.Producer
import saf.moham.mammadshop.R
import saf.moham.mammadshop.data.AmazingProduct
import saf.moham.mammadshop.utilities.ImageLoading



class AmazingProductRWAdapter(val amazingProducts:List<AmazingProduct>,val imageLoading: ImageLoading): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.amazing_product_home_rw_default,parent,false)
            AmazingProductViewHolderDefault(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.amazing_product_home_rw,parent,false)
            AmazingProductViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position)==0){
            (holder as AmazingProductViewHolderDefault).image.setImageResource(R.drawable.amzing_product_default_image)
        }else{
            val product=amazingProducts[position-1]
            imageLoading.loadPicture((holder as AmazingProductViewHolder).image,product.image)
            holder.price.text=product.price
            holder.prePrice.text=product.pprice
            holder.title.text=product.title
        }
    }

    override fun getItemCount() = (amazingProducts.size+1)


    override fun getItemViewType(position: Int): Int {
        return if(position==0){
            0
        }else
            1
    }


    class AmazingProductViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val image=itemView.findViewById<SimpleDraweeView>(R.id.amazingProduct_image_rw)
        val title=itemView.findViewById<TextView>(R.id.amazingProduct_title_rw)
        val price=itemView.findViewById<TextView>(R.id.amazingProduct_price_rw)
        val prePrice=itemView.findViewById<TextView>(R.id.amazingProduct_prePrice_rw)
    }

    class AmazingProductViewHolderDefault(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image=itemView.findViewById<ImageView>(R.id.amazingProduct_default_image_rw)
    }
}