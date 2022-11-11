package org.sopt.sample.presentation.mediator

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import androidx.activity.viewModels
import org.sopt.sample.R
import org.sopt.sample.base.BindingActivity
import org.sopt.sample.databinding.ActivityMediatorBinding
import org.sopt.sample.presentation.flow.FlowActivity
import org.sopt.sample.util.showToast

class MediatorActivity : BindingActivity<ActivityMediatorBinding>(R.layout.activity_mediator) {
    private val viewModel: MediatorViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        binding.lifecycleOwner = this
        //1. MediatorViewModel의 init에서 isEnabledLoginButton() 호출 -> isInputValid에 id와 pw addSource
        //2. MediatorActivity에서는 1번 과정을 통해 변경될 isInputValid 만을 observe하면 된다.
        //3. isInputValid가 변경되면 토스트 메시지 출력
        viewModel.isInputValid.observe(this) {
            if (it) {
                binding.mediatorLoginBtn.apply {
                    isClickable = true
                    setBackgroundColor(getColor(R.color.black))
                }
            }
            else {
                binding.mediatorLoginBtn.apply {
                    isClickable = false
                    setBackgroundColor(getColor(R.color.grey))
                }
            }
        }
        binding.mediatorLoginBtn.setOnClickListener {
            if(viewModel.isInputValid.value == true){
                startActivity(Intent(this,FlowActivity::class.java))
                finish()
            }
        }
    }
}