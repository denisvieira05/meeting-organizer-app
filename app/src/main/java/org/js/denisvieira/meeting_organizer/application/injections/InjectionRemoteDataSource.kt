package org.js.denisvieira.meeting_organizer.application.injections

import android.content.Context
import org.js.denisvieira.meeting_organizer.InjectionApiDataSource
import org.js.denisvieira.meeting_organizer.services.authentication.AuthRemoteDataSource
import org.js.denisvieira.meeting_organizer.services.authentication.AuthRemoteDataSourceImpl

object InjectionRemoteDataSource {

    fun provideAuthRemoteDataSource(context: Context): AuthRemoteDataSource {
        val authApiDataSource      =  InjectionApiDataSource.provideAuthApiDataSource()
        val sessionLocalDataSource = InjectionLocalDataSource.provideSessionLgit ocalDataSource(context)

        return AuthRemoteDataSourceImpl.getInstance(authApiDataSource, sessionLocalDataSource)
    }

}
