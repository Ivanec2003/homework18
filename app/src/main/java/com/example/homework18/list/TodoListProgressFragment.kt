package com.example.homework18.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework18.MyAdapter
import com.example.homework18.databinding.FragmentTodoListProgressBinding

class TodoListProgressFragment : Fragment() {

    private var _binding: FragmentTodoListProgressBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ProgressViewModel
    private lateinit var adapter: MyAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodoListProgressBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        viewModel.loadData()
    }
    private fun initAdapter(){
        adapter = MyAdapter()
        binding.recyclerViewTodoList.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewTodoList.adapter = adapter
        viewModel = ViewModelProvider(this)[ProgressViewModel::class.java]
        viewModel.todoList.observe(viewLifecycleOwner){todoList->
            adapter.submitList(todoList)
        }
    }
}