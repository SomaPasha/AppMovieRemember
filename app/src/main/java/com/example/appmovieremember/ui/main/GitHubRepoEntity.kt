package com.example.appmovieremember.ui.main

import com.google.gson.annotations.SerializedName

data class GitHubRepoEntity(
    @SerializedName("id")
    val id:Long,
    @SerializedName("full_name")
    val full_name: String,
    @SerializedName("language")
    val language: String
)