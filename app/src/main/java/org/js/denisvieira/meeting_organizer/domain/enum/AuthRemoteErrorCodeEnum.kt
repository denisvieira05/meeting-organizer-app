package org.js.denisvieira.meeting_organizer.domain.enum

enum class AuthRemoteErrorCodeEnum constructor(val value: Int) {

    UNAUTHORIZED(401), INVALID(400), SERVER_UNAVAILABLE(500);

    companion object {


        fun getEnum(value: Int): org.js.denisvieira.meeting_organizer.domain.constants.authentication.AuthRemoteErrorCodeEnum? {
            when (value) {
                401 -> return org.js.denisvieira.meeting_organizer.domain.constants.authentication.AuthRemoteErrorCodeEnum.UNAUTHORIZED
                400 -> return org.js.denisvieira.meeting_organizer.domain.constants.authentication.AuthRemoteErrorCodeEnum.INVALID
                500 -> return org.js.denisvieira.meeting_organizer.domain.constants.authentication.AuthRemoteErrorCodeEnum.SERVER_UNAVAILABLE
            }
            return null
        }
    }
}
