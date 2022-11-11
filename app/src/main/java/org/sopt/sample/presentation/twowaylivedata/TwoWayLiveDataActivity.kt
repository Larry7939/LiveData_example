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

        binding.btnToway.setOnClickListener {
            startActivity(Intent(this, MediatorActivity::class.java))
            finish()
        }
    }
}
