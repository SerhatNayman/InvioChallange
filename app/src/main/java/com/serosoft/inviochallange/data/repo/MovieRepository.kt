package com.serosoft.inviochallange.data.repo

import androidx.lifecycle.MutableLiveData
import com.serosoft.inviochallange.data.entity.Movie
import com.serosoft.inviochallange.data.entity.Search
import com.serosoft.inviochallange.data.remote.MovieApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository(private var movieApiService: MovieApiService) {

    val movieList = MutableLiveData<List<Movie>>()

    fun getAllMovies(): MutableLiveData<List<Movie>> {
        return movieList
    }


    fun getMovie(i: String, token: String) {
        movieApiService.getAllMovies(i, token).enqueue(object : Callback<Search> {
            override fun onResponse(call: Call<Search>, response: Response<Search>) {
                response.body()?.resultSearch?.let { list ->
                    movieList.value = list
                }
            }

            override fun onFailure(call: Call<Search>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun getSearchMovie(query: String) {
        movieApiService.getSearchMovie(query).enqueue(object : Callback<Search> {

            override fun onResponse(call: Call<Search>, response: Response<Search>) {
                val allSearch = response.body()?.resultSearch
                allSearch?.let {
                    for (movie in allSearch) {
                        if (movie.title != null && movie.poster != null) {
                            movieList.value = response.body()
                        }
                    }
                }
            }

            override fun onFailure(call: Call<Search>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}