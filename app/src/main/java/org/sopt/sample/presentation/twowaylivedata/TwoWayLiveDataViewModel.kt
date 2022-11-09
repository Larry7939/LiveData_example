package org.sopt.sample.presentation.twowaylivedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TwoWayLiveDataViewModel : ViewModel() {
    //ViewModel의 LiveData 인스턴스 생성
    val inputText: MutableLiveData<String> by lazy { MutableLiveData<String>() }

}