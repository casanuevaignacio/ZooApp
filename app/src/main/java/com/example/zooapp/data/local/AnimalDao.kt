package com.example.zooapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AnimalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnimals(animals: List<AnimalEntity>)

    @Query("SELECT * FROM animal_table")
    fun getAllAnimals(): LiveData<List<AnimalEntity>>

    @Query("SELECT * FROM animal_table WHERE id = :id")
    fun getAnimalById(id: Int): LiveData<AnimalEntity>

    @Update
    suspend fun updateAnimal(animal: AnimalEntity)
}