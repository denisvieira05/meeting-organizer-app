package org.js.denisvieira.meeting_organizer

import org.js.denisvieira.meeting_organizer.services.authentication.AuthApiDataSource
import org.js.denisvieira.meeting_organizer.services.authentication.FakeAuthRemoteDataSource

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InjectionApiDataSource {

    private fun buildFakeRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun provideAuthApiDataSource(): AuthApiDataSource {
        return FakeAuthRemoteDataSource(buildFakeRetrofit())
    }

}
