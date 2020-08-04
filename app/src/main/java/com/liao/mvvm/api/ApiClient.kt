package com.liao.mvvm.api

import com.liao.mvvm.app.Config.Companion.BASE_URL
import com.liao.mvvm.model.GithubRepository
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object ApiClient {
    private val _endpoint: EndPoint by lazy {
        val client = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        client.create(EndPoint::class.java)
    }

    fun getApiEndPoint(): EndPoint = _endpoint

}


interface EndPoint {

    @GET("repositories?language=&since=daily&spoken_language_code=")
    fun getRepositories(): Call<List<GithubRepository>>
}