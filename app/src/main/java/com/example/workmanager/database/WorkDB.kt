package com.example.workmanager.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Work::class], version = 2, exportSchema = false)
abstract class WorkDB : RoomDatabase() {
    abstract val expenseDBDao: WorkDaoDB

    companion object {
        @Volatile
        private var INSTANCE: WorkDB? = null
        fun getInstance(context: Context): WorkDB {

            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        WorkDB::class.java,
                        "expense_history_db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}