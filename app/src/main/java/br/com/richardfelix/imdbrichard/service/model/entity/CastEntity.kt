package br.com.richardfelix.imdbrichard.service.model.entity

import com.google.gson.annotations.SerializedName

data class CastEntity(
    val id: Long,
    val name: String,
    @SerializedName("original_name")
    val originalName: String,
    @SerializedName("profile_path")
    val profilePath: String,
)


