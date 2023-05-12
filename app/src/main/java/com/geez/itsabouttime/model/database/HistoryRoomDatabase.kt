package com.geez.lastofuswalkthrough.model.database

import android.content.Context
import androidx.room.*
import androidx.room.TypeConverters
import com.geez.itsabouttime.model.entities.History
import com.geez.itsabouttime.util.Converters


@Database(entities = [History::class], version = 1)
@TypeConverters(Converters::class)
abstract class HistoryRoomDatabase : RoomDatabase() {

    abstract fun historyDao(): HistoryDao

    companion object{

        private var INSTANCE: HistoryRoomDatabase? = null

        /*private val MIGRATION_2_1 = object : Migration(2, 1) {
            override fun migrate(database: SupportSQLiteDatabase) {
                Log.i("Database", "2_1 completed")
            }
        }*/

        fun getDatabase(context: Context): HistoryRoomDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        HistoryRoomDatabase::class.java,
                        "history.db"
                    )
                        //.allowMainThreadQueries()
                        //.fallbackToDestructiveMigration()
                        //.addMigrations(MIGRATION_2_1a)
                        .build()
                    INSTANCE = instance

//                    instance = RoomAssetHelper.databaseBuilder(
//                        context.applicationContext,
//                        CollectiblesRoomDatabase::class.java,
//                        "collectibles.db",
//                        "database/",
//                        1,
//                        arrayOf(
//                            TablePreserve("collectibles",
//                            preserveColumns = arrayOf("collected"),
//                            matchByColumns = arrayOf("id"))
//                        ))
//                        //.addMigrations(MIGRATION_2_1)
//                        .build()
//                    INSTANCE = instance


                }
                return instance
            }
        }
    }
}