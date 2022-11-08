package com.serosoft.inviochallange.di

import com.serosoft.inviochallange.data.remote.ApiUtils
import com.serosoft.inviochallange.data.remote.MovieApiService
import com.serosoft.inviochallange.data.repo.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideMovieApiService(): MovieApiService {
        return ApiUtils.getMovieApiService()
    }

     @Provides
     @Singleton
    fun provideMovieRepository(movieApiService: MovieApiService): MovieRepository {
        return MovieRepository(movieApiService)
    }
}