package com.example.appinfo.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.utils.ListItem

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: ListItem)
    @Delete
    suspend fun insertItem(item: ListItem)
    @Query("SELECT * FROM main WHERE category LIKE :cat")
    suspend fun getAllItemsByCategory(cat: String): List <ListItem>

}