package org.js.denisvieira.meeting_organizer.services

import com.google.gson.GsonBuilder

class RemoteErrorResponse {
    var url: String? = null
    var code: Int = 0
    var detailMessage: String? = null

    fun asJson(): String {
        val gson = GsonBuilder().create()
        return gson.toJson(this)
    }

}