package com.example.homework_016.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.homework_016.R
import com.example.homework_016.databinding.AddFragmentBinding
import com.example.homework_016.db.TestEntity

class AddFragment : BaseFragment<AddFragmentBinding, AddViewModel>(AddFragmentBinding::inflate) {

    override fun getViewModel()=AddViewModel::class.java

    override var useSharedViewModel=false
    override fun start() {

        setListeners()

    }

    private fun setListeners(){

        val title = binding.etTitle.text.toString()
        val description = binding.etDescription.text.toString()
        val url = binding.etUrl.text.toString()

        viewModel.addItem(TestEntity(title,description,url))
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(AddFragmentDirections.actionAddFragmentToMainFragment())
        }
    }
}