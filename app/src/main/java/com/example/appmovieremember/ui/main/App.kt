package com.example.appmovieremember.ui.main

import android.app.Application
import android.content.Context
import com.example.appmovieremember.data.WebGithubRepoUsecaseImp
import com.example.appmovieremember.data.retrofit.RetrofitGithubRepoUsecaseImpl

class App:Application() {

    val githubRepoUsecase: GithubRepoUsecase by lazy { RetrofitGithubRepoUsecaseImpl()
    }


}
val Context.app
    get()= applicationContext as App