package uk.co.itmms.demohilt.application

import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DemoHiltApplication: MultiDexApplication() {
}