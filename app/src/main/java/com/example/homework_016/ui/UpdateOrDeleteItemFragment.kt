package com.example.homework_016.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.homework_016.databinding.FragmentUpdateOrDeleteItemListDialogBinding
import com.example.homework_016.db.TestDao
import com.example.homework_016.db.TestDatabase
import com.example.homework_016.db.TestEntity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class UpdateOrDeleteItemFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentUpdateOrDeleteItemListDialogBinding? = null

    private var testDao: TestDao = TestDatabase.db.testDao()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentUpdateOrDeleteItemListDialogBinding.inflate(inflater, container, false)

        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListeners()
    }


    private fun setListeners() {


      /*  binding.btnAdd.setOnClickListener {
            findNavController().navigate(UpdateOrDeleteItemFragmentDirections.actionAddItemFragmentToMainFragment())
            val title = binding.etTitle.text.toString()
            val description = binding.etDescription.text.toString()
            val url = binding.etUrl.text.toString()
            lifecycleScope.launchWhenStarted {
                withContext(IO) {
                    testDao.insertItem(TestEntity(title, description, url))
                }





            }
        }*/

        binding.btnDelete.setOnClickListener {
            lifecycleScope.launchWhenStarted {
                withContext(IO){
                    testDao.deleteItem(binding.etTitle.text.toString())
                }
            }
        }


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}