package com.dialog

import android.app.Application

/**
 * <>
 *
 * @author Fires
 */
class BaseApplication : Application() {

    companion object {
        var ctx: BaseApplication? = null
            private set
    }

    override fun onCreate() {
        super.onCreate()
        ctx = this
    }

}
