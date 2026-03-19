package com.example.zooapp.data.network

import com.example.zooapp.data.local.AnimalEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimalApi {
    @GET("es/animales")
    suspend fun getAllAnimals(): Response<List<AnimalEntity>>

    @GET("es/animales/{id}")
    suspend fun getAnimalDetail(@Path("id") id: Int): Response<AnimalEntity>
}