package com.example.myapplication.ui.flower

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDashboardBinding
import com.example.myapplication.databinding.FragmentFlowerBinding
import com.example.myapplication.ui.dashboard.DashboardViewModel
import com.example.recyclersample.Datasource
import com.example.recyclersample.FlowerAdapter

class FlowerFragment : Fragment() {

    private var _binding: FragmentFlowerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val flowerdViewModel =
            ViewModelProvider(this).get(FlowerViewModel::class.java)

        _binding = FragmentFlowerBinding.inflate(inflater, container, false)
        val root: View = binding.root


/*
        val textView: TextView = binding.textFlower
        flowerdViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
*/

        val flowerList = context?.let { Datasource(it).getFlowerList() }

        val recyclerView: RecyclerView = root.findViewById(R.id.recycler_view)
        recyclerView.adapter = flowerList?.let { FlowerAdapter(it) }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}