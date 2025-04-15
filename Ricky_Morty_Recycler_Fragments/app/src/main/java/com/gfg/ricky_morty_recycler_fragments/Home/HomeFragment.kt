package com.gfg.ricky_morty_recycler_fragments.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gfg.ricky_morty_recycler_fragments.Data.Data
import com.gfg.ricky_morty_recycler_fragments.R
import com.gfg.ricky_morty_recycler_fragments.SimpleAdapter
import com.gfg.ricky_morty_recycler_fragments.databinding.FragmentHomeBinding
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader

class HomeFragment : BaseFragment() {

    private var _binding:FragmentHomeBinding? = null
    private val binding get() = _binding!!

    // Need to create view for Fragment
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Setting the value of _binding
        _binding = FragmentHomeBinding.inflate(inflater,container,false)

        // root refer to the parent even though root Id is not provided
        return binding.root
    }

    // After View is created we can use this
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // referenced to recycler view in the Fragment
        val recyclerView = binding.recyclerView
        val data = loadCharacterData()


        val adapter = SimpleAdapter{
            // to do when item is clicked
        }

        adapter.setData(data.results)
        recyclerView.adapter=adapter

        // Notify the Changes
        adapter.notifyDataSetChanged()

        recyclerView.adapter

    }

    private fun loadCharacterData(): Data {
        val inputStream = resources.openRawResource(R.raw.data)
        val jsonString = BufferedReader(InputStreamReader(inputStream)).use { it.readText() }
        return Gson().fromJson(jsonString, Data::class.java)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}