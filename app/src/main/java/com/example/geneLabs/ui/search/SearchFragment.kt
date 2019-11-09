package com.example.geneLabs.ui.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.geneLabs.SharedViewModel
import com.example.geneLabs.databinding.FragmentSearchBinding
import com.example.geneLabs.ui.DataAdapter
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {

    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var searchViewModel: SearchViewModel
    lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sharedViewModel = activity?.run {
            ViewModelProviders.of(this)[SharedViewModel::class.java]
        } ?: throw Exception("Invalid Activity")
        binding = FragmentSearchBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@SearchFragment
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        data_recycler_view.setHasFixedSize(true)
        data_recycler_view.layoutManager = LinearLayoutManager(
            context, LinearLayoutManager.VERTICAL,
            false
        )
        data_recycler_view.adapter = DataAdapter()
        searchViewModel = ViewModelProviders.of(this)[SearchViewModel::class.java]
        binding.viewModel = searchViewModel
        search_edit_text.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //not implemented
            }

            override fun afterTextChanged(text: Editable?) {
                if (!text.isNullOrEmpty()) {
                    searchViewModel.searchResults.value =
                        sharedViewModel.getDataForSearchKey(text.toString())
                }else{
                    searchViewModel.searchResults.value = null
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //not implemented
            }
        })
    }
}