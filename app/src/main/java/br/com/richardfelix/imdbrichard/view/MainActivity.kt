package br.com.richardfelix.imdbrichard.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.richardfelix.imdbrichard.adapters.movies.MovieAdapter
import br.com.richardfelix.imdbrichard.adapters.movies.OnMovieClickListener
import br.com.richardfelix.imdbrichard.databinding.ActivityMainBinding
import br.com.richardfelix.imdbrichard.service.model.entity.MovieEntity
import br.com.richardfelix.imdbrichard.view_model.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), OnMovieClickListener {

    private val viewModel: MainViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding
    private lateinit var popUpCastFragment: PopUpCastFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observe()

        viewModel.callPopularMovies()
    }

    override fun onMovieCLick(movie: MovieEntity) {
        showCastBottomSheetDialog(movie.title, movie.voteAvarege)
        viewModel.callCastOfMovie(movie.id)
    }

    private fun loadRecyclerView(listMovie: List<MovieEntity>) {
        binding.rvMovies.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvMovies.adapter = MovieAdapter(listMovie, this)
    }

    private fun observe() {
        viewModel.popularMovies.observe(this) {
            if (it.isNotEmpty()) {
                loadRecyclerView(it)
            }
        }

        viewModel.popularMoviesErrorResponse.observe(this) {
            if (it != null) {
                if (it.isNotEmpty()) {
                    Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
                }
            }
        }

        viewModel.cast.observe(this) {
            if (it.isNotEmpty()) {
                popUpCastFragment.loadRecyclerView(it)
            }
        }
    }

    private fun showCastBottomSheetDialog(movieTitle: String, voteAvarege: Double) {
        popUpCastFragment = PopUpCastFragment(movieTitle, voteAvarege)
        popUpCastFragment.show(supportFragmentManager, popUpCastFragment.tag)
    }
}