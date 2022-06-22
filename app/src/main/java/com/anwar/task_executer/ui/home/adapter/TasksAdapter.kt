package com.anwar.task_executer.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.anwar.task_executer.R
import com.anwar.task_executer.databinding.RowTaskBinding
import com.anwar.task_executer.models.TaskModel


class TasksAdapter(var list: ArrayList<TaskModel>, private val iClicks: IClicks) :
    RecyclerView.Adapter<TasksAdapter.ProductsCategoriesViewHolder>() {

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductsCategoriesViewHolder {
        return ProductsCategoriesViewHolder(
            RowTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductsCategoriesViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class ProductsCategoriesViewHolder(var viewBinding: RowTaskBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(data: TaskModel) {
            viewBinding.apply {
                tvCategoryName.text = data.taskName
                handleItemSelected(data.isSelected, tvCategoryName)
                root.setOnClickListener {
                    iClicks.onItemClicked(data.taskId)
                }
            }
        }

        private fun handleItemSelected(selected: Boolean, tvCategoryName: TextView) {
            if (selected) {
                tvCategoryName.background = ContextCompat.getDrawable(
                    tvCategoryName.context,
                    R.drawable.ic_task_selected
                )
                tvCategoryName.setTextColor(
                    ContextCompat.getColor(
                        tvCategoryName.context,
                        R.color.white
                    )
                )
            } else {
                tvCategoryName.background = ContextCompat.getDrawable(
                    tvCategoryName.context,
                    R.drawable.ic_task_unselected
                )
                tvCategoryName.setTextColor(
                    ContextCompat.getColor(
                        tvCategoryName.context,
                        R.color.black
                    )
                )
            }
        }
    }

    interface IClicks {
        fun onItemClicked(taskId: Int)
    }

}