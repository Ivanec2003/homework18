package com.example.homework18.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework18.MyAdapter
import com.example.homework18.databinding.FragmentTodoDeletedTaskBinding

class TodoListDeletedTaskFragment : Fragment() {

    private var _binding: FragmentTodoDeletedTaskBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: DeletedViewModel
    private lateinit var adapter: MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodoDeletedTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        viewModel.loadData()
    }
    private fun initAdapter(){
        adapter = MyAdapter()
        binding.recyclerViewTodoListDeleted.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewTodoListDeleted.adapter = adapter
        viewModel = ViewModelProvider(this)[DeletedViewModel::class.java]
        viewModel.todoList.observe(viewLifecycleOwner){todoList->
            adapter.submitList(todoList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}