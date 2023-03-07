package com.example.workmanager.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.workmanager.database.Work
import com.example.workmanager.databinding.ListWorkItemBinding

class WorkListAdapter (val click : ClickHelper, val clicker : SwitchHelper) :
    ListAdapter<Work, WorkListAdapter.ViewItemHolder>(DiffUtilWork()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewItemHolder {
        return ViewItemHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewItemHolder, position: Int) {
        holder.bind(getItem(position), click, clicker)
    }
    class ViewItemHolder private constructor(private val binding: ListWorkItemBinding) :
        ViewHolder(binding.root) {
        fun bind(item: Work, click : ClickHelper, clicker : SwitchHelper) {
            binding.item = item
            binding.click = click
        }

        companion object {
            fun from(parent: ViewGroup): ViewItemHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListWorkItemBinding.inflate(layoutInflater, parent, false)
                return ViewItemHolder(binding)
            }
        }
    }
}

class DiffUtilWork : DiffUtil.ItemCallback<Work>() {
    override fun areItemsTheSame(oldItem: Work, newItem: Work): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Work, newItem: Work): Boolean {
        return oldItem.id == newItem.id
    }
}
class ClickHelper(var clickHelper: (id: Int) -> Unit) {
    fun onClick(item: Work) = clickHelper(item.id)
}
class SwitchHelper(val clicker : (id: Int) -> Unit) {
    fun onClick(id : Int) = clicker(id)
}


