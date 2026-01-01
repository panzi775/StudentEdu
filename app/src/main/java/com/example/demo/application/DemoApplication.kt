package com.example.demo.application

import android.app.Application
import android.os.Looper
import android.util.Log

class DemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // 初始化全局配置或资源
        // 例如，初始化日志库、网络库等
//        Log.i("pangao", "Application onCreate called")
        Looper.getMainLooper().setMessageLogging { msg ->
//            println("pangao >>> msg = $msg")
//            Log.w("pangao", "MainLooper: $msg")
        }

    }
}