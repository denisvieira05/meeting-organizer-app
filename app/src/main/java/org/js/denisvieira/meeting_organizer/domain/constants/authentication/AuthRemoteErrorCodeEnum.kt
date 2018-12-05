package org.js.denisvieira.meeting_organizer.domain.constants.authentication

enum class AuthRemoteErrorCodeEnum constructor(val value: Int) {

    UNAUTHORIZED(401), INVALID(400), SERVER_UNAVAILABLE(500);

    companion object {


        fun getEnum(value: Int): AuthRemoteErrorCodeEnum? {
            when (value) {
                401 -> return AuthRemoteErrorCodeEnum.UNAUTHORIZED
                400 -> return AuthRemoteErrorCodeEnum.INVALID
                500 -> return AuthRemoteErrorCodeEnum.SERVER_UNAVAILABLE
            }
            return null
        }
    }
}
