package com.liao.mvvm.main

import androidx.lifecycle.MutableLiveData
import com.liao.mvvm.api.EndPoint
import com.liao.mvvm.model.GithubRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository(private val endPoint: EndPoint) {

    val listGithubRepository: MutableLiveData<List<GithubRepository>?> by lazy {
        MutableLiveData<List<GithubRepository>?>()
    }

    /**
     * This method is used to get data from API
     */
    fun getDataFromApi() {
        endPoint.getRepositories().enqueue(object : Callback<List<GithubRepository>> {
            override fun onFailure(call: Call<List<GithubRepository>>, t: Throwable) {
                listGithubRepository.postValue(null)
            }

            override fun onResponse(
                call: Call<List<GithubRepository>>,
                response: Response<List<GithubRepository>>
            ) {
                val list = response.body()
                listGithubRepository.postValue(list)
            }
        })
    }
}