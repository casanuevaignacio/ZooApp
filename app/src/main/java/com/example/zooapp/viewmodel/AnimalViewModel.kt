package com.example.zooapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.zooapp.data.local.AnimalEntity
import com.example.zooapp.data.local.ZooDatabase
import com.example.zooapp.data.network.RetrofitClient
import kotlinx.coroutines.launch

class AnimalViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = ZooDatabase.getDatabase(application).getAnimalDao()
    private val api = RetrofitClient.api

    val animalList: LiveData<List<AnimalEntity>> = dao.getAllAnimals()

    fun getDetail(id: Int): LiveData<AnimalEntity> = dao.getAnimalById(id)

    fun fetchAnimals() = viewModelScope.launch {
        val response = api.getAllAnimals()
        if (response.isSuccessful) response.body()?.let { dao.insertAnimals(it) }
    }

    fun fetchDetailApi(id: Int) = viewModelScope.launch {
        val response = api.getAnimalDetail(id)
        if (response.isSuccessful) response.body()?.let { dao.updateAnimal(it) }
    }
}