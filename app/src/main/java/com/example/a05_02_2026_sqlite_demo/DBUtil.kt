package com.example.a05_02_2026_sqlite_demo

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class DBUtil(context: Context) {
    var dbHelper: SQLiteDatabase = DBHelper(
        context,
        "db_bitcode",
        null,
        1
    ).writableDatabase

    fun insertEmployeeRecords(
        empId: Int,
        empName: String,
        empCity: String
    ) {
        val contentValues = ContentValues()
        contentValues.put("empId",empId)
        contentValues.put("empName",empName)
        contentValues.put("empCity",empCity)

        dbHelper.insert("Employee",
            null,
            contentValues)
        for(i in 1..5){
            val contentValues = ContentValues()
            contentValues.put("empId","emp $i")
            contentValues.put("empName","emp name $i")
            contentValues.put("empCity","emp city $i")
        }
    }

    fun deleteEmployee(empId : Int){

    }

    fun updateEmployeeRecord(empId : Int,
                             empName : String,
                             empCity : String){

    }

    fun getAllEmployees(){

    }
}