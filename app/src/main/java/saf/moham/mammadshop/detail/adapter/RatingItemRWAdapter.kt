package saf.moham.mammadshop.detail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar
import saf.moham.mammadshop.R
import saf.moham.mammadshop.data.RatingItem

class RatingItemRWAdapter(val ratings:List<RatingItem>): RecyclerView.Adapter<RatingItemRWAdapter.RatingItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatingItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rating_item,parent,false)
        return RatingItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: RatingItemViewHolder, position: Int) {
        val item = ratings[position]
        holder.txtTitle.text=item.title
        holder.ratingBar.progress = item.value.toFloat()
    }

    override fun getItemCount() = ratings.size

    class RatingItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtTitle = itemView.findViewById<TextView>(R.id.rating_bar_title)
        val ratingBar = itemView.findViewById<RoundCornerProgressBar>(R.id.rating_bar)
    }

}