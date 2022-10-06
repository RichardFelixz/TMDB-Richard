package br.com.richardfelix.imdbrichard.service.model.response

import br.com.richardfelix.imdbrichard.service.model.entity.MovieEntity
import com.google.gson.annotations.SerializedName

data class PopularMovieResponse(
    @SerializedName("results")
    val popularMovie: List<MovieEntity>
)
