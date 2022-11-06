package org.sopt.sample.presentation.livedata

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import org.sopt.sample.R
import org.sopt.sample.base.BindingActivity
import org.sopt.sample.databinding.ActivityLivedataBinding

class LiveDataActivity : BindingActivity<ActivityLivedataBinding>(R.layout.activity_livedata) {
    private val viewModel: LiveDataViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        binding.lifecycleOwner = this



//
////      1. 특정 동작을 하는 Observer를 미리 만들어 놓고 observe함수에 전달하는 방식
//      val myObserver = Observer<Int> { binding.textTest.text = it.toString() }
//      viewModel.number.observe(this,myObserver)
//
////      2. 곧바로 어떤 동작을 할 지 만드는 방식
//      viewModel.number.observe(this) {
//      binding.textTest.text = it.toString()
//        }

//      3. xml에 viewModel의 변수를 지정해서 DataBinding과 함께 사용하는 방식
//        xml의 카운트에 해당하는 부분에 @{vm.setNumberAdd()}를 적어놓고,
//        viewModel의 setNumberAdd()에서는 number에 1을 더한 값을 return하도록 만들면 된다.

//      4. 양방향 binding
        viewModel.inputText.observe(this){
            Log.d("값 변화",it)
        }
    }
}
