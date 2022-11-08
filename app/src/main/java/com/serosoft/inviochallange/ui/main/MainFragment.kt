package com.serosoft.inviochallange.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.serosoft.inviochallange.R
import com.serosoft.inviochallange.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mainFragment = this

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.movieList.observe(viewLifecycleOwner){
                    if (it.isNullOrEmpty()){

                    }else{
                        val adapter=MovieAdapter(it){
                            val action = MainFragmentDirections.mainToDetail()
                            findNavController().navigate(action)
                        }
                        binding.movieAdapter = adapter
                    }

                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                return false
            }


        })
    }


}

