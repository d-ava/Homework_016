package com.example.homework_016.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.homework_016.R
import com.example.homework_016.databinding.AddFragmentBinding
import com.example.homework_016.db.TestEntity
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class AddFragment : BaseFragment<AddFragmentBinding, AddViewModel>(AddFragmentBinding::inflate) {

    override fun getViewModel()=AddViewModel::class.java

    override var useSharedViewModel=false
    override fun start() {

        setListeners()

    }

    private fun setListeners(){




        binding.btnAdd.setOnClickListener {
            findNavController().navigate(AddFragmentDirections.actionAddFragmentToMainFragment())
            val title = binding.etTitle.text.toString()
            val description = binding.etDescription.text.toString()
            val url = binding.etUrl.text.toString()
            lifecycleScope.launchWhenStarted {
                withContext(IO){
                    viewModel.addItem(TestEntity(title,description,url))
                }

            }

        }
    }
}