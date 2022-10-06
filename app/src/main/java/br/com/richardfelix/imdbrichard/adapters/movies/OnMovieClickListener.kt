package br.com.richardfelix.imdbrichard.adapters.movies

import br.com.richardfelix.imdbrichard.service.model.entity.MovieEntity

interface OnMovieClickListener {

    fun onMovieCLick(movie: MovieEntity)
}