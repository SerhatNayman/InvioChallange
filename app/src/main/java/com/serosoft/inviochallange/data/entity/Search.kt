package com.serosoft.inviochallange.data.entity

import com.google.gson.annotations.SerializedName

abstract class Search(
    @SerializedName("Search")
    val resultSearch: List<Movie>, override val size: Int
) : List<Movie>
