package com.example.homework_016



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_016.databinding.ItemBinding
import com.example.homework_016.db.TestEntity
import com.example.homework_016.extension.glideExtension

//private val onItemClicked: (TestEntity)-> Unit

class TestAdapter() : ListAdapter<TestEntity, TestAdapter.TestViewHolder>(DiffCallback) {

    companion object {

        private val DiffCallback = object : DiffUtil.ItemCallback<TestEntity>() {
            override fun areItemsTheSame(oldItem: TestEntity, newItem: TestEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TestEntity, newItem: TestEntity): Boolean {
                return oldItem == newItem
            }

        }
    }



    class TestViewHolder(private var binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(testEntity: TestEntity) {
            binding.tvDescription.text = testEntity.description
            binding.tvTitle.text = testEntity.title
            binding.ivImage.glideExtension(testEntity.url)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {

        return TestViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }


}
