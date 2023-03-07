package com.example.workmanager

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.workmanager.database.Work

@BindingAdapter("nameWork")
fun TextView.nameWork(item: Work) {
    text = context.getString(R.string.item_name, item.workName)
}
@SuppressLint("SimpleDateFormat")
@BindingAdapter("dateConsume")
fun TextView.dateConsume(item: Work) {
    text = context.getString(R.string.date_create, item.workDes)
}
//@BindingAdapter("detailItem")
//fun EditText.detailItem(item: ExpenseItem) {
//    text = Editable.
//}