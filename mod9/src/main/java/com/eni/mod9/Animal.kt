package com.eni.mod9

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Animal(
    @PrimaryKey(autoGenerate=true)
    val id:Long,
    val espece:String,
    val nom:String,
    val poids:Int,
)
