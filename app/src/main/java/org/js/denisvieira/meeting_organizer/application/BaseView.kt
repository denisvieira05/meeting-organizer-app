package org.js.denisvieira.powermarvelapp.application

interface BaseView<T : BasePresenter> {
    fun showRemoteRequestLoader()
    fun hideRemoteRequestLoader()
    fun setPresenter(presenter: T)
}
