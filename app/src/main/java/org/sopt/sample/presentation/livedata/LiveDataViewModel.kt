package org.sopt.sample.presentation.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class LiveDataViewModel:ViewModel() {
    //ViewModel의 LiveData 인스턴스 생성
    //뷰와 뷰모델의 역할을 나누기 위한 backing code
    private var _number:MutableLiveData<Int> = MutableLiveData(0)
    val number:LiveData<Int> get() = _number

    fun addValue():Int?{
        _number.value = _number.value?.plus(1)
        return number.value
    }
    fun subValue():Int?{
        _number.value = _number.value?.minus(1)
        return number.value
    }


}