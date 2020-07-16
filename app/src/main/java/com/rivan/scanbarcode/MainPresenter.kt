package com.rivan.scanbarcode

class MainPresenter: MainContract.Presenter {

    private lateinit var view: MainContract.View

    override fun subscribe() {

    }

    override fun unsubscribe() {
    }

    override fun attach(view: MainContract.View) {
        this.view = view
    }

}