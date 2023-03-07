package com.example.workmanager.database




import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface  WorkDaoDB {
    @Insert
    suspend fun insert(expenseItem: Work)
    @Update
    suspend fun update(expenseItem: Work)
    @Delete
    suspend fun delete(expenseItem: Work)

    @Query("DELETE FROM work_item WHERE id= :id")
    suspend fun deleteById(id : Int)

    @Query("DELETE FROM work_item")
    suspend fun clear()

    @Query("SELECT * FROM work_item")
    fun getAll() : LiveData<List<Work>>

    @Query("SELECT * FROM  work_item WHERE id= :id")
    suspend fun get(id: Int) : Work

    @Query("SELECT * FROM  work_item WHERE id= :id")
    fun getWithId(id: Int) : LiveData<Work>
}
