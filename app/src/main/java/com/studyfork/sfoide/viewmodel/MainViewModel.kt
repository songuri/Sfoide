package com.studyfork.sfoide.viewmodel

import Results
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.studyfork.sfoide.model.service.RandomPersonService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class MainViewModel: ViewModel() {

    val itemLiveData = MutableLiveData<List<Results>>()
    val loadingLiveData = MutableLiveData<Boolean>()

    private val service: RandomPersonService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(RandomPersonService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(RandomPersonService::class.java)
        fetchStoreInfo()
    }


    fun fetchStoreInfo() {
        loadingLiveData.value = true
        /**
         * 자바의 쓰레드를 대체하는것?
         */
        viewModelScope.launch {
            val personInfo = service.getRandomUsers(10)
            itemLiveData.value = personInfo.results
            loadingLiveData.value = false
        }
    }
}