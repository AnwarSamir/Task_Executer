package com.anwar.task_executer.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anwar.task_executer.models.TaskModel
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

   fun provideTaskList():ArrayList<TaskModel>{
       val tasksList = arrayListOf<TaskModel>()
       for(i in 1 until 5)
       {
           tasksList.add(TaskModel(i,"Task$i"))
       }
       return tasksList
   }


}