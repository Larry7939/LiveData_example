package org.sopt.sample.util

import androidx.lifecycle.LiveData

class CustomLiveData:LiveData<String>() {
    override fun onActive() {
        super.onActive()
    }

    override fun onInactive() {
        super.onInactive()
    }
}