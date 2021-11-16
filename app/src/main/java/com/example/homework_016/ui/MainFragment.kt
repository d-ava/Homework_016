package com.example.homework_016.ui

import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_016.TestRAdapter
import com.example.homework_016.databinding.MainFragmentBinding
import com.example.homework_016.db.TestEntity
import kotlinx.coroutines.flow.collect


class MainFragment :
    BaseFragment<MainFragmentBinding, MainViewModel>(MainFragmentBinding::inflate) {
    override fun getViewModel() = MainViewModel::class.java

   // private lateinit var recyclerView: RecyclerView
    private lateinit var adapterR: TestRAdapter

    override var useSharedViewModel = false

    private val testList = mutableListOf(TestEntity("title", "description some text", "https://cdn3.photostockeditor.com/t/0708/toy-selective-focus-photography-of-two-white-lego-minifigures-lego-lego-image.jpg"),
        TestEntity("titlergegfsdfe2", "description some text222", "https://cdn3.photostockeditor.com/t/0708/toy-selective-focus-photography-of-two-white-lego-minifigures-lego-lego-image.jpg"),
        TestEntity("tigsdfgsdfgsdtle3", "description some text555", "https://cdn3.photostockeditor.com/t/0708/toy-selective-focus-photography-of-two-white-lego-minifigures-lego-lego-image.jpg"),
        TestEntity("titfgsdfgsdfgle", "description some text", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0f/2_duplo_lego_bricks.jpg/200px-2_duplo_lego_bricks.jpg"))

    override fun start() {
        setListeners()
        setRecycler()
      //  adapterR.setData(testList)

        lifecycleScope.launchWhenStarted {
            viewModel.readItems.collect {
                adapterR.setData(it.toMutableList())
            }
        }
    }


    private fun setListeners() {


        binding.btnAdd.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToAddFragment())
        }
    }

    private fun setRecycler(){



        adapterR = TestRAdapter()
        binding.recycler.adapter = adapterR
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())

      /* lifecycleScope.launchWhenStarted {
           viewModel.readItems.observe(viewLifecycleOwner){
               adapterR.setData(it)
           }
       }*/




       /* lifecycleScope.launchWhenStarted {
            viewModel.getAllItem().collect {
                adapterR.setData(it)
            }
        }
*/
    }
}