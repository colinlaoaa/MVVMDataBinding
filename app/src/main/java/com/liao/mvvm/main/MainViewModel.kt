package com.liao.mvvm.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder
import com.liao.mvvm.api.ApiClient
import com.liao.mvvm.app.Endpoints
import com.liao.mvvm.model.APIResponse

//class MainViewModel(application: Application) : AndroidViewModel(application) {
//    val textObserver = MutableLiveData<String>()
//
//    fun onButtonClicked(){
//        APICall()
//
//    }
//
//    private fun APICall(){
//        var requestQueue = Volley.newRequestQueue(getApplication())
//        var request = StringRequest(Request.Method.GET, Endpoints.getAPIData("",""), Response.Listener {
//
//            var gson = GsonBuilder().create()
//            var newResponse = gson.fromJson(it, APIResponse::class.java)
//            waitSeconds(2,newResponse[0].author)
//
//        }, Response.ErrorListener {
//
//        })
//
//        requestQueue.add(request)
//    }
//
//    private fun waitSeconds(sec:Int,value:String){
//        Thread{
//            Thread.sleep((sec*1000).toLong())
//            updateUI(value)
//        }.start()
//    }
//
//    private fun updateUI(value:String){
//        textObserver.postValue(value)
//    }
//}

class MainViewModel : ViewModel() {
    //Business logic
    private val mainRepository = MainRepository(ApiClient.getApiEndPoint())


    fun getGithubRepositoryObserver() = mainRepository.listGithubRepository


    fun onButtonClicked() {
        mainRepository.getDataFromApi()
    }



    override fun onCleared() {
        super.onCleared()
        Log.e("MainViewModel", "Destroyed")
    }
}