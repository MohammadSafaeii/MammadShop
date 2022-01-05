package saf.moham.mammadshop.shop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import org.w3c.dom.Text
import saf.moham.mammadshop.R
import saf.moham.mammadshop.data.ShopResponse
import saf.moham.mammadshop.utilities.ImageLoading

class ShopBasketRWAdapter(val shopBasket:ShopResponse, val imageLoading: ImageLoading): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0)
            ShopLastItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.shop_last_item_rw, parent, false))
        else
            ShopItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.shop_item_rw, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == 0){
            (holder as ShopLastItemViewHolder).txtPrice.text = shopBasket.totalPrice.toString()
            holder.txtPriceTotal.text = shopBasket.totalPrice.toString()
            holder.txtCount.text = "${shopBasket.message.size-1} کالا "
        }else{
            val item = shopBasket.message[position]
            (holder as ShopItemViewHolder).txtTitleProduct.text = item.title
            holder.txtPriceProduct.text = "قیمت: ${item.price}"
            holder.txtCountProduct.text = item.count
            imageLoading.loadPicture(holder.imgProduct,item.image)
        }
    }

    override fun getItemCount() = (shopBasket.message.size + 1)

    override fun getItemViewType(position: Int): Int {
        if (position == shopBasket.message.size)
            return 0
        else
            return 1
    }

    class ShopItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imgProduct = itemView.findViewById<SimpleDraweeView>(R.id.shop_item_img)
        val txtTitleProduct = itemView.findViewById<TextView>(R.id.shop_item_title)
        val txtPriceProduct = itemView.findViewById<TextView>(R.id.shop_item_price)
        val txtCountProduct = itemView.findViewById<TextView>(R.id.shop_item_count)
    }

    class ShopLastItemViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val txtPrice = itemView.findViewById<TextView>(R.id.shop_last_item_price)
        val txtPriceTotal = itemView.findViewById<TextView>(R.id.shop_last_item_total_price)
        val txtCount = itemView.findViewById<TextView>(R.id.shop_last_item_count)
    }

}