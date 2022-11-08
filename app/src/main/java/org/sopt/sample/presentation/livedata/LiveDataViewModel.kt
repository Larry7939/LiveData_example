package org.sopt.sample.presentation.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataViewModel:ViewModel() {
    //ViewModel의 LiveData 인스턴스 생성
    val inputText: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    private var _number:MutableLiveData<Int> = MutableLiveData(0)
    val number:LiveData<Int> get() = _number

    //뷰와 뷰모델의 역할을 나누기 위함
    fun addValue():Int?{
        _number.value = _number.value?.plus(1)
        return number.value
    }
    fun subValue():Int?{
        _number.value = _number.value?.minus(1)
        _number.postValue(_number.value?.plus(1))
        return number.value
    }


}