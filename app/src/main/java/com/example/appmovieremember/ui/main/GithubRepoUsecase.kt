package com.example.appmovieremember.ui.main

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

interface GithubRepoUsecase {
    @WorkerThread
    fun getReposForUserSync(userName:String):List<GitHubRepoEntity>
        fun getReposForUser(userName: String):LiveData<List<GitHubRepoEntity>>
    fun getReposForUserAsync(userName:String, callback: () -> Unit)

}