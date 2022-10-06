package br.com.richardfelix.imdbrichard.adapters.cast

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.richardfelix.imdbrichard.R
import br.com.richardfelix.imdbrichard.service.model.entity.CastEntity
import br.com.richardfelix.imdbrichard.service.repository.remote.TheMovieDatabaseService
import com.bumptech.glide.Glide

class CastAdapter(private var listCast: List<CastEntity>) :
    RecyclerView.Adapter<CastViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CastViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_list_cast, viewGroup, false)
        return CastViewHolder(view)
    }

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        Glide.with(holder.imageProfile.context)
            .load(TheMovieDatabaseService.BASE_IMAGE_PATH_500 + listCast[position].profilePath)
            .into(holder.imageProfile)
        holder.textName.text =
            listCast[position].originalName + "(" + listCast[position].name + ")"
    }

    override fun getItemCount(): Int {
        return listCast.size
    }
}