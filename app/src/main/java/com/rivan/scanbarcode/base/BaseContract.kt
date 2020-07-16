package com.rivan.scanbarcode.base

class BaseContract {
    interface presenter<in T> {
        fun subscribe()
        fun unsubscribe()
        fun attach(view: T)
    }

    interface View {
    }
}