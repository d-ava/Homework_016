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

class AddFragment : BaseFragment<AddFragmentBinding, AddViewModel>(AddFragmentBinding::inflate) {

    override fun getViewModel()=AddViewModel::class.java

    override var useSharedViewModel=false
    override fun start() {

        setListeners()

    }

    private fun setListeners(){
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(AddFragmentDirections.actionAddFragmentToMainFragment())
        }
    }
}