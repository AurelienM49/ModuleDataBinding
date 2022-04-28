package com.eni.mod9

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = arrayOf(Animal::class), version = 1)

abstract class AppDB : RoomDatabase() {
    abstract fun animalDAO(): AnimalDAO
    companion object {
        @Volatile
        private var INSTANCE: AppDB? = null
        fun get(ctx: Context): AppDB {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        ctx,
                        AppDB::class.java,
                        "animal_db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                    return instance
                }
                return instance
            }
        }
    }
}