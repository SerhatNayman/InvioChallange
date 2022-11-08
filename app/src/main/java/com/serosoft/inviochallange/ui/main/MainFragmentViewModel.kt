package com.serosoft.inviochallange.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.serosoft.inviochallange.data.entity.Movie
import com.serosoft.inviochallange.data.repo.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(
    var movieRepository: MovieRepository) :
    ViewModel() {
    var movieList = MutableLiveData<List<Movie>>()


    init {
        getMovie("","")
        getSearchMovie("")
        movieList = movieRepository.getAllMovies()

    }


    private fun getMovie(i: String, token: String) {
        movieRepository.getMovie(i, token)
    }

    private fun getSearchMovie(query:String){
        movieRepository.getSearchMovie(query)

    }
}