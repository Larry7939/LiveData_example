package org.sopt.sample.presentation.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataViewModel:ViewModel() {
    val inputText:MutableLiveData<String> = MutableLiveData<String>()


    private var _number:MutableLiveData<Int> = MutableLiveData()
    val number:LiveData<Int> get() = _number
    //뷰와 뷰모델의 역할을 나누기 위함
    fun addInputValue():Int?{
        _number.value = _number.value?.plus(1)
        return number.value
    }

}