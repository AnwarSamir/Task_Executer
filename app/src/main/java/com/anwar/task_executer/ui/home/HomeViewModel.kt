package com.anwar.task_executer.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anwar.task_executer.models.TaskModel
import com.anwar.task_executer.queue.QueueExecutor
import com.anwar.task_executer.util.Util.DefaultThread
import com.anwar.task_executer.util.getDateAndTime
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val queueExecutor: QueueExecutor
) : ViewModel() {

    private val _state = MutableStateFlow("")
    val state = _state.asStateFlow()
    fun provideTaskList(): ArrayList<TaskModel> {
        val tasksList = arrayListOf<TaskModel>()
        for (i in 1 until 5) {
            tasksList.add(TaskModel(i, "Task$i"))
        }
        return tasksList
    }

    fun launchTask(task: Int) = launch(
        thread = DefaultThread
    ) {
        (3 downTo 0).forEach { turn ->
            val progress = "${getDateAndTime()} Task-$task completed"
            if (turn == 0)
                _state.emit(progress)
            delay(timeMillis = 1000L)
        }
    }


    private fun <T> launch(
        thread: CoroutineContext,
        block: suspend CoroutineScope.() -> T
    ) {
        viewModelScope.launch(context = thread) {
            queueExecutor.enqueue { block() }
        }
    }


}