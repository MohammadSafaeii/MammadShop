package saf.moham.mammadshop.classification

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import saf.moham.mammadshop.R
import saf.moham.mammadshop.data.CatProduct
import saf.moham.mammadshop.utilities.ImageLoading

class ClassificationRWAdapter(val cats:List<CatProduct>, val imageLoading: ImageLoading): RecyclerView.Adapter<ClassificationRWAdapter.ClassificationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassificationViewHolder {
        return ClassificationViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.classification_rw, parent, false))
    }

    override fun onBindViewHolder(holder: ClassificationViewHolder, position: Int) {
        val item = cats[position]
        imageLoading.loadPicture(holder.imgCat, item.image)
        holder.txtCatTitle.text = item.title
        holder.txtCatCount.text = item.count + " کالا"
    }

    override fun getItemCount() = cats.size

    class ClassificationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imgCat = itemView.findViewById<SimpleDraweeView>(R.id.classification_img)
        val txtCatTitle = itemView.findViewById<TextView>(R.id.classification_txt_title)
        val txtCatCount = itemView.findViewById<TextView>(R.id.classification_txt_count)
    }

}