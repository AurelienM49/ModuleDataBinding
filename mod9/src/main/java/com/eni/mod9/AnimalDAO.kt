package com.eni.mod9

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AnimalDAO {
    @Insert
    fun insert(animal: Animal)


    @Query("SELECT * FROM Animal")
    fun getAll(): List<Animal>












}