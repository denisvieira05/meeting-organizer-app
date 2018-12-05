package org.js.denisvieira.meeting_organizer.application.injections

import org.js.denisvieira.meeting_organizer.BuildConfig
import org.js.denisvieira.meeting_organizer.services.ApiDataSource
import org.js.denisvieira.meeting_organizer.services.authentication.AuthApiDataSource

object InjectionApiDataSourceMain {

    private fun provideApiDataSource(): ApiDataSource {
        val baseUrl = BuildConfig.BASE_URL
        return ApiDataSource.getInstance(baseUrl)
    }

    fun provideAuthApiDataSource(): AuthApiDataSource {
        return provideApiDataSource().createService(AuthApiDataSource::class.java)
    }
}
