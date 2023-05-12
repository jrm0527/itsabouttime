package com.geez.lastofuswalkthrough.model.database

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.geez.itsabouttime.model.database.HistoryDao
import com.geez.itsabouttime.model.entities.History

class HistoryRepository(private val historyDao: HistoryDao) {

    val allHistory: LiveData<List<History>> = historyDao.getAllCollectibles()

    @WorkerThread
    suspend fun updateCollectibles(collectible: History) {
        historyDao.updateCollectibles(collectible)
    }
}