package com.studyfork.sfoide

import com.studyfork.sfoide.model.service.RandomPersonService
import org.junit.Assert
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitTest {
    @Test
    fun addition_isCorrect() {

//        val service: RandomPersonService
//        val retrofit = Retrofit.Builder()
//            .baseUrl(RandomPersonService.BASE_URL)
//            .addConverterFactory(MoshiConverterFactory.create())
//            .build()
//
//        service = retrofit.create(RandomPersonService::class.java)
//
//        service.fetchPersonInfo()



        val service: RandomPersonService
        val retrofit = Retrofit.Builder()
            .baseUrl(RandomPersonService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(RandomPersonService::class.java)
        val storeInfoCall = service.getRandomUsers(10).execute().body()?.let { respons ->
            Assert.assertEquals(4, respons.results.size)
        }


//        apiClient.getRandomUsers(USERS_COUNT).execute().body()?.let { response ->
//            val parsedResponse = parseResponse(response)
//            emitter.onSuccess(repeatedUsersChecker.removeDuplicatedUsers(parsedResponse))
//        }
//
//        val storeInfo: PersonInfo? =
//            storeInfoCall!!.execute().body()
//        Assert.assertEquals(4, storeInfo?.results?.size)

    }
}