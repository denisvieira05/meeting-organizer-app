package org.js.denisvieira.meeting_organizer.application.injections

import android.content.Context
import com.github.brunodles.simplepreferences.lib.DaoPreferences
import org.js.denisvieira.meeting_organizer.services.session.SessionLocalDataSource
import org.js.denisvieira.meeting_organizer.services.session.SessionLocalDataSourceImpl


object InjectionLocalDataSource {

    fun provideSessionLocalDataSource(context: Context): SessionLocalDataSource {
        val daoPreferences = DaoPreferences(context)

        return SessionLocalDataSourceImpl.getInstance(daoPreferences)
    }
}