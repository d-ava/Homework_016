package com.example.homework_016

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_016.databinding.ItemBinding
import com.example.homework_016.db.TestEntity
import com.example.homework_016.extension.glideExtension

class TestRAdapter : RecyclerView.Adapter<TestRAdapter.TestRViewHolder>() {

    private var list:MutableList<TestEntity> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<TestEntity>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestRViewHolder {
       return TestRViewHolder(
           ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
       )
    }

    override fun onBindViewHolder(holder: TestRViewHolder, position: Int) {
        holder.onBind()
    }

    override fun getItemCount()=list.size

    inner class TestRViewHolder(private var binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root){
            private lateinit var model: TestEntity

            fun onBind(){
                model = list[adapterPosition]
                binding.tvTitle.text = model.title
                binding.tvDescription.text = model.description
                binding.ivImage.glideExtension(model.url)
            }

        }

}