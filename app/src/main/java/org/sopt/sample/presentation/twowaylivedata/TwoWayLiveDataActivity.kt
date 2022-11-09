package org.sopt.sample.presentation.twowaylivedata

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import org.sopt.sample.R
import org.sopt.sample.base.BindingActivity
import org.sopt.sample.databinding.ActivityTwowaylivedataBinding
import org.sopt.sample.presentation.mediator.MediatorActivity

class TwoWayLiveDataActivity :
    BindingActivity<ActivityTwowaylivedataBinding>(R.layout.activity_twowaylivedata) {
    private val viewModel: TwoWayLiveDataViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        binding.lifecycleOwner = this


//      양방향 binding
//        viewModel.inputText.observe(this) {
//            Log.d("값 변화", it)
//        }
        binding.btnToway.setOnClickListener {
            startActivity(Intent(this, MediatorActivity::class.java))
            finish()
        }
    }
}
