package com.example.workmanager.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("work_item")
class Work(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 1,
    @ColumnInfo
    var workName: String="",
    @ColumnInfo
    var workDes: String ="",
//    @ColumnInfo
//    var imgRs: Int = 0,
)