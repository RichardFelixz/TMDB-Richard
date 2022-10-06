package br.com.richardfelix.imdbrichard.view

import android.app.Dialog
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.richardfelix.imdbrichard.adapters.cast.CastAdapter
import br.com.richardfelix.imdbrichard.databinding.PopupCastMovieBinding
import br.com.richardfelix.imdbrichard.service.model.entity.CastEntity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PopUpCastFragment(private val movieTitle: String, private val voteAvarege: Double) :
    BottomSheetDialogFragment() {

    private lateinit var binding: PopupCastMovieBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)

        binding = PopupCastMovieBinding.inflate(layoutInflater, null, false)
        dialog.setContentView(binding.root)

        loadHeader()

        return dialog
    }

    private fun loadHeader() {
        binding.textTitle.text = movieTitle
        binding.ratingMovie.rating = voteAvarege.toFloat()/2
    }

    fun loadRecyclerView(listCast: List<CastEntity>) {
        binding.rvCast.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvCast.adapter = CastAdapter(listCast)
    }
}