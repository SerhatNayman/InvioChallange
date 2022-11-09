package com.serosoft.inviochallange.data.repo

import androidx.lifecycle.MutableLiveData
import com.serosoft.inviochallange.data.entity.Movie
import com.serosoft.inviochallange.data.entity.Search
import com.serosoft.inviochallange.data.remote.MovieApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository(private var movieApiService: MovieApiService) {


    suspend fun getMovie(title: String, apikey: String): Response<Search> {
        return movieApiService.getMovie(title, apikey)
    }


}