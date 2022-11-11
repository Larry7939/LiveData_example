package org.sopt.sample.presentation.mediator

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.sample.util.addSourceList

class MediatorViewModel:ViewModel() {
    val id:MutableLiveData<String> = MutableLiveData<String>()
    val pw:MutableLiveData<String> = MutableLiveData<String>()

    val isInputValid:MediatorLiveData<Boolean> = MediatorLiveData<Boolean>()
    init {
        isInputValid.value = false
        isEnabledLoginButton()
    }
    private fun isEnabledLoginButton(){
        isInputValid.apply {
            addSource(id){value = isValidSignInfo()}
            addSource(pw){value = isValidSignInfo()}
        }
        //MediatorLiveDataExt에서 정의한 확장함수로 여러 개의 LiveData 인자를 받을 수 있다.
        //isInputValid.addSourceList(id,pw){isValidSignInfo()}
    }
    private fun isValidSignInfo() = !id.value.isNullOrBlank() && !pw.value.isNullOrBlank()


}