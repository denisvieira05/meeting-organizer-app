package org.js.denisvieira.meeting_organizer.services

import com.google.gson.Gson

import java.util.concurrent.TimeUnit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiDataSource constructor(private val mBaseUrl: String) {

    companion object {

        private val PER_PAGE = 200
        private var INSTANCE: ApiDataSource? = null

        /**
         * Returns the single instance of this class, creating it if necessary.
         *
         * @param baseUrl the url to get remote data source
         * @return the [ApiDataSource] instance
         */
        fun getInstance(baseUrl: String): ApiDataSource {
            if (INSTANCE == null)
                INSTANCE = ApiDataSource(baseUrl)

            return INSTANCE as ApiDataSource
        }
    }

    val perPage: Int?
        get() = PER_PAGE

    fun <S> createService(serviceClass: Class<S>): S {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
                .readTimeout(15, TimeUnit.SECONDS)

        httpClient.addInterceptor(loggingInterceptor)

        val retrofit = Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .client(httpClient.build())
                .build()

        return retrofit.create(serviceClass)
    }




}
