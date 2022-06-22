package com.anwar.task_executer.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.anwar.task_executer.databinding.FragmentHomeBinding
import com.anwar.task_executer.ui.home.adapter.TasksAdapter

class HomeFragment : Fragment(), TasksAdapter.IClicks {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var mTasksAdapter: TasksAdapter
    private val binding get() = _binding!!
    lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTasksRecyclerView()
    }

    private fun initTasksRecyclerView() {
        mTasksAdapter = TasksAdapter(homeViewModel.provideTaskList(),this)
        binding.rvTasks.adapter = mTasksAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClicked(taskId: Int) {
        for (i in mTasksAdapter.list) {
            i.isSelected = i.taskId == taskId
        }
        mTasksAdapter.notifyDataSetChanged()
    }
}