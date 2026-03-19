package com.example.zooapp.data.local



import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "animal_table")
data class AnimalEntity(
    @PrimaryKey val id: Int,
    val nombre: String,
    val especie: String,
    val habitat: String,
    val dieta: String,
    val imagen: String,
    val descripcion: String? = "",
    val estadoDeConservacion: String? = ""
)