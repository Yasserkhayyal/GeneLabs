package com.example.geneLabs.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.geneLabs.SharedViewModel
import com.example.geneLabs.databinding.FragmentHomeBinding
import com.example.geneLabs.ui.DataAdapter
import com.example.geneLabs.ui.RecyclerItemClickListener

class HomeFragment : Fragment(), RecyclerItemClickListener.OnRecyclerClickListener {

    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var binding: FragmentHomeBinding
    lateinit var recyclerItemClickListener: RecyclerItemClickListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sharedViewModel = activity?.run {
            ViewModelProviders.of(this)[SharedViewModel::class.java]
        } ?: throw Exception("Invalid Activity")
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false).apply {
            lifecycleOwner = this@HomeFragment
            viewModel = sharedViewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.dataRecyclerView.layoutManager = LinearLayoutManager(
            context, LinearLayoutManager.VERTICAL,
            false
        )
        binding.dataRecyclerView.adapter = DataAdapter()
        context?.let {
            recyclerItemClickListener =
                RecyclerItemClickListener(it, binding.dataRecyclerView, this)
            binding.dataRecyclerView.removeOnItemTouchListener(recyclerItemClickListener)//to prevent adding it multiple times
            binding.dataRecyclerView.addOnItemTouchListener(recyclerItemClickListener)
        }
        sharedViewModel.getData()
    }

    override fun onItemClick(view: View, position: Int) {
        val adapter = binding.dataRecyclerView.adapter as DataAdapter
        val action = HomeFragmentDirections.actionNavigationHomeToNavigationDetails(
            adapter.getDataItemAtPosition(position)!!.source.studyPerson
        )
        view.findNavController().navigate(action)
    }

    override fun onItemLongClick(view: View, position: Int) {
        //not implemented
    }
}