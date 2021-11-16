package com.example.homework_016.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.homework_016.databinding.FragmentAddItemListDialogBinding
import com.example.homework_016.db.TestDao
import com.example.homework_016.db.TestDatabase
import com.example.homework_016.db.TestEntity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class AddItemFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentAddItemListDialogBinding? = null

    private var testDao: TestDao = TestDatabase.db.testDao()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAddItemListDialogBinding.inflate(inflater, container, false)

        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListeners()
    }


    private fun setListeners() {


        binding.btnAdd.setOnClickListener {
            findNavController().navigate(AddItemFragmentDirections.actionAddItemFragmentToMainFragment())
            val title = binding.etTitle.text.toString()
            val description = binding.etDescription.text.toString()
            val url = binding.etUrl.text.toString()
            lifecycleScope.launchWhenStarted {
                withContext(IO) {
                    testDao.insertItem(TestEntity(title, description, url))
                }





            }
        }


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}