package br.com.richardfelix.imdbrichard.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.richardfelix.imdbrichard.service.model.entity.CastEntity
import br.com.richardfelix.imdbrichard.service.model.entity.MovieEntity
import br.com.richardfelix.imdbrichard.service.repository.remote.TheMovieDatabaseService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val theMovieDatabaseService: TheMovieDatabaseService) : ViewModel() {

    private val _popularMovies = MutableLiveData<List<MovieEntity>>()
    val popularMovies: LiveData<List<MovieEntity>> get() = _popularMovies

    private val _popularMoviesErrorResponse = MutableLiveData<String>()
    val popularMoviesErrorResponse: LiveData<String?> get() = _popularMoviesErrorResponse

    private val _cast = MutableLiveData<List<CastEntity>>()
    val cast: LiveData<List<CastEntity>> get() = _cast

    fun callPopularMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = theMovieDatabaseService.getPopularMovies()
            if (response.isSuccessful) {
                _popularMovies.postValue(response.body()?.popularMovie)
            } else {
                _popularMoviesErrorResponse.postValue(response.errorBody()?.string())
            }
        }
    }

    fun callCastOfMovie(movieId: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = theMovieDatabaseService.getCastOfMovie(movieId)
            if (response.isSuccessful) {
                _cast.postValue(response.body()?.entireCast)
            } else {
                _popularMoviesErrorResponse.postValue(response.errorBody()?.string())
            }
        }
    }
}