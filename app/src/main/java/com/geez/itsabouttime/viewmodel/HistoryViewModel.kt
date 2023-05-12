package com.geez.itsabouttime.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.geez.itsabouttime.model.database.HistoryRepository
import com.geez.itsabouttime.model.database.HistoryRoomDatabase
import com.geez.itsabouttime.model.entities.History

class HistoryViewModel (application: Application) : ViewModel() {


    private val allHistory: LiveData<List<History>>
    private var repository: HistoryRepository

    init {
        val historyDb = HistoryRoomDatabase.getDatabase(application)
        val historyDao = historyDb.historyDao()

        repository = HistoryRepository(historyDao)
        allHistory = repository.allHistory
    }

//    fun getAllCollected(): LiveData<List<History>> {
//        return Transformations.map(allHistory) { history ->
//            history.filter {
//                it.id
//            }
//        }
//    }
//
//    fun getCollectibleType(type: String): LiveData<List<History>> {
//        return Transformations.map(allCollectibles) { collectibles ->
//            collectibles.filter {
//                it.type == type
//            }
//        }
//    }
//
//    fun getCollectedByType(type: String): LiveData<List<History>> {
//        return Transformations.map(allCollectibles) { collectibles ->
//            collectibles.filter {
//                (it.type == type && it.collected)
//            }
//        }
//    }
//
//    fun getChapterCollectibles(chapter: String): LiveData<List<History>> {
//        return Transformations.map(allCollectibles) { collectibles ->
//            collectibles.filter {
//                it.chapter == chapter
//            }
//        }
//    }
//
//    fun getChapterCollected(chapter: String): LiveData<List<History>> {
//        return Transformations.map(allCollectibles) { collectibles ->
//            collectibles.filter {
//                it.chapter == chapter && it.collected
//            }
//        }
//    }
//
//    fun getSectionCollectibles(section: String): LiveData<List<History>> {
//        return Transformations.map(allCollectibles) { collectibles ->
//            collectibles.filter {
//                it.section == section
//            }
//        }
//    }
//
//    fun getSectionCollected(section: String): LiveData<List<History>> {
//        return Transformations.map(allCollectibles) { collectibles ->
//            collectibles.filter {
//                it.section == section && it.collected
//            }
//        }
//    }
//
//    fun update(collectible: History) = viewModelScope.launch {
//        repository.updateCollectibles(collectible)
//    }
}

//class HistoryViewModelFactory(private val application: Application) : ViewModelProvider.Factory{
//
//    @Suppress("UNCHECKED_CAST")
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if(modelClass.isAssignableFrom(HistoryViewModel::class.java)){
//            return HistoryViewModel(application) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel Class")
//    }
//}