package br.com.richardfelix.imdbrichard.adapters.movies

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.richardfelix.imdbrichard.R
import br.com.richardfelix.imdbrichard.service.model.entity.MovieEntity

class MovieViewHolder(itemView: View, onMovieClickListener: OnMovieClickListener) :
    RecyclerView.ViewHolder(itemView), View.OnClickListener {

    val cardMovie: CardView
    val imagePoster: AppCompatImageView
    val textTitle: AppCompatTextView

    val onMovieClickListener: OnMovieClickListener

    init {
        cardMovie = itemView.findViewById(R.id.cardMovie)
        imagePoster = itemView.findViewById(R.id.imagePoster)
        textTitle = itemView.findViewById(R.id.textTitle)
        this.onMovieClickListener = onMovieClickListener

        cardMovie.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view != null) {
            if (view.id == R.id.cardMovie) {
                onMovieClickListener.onMovieCLick(view.tag as MovieEntity)
            }
        }
    }
}