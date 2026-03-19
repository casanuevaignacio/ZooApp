package com.example.zooapp

import com.example.zooapp.data.local.AnimalEntity
import org.junit.Test
import org.junit.Assert.*

class AnimalMappingTest {
    @Test
    fun test_animalEntity_creation_is_correct() {
        val animal = AnimalEntity(1, "Cóndor", "Vultur gryphus", "Andes", "Carroñero", "url_imagen")
        assertEquals(1, animal.id)
        assertEquals("Cóndor", animal.nombre)
        assertEquals("Vultur gryphus", animal.especie)
    }
}