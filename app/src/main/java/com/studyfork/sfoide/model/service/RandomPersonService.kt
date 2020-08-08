package com.studyfork.sfoide.model.service

import Json4Kotlin_Base
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query



interface RandomPersonService {

    companion object {
        const val BASE_URL =
            "https://randomuser.me/"

        private const val KEY_NUMBER = "results"
        private const val KEY_FORMAT = "format"
    }

    @GET("api/")
    suspend fun getRandomUsers(@Query(KEY_NUMBER) numberOfUsers: Int,
                       @Query(KEY_FORMAT) responseFormat: String = "json"): Json4Kotlin_Base


}