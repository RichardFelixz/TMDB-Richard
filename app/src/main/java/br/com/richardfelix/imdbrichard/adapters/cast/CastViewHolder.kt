package br.com.richardfelix.imdbrichard.adapters.cast

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.richardfelix.imdbrichard.R

class CastViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    val cardMovie: CardView
    val imageProfile: AppCompatImageView
    val textName: AppCompatTextView

    init {
        cardMovie = itemView.findViewById(R.id.cardCast)
        imageProfile = itemView.findViewById(R.id.imageProfile)
        textName = itemView.findViewById(R.id.textName)
    }
}