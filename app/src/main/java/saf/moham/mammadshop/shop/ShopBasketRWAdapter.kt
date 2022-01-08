package saf.moham.mammadshop.shop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import saf.moham.mammadshop.R
import saf.moham.mammadshop.data.ShopResponse
import saf.moham.mammadshop.utilities.ImageLoading
import saf.moham.mammadshop.utilities.currencyFormat
import saf.moham.mammadshop.utilities.setPersianNumbers

class ShopBasketRWAdapter(val shopBasket:ShopResponse, val imageLoading: ImageLoading): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var shopItemClickListener: ShopItemClickListener?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0)
            ShopLastItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.shop_last_item_rw, parent, false))
        else
            ShopItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.shop_item_rw, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == 0){
            val price = setPersianNumbers(currencyFormat(shopBasket.totalPrice.toString()))
            (holder as ShopLastItemViewHolder).txtPrice.text = "$price تومان"
            holder.txtPriceTotal.text = "$price تومان"
            holder.txtCount.text = "${shopBasket.message.size} کالا "
        }else{
            val item = shopBasket.message[position]
            val price = setPersianNumbers(currencyFormat((item.price.toInt()*item.count.toInt()).toString()))

            if (item.count.toInt() <= 1){
                (holder as ShopItemViewHolder).imgDecrease.setImageResource(R.drawable.ic_baseline_delete_outline_24)
            }

            (holder as ShopItemViewHolder).txtTitleProduct.text = item.title
            holder.txtPriceProduct.text = "$price تومان"
            holder.txtCountProduct.text = item.count
            imageLoading.loadPicture(holder.imgProduct,item.image)

            holder.txtCountProduct.visibility = View.VISIBLE
            holder.progressbar.visibility = View.GONE

            holder.txtDeleteProduct.setOnClickListener {
                shopItemClickListener?.deleteItemClickListened(item.product_id)
            }

            holder.imgIncrease.setOnClickListener {
                holder.txtCountProduct.visibility = View.INVISIBLE
                holder.progressbar.visibility = View.VISIBLE
                val increaseCount = item.count.toInt()+1
                shopItemClickListener?.changeItemCount(item.product_id, increaseCount)
            }

            holder.imgDecrease.setOnClickListener {
                holder.txtCountProduct.visibility = View.INVISIBLE
                holder.progressbar.visibility = View.VISIBLE
                val decreaseCount = item.count.toInt()-1
                shopItemClickListener?.changeItemCount(item.product_id, decreaseCount)
            }

            holder.itemView.setOnClickListener {

            }

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
        val txtDeleteProduct = itemView.findViewById<TextView>(R.id.shop_item_delete_product)
        val imgIncrease = itemView.findViewById<ImageView>(R.id.shop_item_increase)
        val imgDecrease = itemView.findViewById<ImageView>(R.id.shop_item_decrease)
        val progressbar = itemView.findViewById<ProgressBar>(R.id.shop_item_progressBar)
    }

    class ShopLastItemViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val txtPrice = itemView.findViewById<TextView>(R.id.shop_last_item_price)
        val txtPriceTotal = itemView.findViewById<TextView>(R.id.shop_last_item_total_price)
        val txtCount = itemView.findViewById<TextView>(R.id.shop_last_item_count)
    }

    fun setShopItemListener(shopItemClickListener: ShopItemClickListener){
        this.shopItemClickListener = shopItemClickListener
    }

    interface ShopItemClickListener{
        fun deleteItemClickListened(id: String)
        fun changeItemCount(id: String, count: Int)
    }

}