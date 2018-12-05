package org.js.denisvieira.meeting_organizer.services.session

import com.github.brunodles.simplepreferences.lib.DaoPreferences
import org.js.denisvieira.meeting_organizer.domain.converters.UserSessionConverter
import org.js.denisvieira.meeting_organizer.domain.entity.UserSession
import org.js.denisvieira.meeting_organizer.services.session.dto.UserSessionEntry


class SessionLocalDataSourceImpl(private val mDaoPreferences: DaoPreferences) : SessionLocalDataSource {


    companion object {

        private var INSTANCE: SessionLocalDataSourceImpl? = null

        fun getInstance(daoPreferences: DaoPreferences): SessionLocalDataSourceImpl {
            if (INSTANCE == null)
                INSTANCE = SessionLocalDataSourceImpl(daoPreferences)

            return INSTANCE as SessionLocalDataSourceImpl
        }
    }

    override fun getUserSession(): UserSession? {
        val userSessionEntry = UserSessionEntry()
        val load = mDaoPreferences.load(userSessionEntry, UserSessionEntry.PREFERENCE_KEY)

        return if (load.name == null) null else UserSessionConverter.convertFromEntry(load)
    }

    override fun save(userSession: UserSession): UserSession {
        val userSessionEntry = UserSessionConverter.convertFromEntity(userSession)

        mDaoPreferences.commit(userSessionEntry, UserSessionEntry.PREFERENCE_KEY)

        return userSession
    }

    override fun destroy() {
        mDaoPreferences.clear(UserSessionEntry.PREFERENCE_KEY)
    }


}