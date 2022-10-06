package br.com.richardfelix.imdbrichard.service.model.entity

import com.google.gson.annotations.SerializedName

data class MovieEntity(
    val id: Long,
    val title: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("vote_average")
    val voteAvarege: Double
)


