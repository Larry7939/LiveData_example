package org.sopt.sample.presentation.flow

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import org.sopt.sample.R
import org.sopt.sample.base.BindingActivity
import org.sopt.sample.databinding.ActivityFlowBinding

class FlowActivity : BindingActivity<ActivityFlowBinding>(R.layout.activity_flow) {
    private val stringFlow : Flow<String> = flow<String> {
        for (i in 0..1000){
            emit("integer : $i")
            delay(1000)
        }
    }.flowOn(Dispatchers.IO)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch{
//            repeatOnLifecycle(Lifecycle.State.STARTED){
//                launch {
                    stringFlow.collect{
                        println(it)
                    }
//                }
//                launch {
//                    stringFlow2.collect{
//                        println(it)
//                    }
//                }
//            }
        }
    }
}