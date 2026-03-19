package com.example.zooapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [AnimalEntity::class], version = 1, exportSchema = false)
abstract class ZooDatabase : RoomDatabase() {
    abstract fun getAnimalDao(): AnimalDao

    companion object {
        @Volatile
        private var INSTANCE: ZooDatabase? = null

        fun getDatabase(context: Context): ZooDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ZooDatabase::class.java,
                    "zoo_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}