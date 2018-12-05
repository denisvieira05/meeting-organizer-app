package org.js.denisvieira.meeting_organizer.services.authentication

import okhttp3.MediaType
import okhttp3.ResponseBody
import org.js.denisvieira.meeting_organizer.services.authentication.dto.AuthRequest
import org.js.denisvieira.meeting_organizer.services.authentication.dto.AuthResponse
import org.js.denisvieira.meeting_organizer.services.authentication.dto.UserResponse
import org.js.denisvieira.meeting_organizer.services.exception.RetrofitException
import retrofit2.Retrofit
import retrofit2.http.Body
import rx.Observable
import rx.Subscriber


class FakeAuthRemoteDataSource(private val mRetrofit: Retrofit) : AuthApiDataSource {

    override fun authorize(@Body request: AuthRequest): Observable<AuthResponse> {
        return Observable.create(object : Observable.OnSubscribe<AuthResponse> {

            private val isValid: Boolean
                get() = request.email.equals("denisvieira@gmail.com") && request.password.equals("123456")

            override fun call(subscriber: Subscriber<in AuthResponse>) {
                if (isValid) {
                    val userResponse = UserResponse("Ralphinh", 1, "Ralph Vasco", "email@satst", "V2")
                    val authResponse = AuthResponse("3c4aa43a65a23809cf344260b9ed0dd96bcea318a0c31c6b25d1f49332c73ca7", "bearer", "1447264151", userResponse)

                    subscriber.onNext(authResponse)
                } else {
                    val JSON = MediaType.parse("application/json; charset=utf-8")
                    val jsonString = "{\"error\": \"invalid_grant\", \"error_description\":\"Invalid Grant message\"}"
                    val responseBody = ResponseBody.create(JSON, jsonString)
                    val UNAUTHORIZED = 401
                    val r = retrofit2.Response.error<Any>(UNAUTHORIZED, responseBody)

                    val re = RetrofitException.httpError("http://fake.stant.com.br/oauth/token", r, mRetrofit)

                    subscriber.onError(re)
                }
            }
        })
    }


}
