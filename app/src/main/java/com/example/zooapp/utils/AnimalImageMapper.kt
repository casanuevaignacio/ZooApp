package com.example.zooapp.utils

object AnimalImageMapper {
    fun getReliableImageUrl(animalId: Int, originalUrl: String?): String {
        // If originalUrl is valid and not from broken ibb.co service, use it; otherwise map by ID
        if (!originalUrl.isNullOrEmpty() && !originalUrl.contains("ibb.co")) {
            return originalUrl
        }
        return when (animalId) {
            1 -> "https://images.unsplash.com/photo-1541781774459-bb2af2f05b55?w=800" // Tigre
            2 -> "https://images.unsplash.com/photo-1589465849834-9b6344381844?w=800" // Oso Polar
            3 -> "https://images.unsplash.com/photo-1557050543-4d5f4e07ef46?w=800" // Elefante
            4 -> "https://images.unsplash.com/photo-1534188753412-3e26d0d618d6?w=800" // León
            5 -> "https://images.unsplash.com/photo-1547721064-da6cfb341d50?w=800" // Jirafa
            6 -> "https://images.unsplash.com/photo-1518717758536-85ae29035b6d?w=800" // Cebra
            7 -> "https://images.unsplash.com/photo-1540573133985-87b6da6d54a9?w=800" // Chimpancé
            8 -> "https://images.unsplash.com/photo-1598439210625-5067c578f3f6?w=800" // Pingüino
            9 -> "https://images.unsplash.com/photo-1564349683136-77e08dba1ef7?w=800" // Panda
            10 -> "https://images.unsplash.com/photo-1497206376708-069990f4ea73?w=800" // Flamenco
            else -> "https://images.unsplash.com/photo-1534567153574-2b12153a87f0?w=800"
        }
    }
}
