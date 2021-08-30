package ua.javabegin.examples.lesson3

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

//    @GET("books")
    @GET("events")
    suspend fun getBooksRetrofitService(): Book

    companion object { // Аналог static

        var retrofitService: RetrofitService? = null

        // Вызов статического метода getInstance будет так: RetrofitService.getInstance()
        fun getInstance(): RetrofitService {
            if(retrofitService == null) {
                var retrofit: Retrofit = Retrofit.Builder()
//                    .baseUrl("https://spring-boot-mysql-server-part0.herokuapp.com/api/")
                    .baseUrl("http://192.168.1.200:8050/ru/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }


}