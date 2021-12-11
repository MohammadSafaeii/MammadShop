package saf.moham.mammadshop.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import saf.moham.mammadshop.R
import saf.moham.mammadshop.data.Cat
import saf.moham.mammadshop.utilities.ImageLoading

class CatRWAdapter(val cats:List<Cat>, val imageLoading: ImageLoading):RecyclerView.Adapter<CatRWAdapter.CatViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cat_home_rw,parent,false)
        return CatViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        val item=cats[position]
        imageLoading.loadPicture(holder.imageView,item.position)
        holder.textView.text=item.title
    }

    override fun getItemCount() = cats.size

    class CatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<SimpleDraweeView>(R.id.cat_rw_image)
        val textView = itemView.findViewById<TextView>(R.id.cat_rw_title)
    }
}