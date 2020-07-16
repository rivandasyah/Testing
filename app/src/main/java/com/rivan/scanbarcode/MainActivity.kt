package com.rivan.scanbarcode

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.zxing.Result
import com.rivan.scanbarcode.base.BaseContract
import kotlinx.android.synthetic.main.activity_main.*
import me.dm7.barcodescanner.core.IViewFinder
import me.dm7.barcodescanner.zxing.ZXingScannerView
import java.util.jar.Manifest

class MainActivity : AppCompatActivity(), MainContract.View, ZXingScannerView.ResultHandler {

    private lateinit var scannerView: ZXingScannerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initScannerView()
    }

    override fun initScannerView() {
        scannerView = ZXingScannerView(this)
        scannerView.setAutoFocus(true)
        scannerView.setResultHandler(this)
        fl_scan_barcode.addView(scannerView)
    }

    override fun onStart() {
        super.onStart()
        scannerView.startCamera()
        initPermission()
    }

    override fun initPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(arrayOf(android.Manifest.permission.CAMERA), 100)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            100 -> {
                initScannerView()
            }
            else -> {

            }
        }
    }

    override fun onPause() {
        scannerView.stopCamera()
        super.onPause()
    }

    override fun handleResult(rawResult: Result?) {
        Toast.makeText(this, rawResult?.text, Toast.LENGTH_SHORT).show()
        scannerView.resumeCameraPreview(this)
    }

}
