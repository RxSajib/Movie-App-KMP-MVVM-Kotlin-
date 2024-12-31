package org.wizard.project.app

import android.app.Application
import org.koin.core.context.startKoin
import org.wizard.project.di.initKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
            initKoin()

    }
}