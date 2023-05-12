package com.geez.itsabouttime.model.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.geez.itsabouttime.model.entities.History

@Dao
interface HistoryDao {

    @Update
    suspend fun updateCollectibles(history: History)

    @Query("SELECT * FROM history ORDER BY ID")
    fun getAllCollectibles(): LiveData<List<History>>

}
