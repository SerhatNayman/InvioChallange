package com.serosoft.inviochallange.data.remote

import com.serosoft.inviochallange.data.entity.Search
import com.serosoft.inviochallange.utils.API_KEY
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {

    @GET("/")
    fun getAllMovies(
        @Query("i") movieId: String,
        @Query("token") token: String = API_KEY
    ): Call<Search>

    @GET("/")
    fun getSearchMovie(
        @Query("q") query: String? = null,
        @Query("token") token: String = API_KEY
    ): Call<Search>

    @GET("/{t}{apikey}")
    suspend fun getMovie(
        @Path("t") title: String,
        @Path("apikey") apikey: String = API_KEY
    ): Response<Search>
}