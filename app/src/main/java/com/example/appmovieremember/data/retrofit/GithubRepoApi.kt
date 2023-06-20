package com.example.appmovieremember.data.retrofit

import androidx.lifecycle.LiveData
import com.example.appmovieremember.ui.main.GitHubRepoEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubRepoApi {
    @GET("users/{user}/repos")
   fun loadReposByUser(@Path("user") userName: String): Call<List<GitHubRepoEntity>>
}