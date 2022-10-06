package br.com.richardfelix.imdbrichard.service.model.response

import br.com.richardfelix.imdbrichard.service.model.entity.CastEntity
import com.google.gson.annotations.SerializedName

data class CastResponse(
    @SerializedName("cast")
    val entireCast: List<CastEntity>
)
