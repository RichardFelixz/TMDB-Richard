package br.com.richardfelix.imdbrichard.adapters.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.richardfelix.imdbrichard.R
import br.com.richardfelix.imdbrichard.service.model.entity.MovieEntity
import br.com.richardfelix.imdbrichard.service.repository.remote.TheMovieDatabaseService
import com.bumptech.glide.Glide

class MovieAdapter(
    private val listMovies: List<MovieEntity>,
    private val onMovieClickListener: OnMovieClickListener
) : RecyclerView.Adapter<MovieViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_list_movie, viewGroup, false)

        return MovieViewHolder(view, onMovieClickListener)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        holder.textTitle.text = listMovies[position].title
        Glide.with(holder.imagePoster.context)
            .load(TheMovieDatabaseService.BASE_IMAGE_PATH_500 + listMovies[position].posterPath)
            .into(holder.imagePoster)
        holder.cardMovie.tag = listMovies[position]
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

}