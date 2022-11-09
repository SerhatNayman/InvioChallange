package com.serosoft.inviochallange.data.entity

import com.google.gson.annotations.SerializedName

data class Search(
    @SerializedName("Search")
    val resultSearch: List<Movie>
    )
