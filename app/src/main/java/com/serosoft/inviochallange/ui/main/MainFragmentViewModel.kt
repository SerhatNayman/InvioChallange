package com.serosoft.inviochallange.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serosoft.inviochallange.data.entity.Movie
import com.serosoft.inviochallange.data.entity.Search
import com.serosoft.inviochallange.data.repo.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(
    var movieRepository: MovieRepository
) :
    ViewModel() {
    var movieResponse: MutableLiveData<Response<Search>> = MutableLiveData()

    fun getMovie(title: String, apikey: String) {
        viewModelScope.launch {
            val response = movieRepository.getMovie(title, apikey)
            movieResponse.value = response

        }

    }

}