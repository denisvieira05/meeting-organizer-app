package org.js.denisvieira.powermarvelapp.application

interface UseCase {

    interface UseCaseCallback<R> {
        fun onSuccess(response: R)
        fun onError(errorDescription: String)
    }

    interface VoidUseCaseCallback {
        fun onSuccess()
        fun onError(errorDescription: String)
    }

    interface LoadUseCaseCallback<R> {
        fun onLoaded(response: R)
        fun onEmptyData()
        fun onFailed(errorDescription: String)
    }


}
