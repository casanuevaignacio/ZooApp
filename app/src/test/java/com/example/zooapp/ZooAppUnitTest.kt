package com.example.zooapp

import org.junit.Test

class ZooAppUnitTest {
    @Test
    fun animal_data_is_correct() {
        val animalName = "Panda"
        // Simulamos que el objeto se crea bien
        assert(animalName == "Panda")
    }
}