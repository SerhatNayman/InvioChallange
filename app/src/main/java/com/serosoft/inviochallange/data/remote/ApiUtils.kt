package com.serosoft.inviochallange.data.remote

import com.serosoft.inviochallange.utils.BASE_URL

class ApiUtils {
    companion object {
        fun getMovieApiService(): MovieApiService {
            return RetrofitClient.getClient(BASE_URL).create(MovieApiService::class.java)
        }

    }
}