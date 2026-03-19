package com.example.zooapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zooapp.databinding.FragmentListBinding
import com.example.zooapp.view.adapter.AnimalAdapter
import com.example.zooapp.viewmodel.AnimalViewModel

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AnimalViewModel
    private lateinit var adapter: AnimalAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(AnimalViewModel::class.java)

        setupRecyclerView()

        // Observar LiveData de Room
        viewModel.animalList.observe(viewLifecycleOwner) { animals ->
            adapter.submitList(animals)
        }

        // Cargar datos nuevos de la API
        viewModel.fetchAnimals()
    }

    private fun setupRecyclerView() {
        adapter = AnimalAdapter { animal ->
            // Navegación con SafeArgs pasando el ID
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(animal.id)
            findNavController().navigate(action)
        }
        binding.rvAnimals.layoutManager = LinearLayoutManager(requireContext())
        binding.rvAnimals.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}