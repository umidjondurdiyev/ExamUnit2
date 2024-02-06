package com.durdiyevw.examunit.core

import android.app.Application

class App : Application() {

    companion object{
        var instanse : App? = null
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instanse = this
    }

}