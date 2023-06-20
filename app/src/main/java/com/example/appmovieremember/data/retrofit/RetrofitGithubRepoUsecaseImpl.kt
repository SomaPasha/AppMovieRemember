package com.example.appmovieremember.data.retrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.appmovieremember.ui.main.GitHubRepoEntity
import com.example.appmovieremember.ui.main.GithubRepoUsecase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.github.com/"
class RetrofitGithubRepoUsecaseImpl:GithubRepoUsecase {

  private  val retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
   private var api: GithubRepoApi = retrofit.create(GithubRepoApi::class.java)



    override fun getReposForUserSync(userName: String): List<GitHubRepoEntity> {
       var apii :List<GitHubRepoEntity> = emptyList()
        CoroutineScope(Dispatchers.IO).launch {
         apii=   api.loadReposByUser(userName)
                .execute()
                .body() ?: emptyList()
        }
        return apii





    }

    override fun getReposForUser(userName: String): LiveData<List<GitHubRepoEntity>> {
        val liveData:MutableLiveData<List<GitHubRepoEntity>> =MutableLiveData()
        api.loadReposByUser(userName).enqueue(object :Callback<List<GitHubRepoEntity>>{
            override fun onResponse(
                call: Call<List<GitHubRepoEntity>>,
                response: Response<List<GitHubRepoEntity>>
            ) {
                val body = response.body()
                if(response.isSuccessful && body!=null){
                    liveData.postValue(body)
                }
            }

            override fun onFailure(call: Call<List<GitHubRepoEntity>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
       return liveData
    }

    override fun getReposForUserAsync(
        userName: String,
        callback: () -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
        api.loadReposByUser(userName).enqueue(object :Callback<List<GitHubRepoEntity>>{
            override fun onResponse(
                call: Call<List<GitHubRepoEntity>>,
                response: Response<List<GitHubRepoEntity>>
            ) {
                callback ()
            }

            override fun onFailure(call: Call<List<GitHubRepoEntity>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        }
    }
}


