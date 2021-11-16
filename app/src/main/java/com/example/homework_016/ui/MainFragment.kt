package com.example.homework_016.ui

import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_016.R
import com.example.homework_016.TestAdapter
import com.example.homework_016.TestRAdapter
import com.example.homework_016.databinding.MainFragmentBinding
import com.example.homework_016.db.TestDao
import com.example.homework_016.db.TestDatabase
import com.example.homework_016.db.TestEntity
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.withContext


class MainFragment :
    BaseFragment<MainFragmentBinding, MainViewModel>(MainFragmentBinding::inflate) {
    override fun getViewModel() = MainViewModel::class.java

    // private lateinit var recyclerView: RecyclerView
    private lateinit var adapterR: TestRAdapter

    private lateinit var adapterList: TestAdapter


    override var useSharedViewModel = false





    override fun start() {
        setListeners()
        setRecycler()


        lifecycleScope.launchWhenStarted {
            viewModel.readItems.collect {
               // adapterR.setData(it.toMutableList())
                adapterList.submitList(it.toMutableList())
            }
        }
    }


    private fun setListeners() {


        binding.btnAdd.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToAddFragment())
        }


    }

    private fun setRecycler() {


      //  adapterR = TestRAdapter()
      //  binding.recycler.adapter = adapterR
      //  binding.recycler.layoutManager = GridLayoutManager(requireContext(), 2)

        adapterList= TestAdapter{
            view?.findNavController()?.navigate(MainFragmentDirections.actionMainFragmentToUpdateDeleteFragment())
        }
        binding.recycler.adapter = adapterList
        binding.recycler.layoutManager = GridLayoutManager(requireContext(),3)



    }
}