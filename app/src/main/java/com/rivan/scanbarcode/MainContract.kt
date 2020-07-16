package com.rivan.scanbarcode

import com.rivan.scanbarcode.base.BaseContract

class MainContract {

    interface View: BaseContract.View {
        fun initScannerView()
        fun initPermission()
    }

    interface Presenter: BaseContract.presenter<View> {}

}