package org.sopt.sample.presentation.mediator

import android.os.Bundle
import androidx.activity.viewModels
import org.sopt.sample.R
import org.sopt.sample.base.BindingActivity
import org.sopt.sample.databinding.ActivityMediatorBinding
import org.sopt.sample.util.showToast

class MediatorActivity : BindingActivity<ActivityMediatorBinding>(R.layout.activity_mediator) {
    private val viewModel: MediatorViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        binding.lifecycleOwner = this

        //1. xml의 로그인 버튼 클릭 시 MediatorViewModel의 isEnabledLoginButton() 호출
        //2. MediatorActivity에서는 1번 과정을 통해 변경될 isInputValid만 observe
        //3. isInputValid가 변경되면 토스트 메시지 출력
        viewModel.isInputValid.observe(this){
            if(it) showToast("로그인 성공!")
            else showToast("로그인 실패!")
        }
    }
}