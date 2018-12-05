package org.js.denisvieira.meeting_organizer.services.exception

import org.js.denisvieira.meeting_organizer.services.RemoteErrorResponse
import retrofit2.Response
import retrofit2.Retrofit
import java.io.IOException

class RetrofitException internal constructor(message: String,
                                             /** The request URL which produced the error.  */
                                             val url: String?,
                                             /** RemoteErrorResponse object containing status code, headers, body, etc.  */
                                             val response: Response<*>?,
                                             /** The event kind which triggered this error.  */
                                             val kind: Kind, exception: Throwable?,
                                             /** The Retrofit this request was executed on  */
                                             val retrofit: Retrofit?) : RuntimeException(message, exception) {

    companion object {
        fun httpError(url: String, response: Response<*>, retrofit: Retrofit): RetrofitException {
            val message = response.code().toString() + " " + response.message()
            return RetrofitException(message, url, response, Kind.HTTP, null, retrofit)
        }

        fun networkError(exception: IOException): RetrofitException {
            return RetrofitException(exception.message!!, null, null, Kind.NETWORK, exception, null)
        }

        fun unexpectedError(exception: Throwable): RetrofitException {
            return RetrofitException(exception.message!!, null, null, Kind.UNEXPECTED, exception, null)
        }
    }

    /** Identifies the event kind which triggered a [RetrofitException].  */
    enum class Kind {
        /** An [IOException] occurred while communicating to the server.  */
        NETWORK,
        /** A non-200 HTTP status code was received from the server.  */
        HTTP,
        /**
         * An internal error occurred while attempting to execute a request. It is best practice to
         * re-throw this exception so your application crashes.
         */
        UNEXPECTED
    }

    /**
     * HTTP response body converted to specified `type`. `null` if there is no
     * response.
     *
     */
    fun <T : RemoteErrorResponse> getErrorBodyAs(type: Class<T>): T? {
        if (response == null || response.errorBody() == null) {
            return buildRemoteResponseByException(type)
        }

        val errorBody = response.errorBody()
        val converter = retrofit!!.responseBodyConverter<T>(type, arrayOfNulls(0))
        var errorInstance: T? = null
        var remoteRemoteErrorResponse: RemoteErrorResponse? = null

        try {
            errorInstance = converter.convert(errorBody)
            remoteRemoteErrorResponse = errorInstance
            remoteRemoteErrorResponse!!.code = response.code()
            remoteRemoteErrorResponse!!.detailMessage = message
        } catch (e: IOException) {
            try {
                errorInstance = type.newInstance()
                remoteRemoteErrorResponse = errorInstance
                remoteRemoteErrorResponse!!.detailMessage = "Error when tried to convert body response"
                errorInstance = remoteRemoteErrorResponse
            } catch (e1: InstantiationException) {
                e1.printStackTrace()
            } catch (e1: IllegalAccessException) {
                e1.printStackTrace()
            }

        }

        remoteRemoteErrorResponse!!.url = url

        return errorInstance
    }

    private fun <T : RemoteErrorResponse> buildRemoteResponseByException(type: Class<T>): T? {
        if (typeSuperClassNameIsRemoteErrorResponseName(type) || typeNameIsRemoteErrorResponseName(type)) {
            try {
                val errorInstance = type.newInstance()
                errorInstance.url = url

                if (kind == Kind.NETWORK) {
                    val INTERNAL_ERROR = 500
                    errorInstance.code = INTERNAL_ERROR
                    errorInstance.detailMessage = "Server Unavailable"
                }
                if (kind == Kind.UNEXPECTED) {
                    errorInstance.detailMessage = "Unknown Error"
                }

                return errorInstance
            } catch (e: InstantiationException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            }

        }
        return null
    }

    private fun <T : RemoteErrorResponse> typeNameIsRemoteErrorResponseName(type: Class<T>): Boolean {
        return type.name == RemoteErrorResponse::class.java!!.getName()
    }

    private fun <T : RemoteErrorResponse> typeSuperClassNameIsRemoteErrorResponseName(type: Class<T>): Boolean {
        return type.superclass.name == RemoteErrorResponse::class.java!!.getName()
    }


}
