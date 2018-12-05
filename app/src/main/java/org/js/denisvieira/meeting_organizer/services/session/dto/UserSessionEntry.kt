package org.js.denisvieira.meeting_organizer.services.session.dto

import com.github.brunodles.simplepreferences.lib.Property

class UserSessionEntry {

    @Property
    var token: String? = null
    @Property
    var token_type: String? = null
    @Property
    var id: Int = 0
    @Property
    var name: String? = null
    @Property
    var email: String? = null
    @Property
    var company: String? = null
    @Property
    var nickname: String? = null

    companion object {
        val PREFERENCE_KEY = "UserSessionEntry"
    }
}