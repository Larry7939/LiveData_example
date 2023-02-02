package org.sopt.sample.presentation.flow

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import org.sopt.sample.R
import org.sopt.sample.base.BindingActivity
import org.sopt.sample.databinding.ActivityFlowBinding
import timber.log.Timber

class FlowActivity : BindingActivity<ActivityFlowBinding>(R.layout.activity_flow) {
    private val viewModel: FlowViewModel by viewModels()

    /**Local or Remote DataSource**/
    private val stringFlow: Flow<String> = flow<String> {
        for (i in 0..1000) {
            emit("$i")
            delay(1000)
        }
    }.flowOn(Dispatchers.IO)
    private val stringFlow2: Flow<String> = flow<String> {
        for (i in 0..1000) {
            emit("$i")
            Timber.d("${currentCoroutineContext()}")
            delay(1000)
        }
    }.flowOn(Dispatchers.IO)
    private val stringFlow3: Flow<String> = flow<String> {
        for (i in 0..1000) {
            emit("$i")
            delay(1000)
        }
    }.flowOn(Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        binding.lifecycleOwner = this

//        lifecycleScope.launch {
//            stringFlow.flowWithLifecycle(lifecycle,Lifecycle.State.STARTED).collect{
//            }
//        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    stringFlow.collect {
                        binding.tvFlowRepeatValue.text = it
                        Timber.d("repeatOnLifecycle : $it")
                    }
                }
            }
        }
        lifecycleScope.launch {
            stringFlow2.collect {
                binding.tvFlowLaunchValue.text = it
                Timber.d("${this.coroutineContext}")
                Timber.d("launch : $it")
            }
        }
        lifecycleScope.launchWhenStarted {
            stringFlow3.collect {
                binding.tvFlowLaunchWhenStartedValue.text = it
                Timber.d("launchWhenStarted : $it")
            }
        }
    }
}