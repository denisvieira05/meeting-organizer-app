package org.js.denisvieira.meeting_organizer.application.injections

import android.content.Context

import org.js.denisvieira.meeting_organizer.application.usecases.authentication.GetAuth

object InjectionUseCase {

    fun provideGetAuth(context: Context): GetAuth {
        return GetAuth(InjectionRemoteDataSource.provideAuthRemoteDataSource(context))
    }

}
