package com.example.workmanager.models


import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workmanager.database.Work
import com.example.workmanager.database.WorkDaoDB
import kotlinx.coroutines.launch

class WorkListViewModel(db: WorkDaoDB, application: Application) : ViewModel() {
    private val dataDB = db

    val allExpense = dataDB.getAll()

    private var item = MutableLiveData<Work>()

    var id = MutableLiveData<Int>()

    private var _expense = MutableLiveData<Work>()

    val expense = _expense

    private suspend fun insert(item: Work) {
        dataDB.insert(item)
    }

    private suspend fun update(item: Work) {
        dataDB.update(item)
    }

    private suspend fun delete(id: Int) {
        dataDB.deleteById(id)
    }

    private suspend fun clear() {
        dataDB.clear()
    }

    fun submit(name: String, des: String) {
        viewModelScope.launch {
            item.value = Work(workName = name, workDes = "")
            insert(item.value!!)
        }
    }

    fun clearAll() {
        viewModelScope.launch {
            clear()
        }
    }

    fun deleteById(id: Int) {
        viewModelScope.launch {
            delete(id)
        }
    }

    fun setExpense() {
        viewModelScope.launch {
            _expense.value = id.value?.let { dataDB.get(it) }
        }
    }
}