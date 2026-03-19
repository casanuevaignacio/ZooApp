package com.example.zooapp.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.zooapp.databinding.FragmentDetailBinding
import com.example.zooapp.viewmodel.AnimalViewModel

class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(requireActivity())[AnimalViewModel::class.java]

        viewModel.getDetail(args.animalId).observe(viewLifecycleOwner) { animal ->
            animal?.let {
                binding.tvDetailName.text = it.nombre
                binding.tvDetailDescription.text = it.descripcion
                Glide.with(this).load(it.imagen).into(binding.ivDetailAnimal)

                binding.btnEmailInfo.setOnClickListener {
                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:info@tuzoologico.com")
                        putExtra(Intent.EXTRA_SUBJECT, "Consulta sobre ${animal.nombre}")
                        putExtra(Intent.EXTRA_TEXT, "Hola, me gustaría recibir más info de este animal.")
                    }
                    startActivity(Intent.createChooser(intent, "Enviar consulta"))
                }
            }
        }
        viewModel.fetchDetailApi(args.animalId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}