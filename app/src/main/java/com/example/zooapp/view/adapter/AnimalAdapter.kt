package com.example.zooapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.zooapp.data.local.AnimalEntity
import com.example.zooapp.databinding.ItemAnimalBinding
import com.example.zooapp.utils.AnimalImageMapper

class AnimalAdapter(private val onClick: (AnimalEntity) -> Unit) :
    RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    private var animals: List<AnimalEntity> = emptyList()

    fun submitList(list: List<AnimalEntity>) {
        animals = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val binding = ItemAnimalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bind(animals[position], onClick)
    }

    override fun getItemCount(): Int = animals.size

    class AnimalViewHolder(private val binding: ItemAnimalBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(animal: AnimalEntity, onClick: (AnimalEntity) -> Unit) {
            binding.txtNombreAnimal.text = animal.nombre
            binding.txtEspecie.text = animal.especie

            val imageUrl = AnimalImageMapper.getReliableImageUrl(animal.id, animal.imagen)

            Glide.with(binding.root.context)
                .load(imageUrl)
                .placeholder(android.R.drawable.ic_menu_gallery)
                .error(android.R.drawable.ic_menu_report_image)
                .into(binding.imgAnimal)

            binding.root.setOnClickListener { onClick(animal) }
        }
    }
}
