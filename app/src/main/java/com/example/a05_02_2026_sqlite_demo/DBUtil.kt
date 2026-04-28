package com.example.a05_02_2026_sqlite_demo

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log

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
        contentValues.put("empId", empId)
        contentValues.put("empName", empName)
        contentValues.put("empCity", empCity)

        dbHelper.insert(
            "Employee",
            null,
            contentValues
        )
        for (i in 1..5) {
            val contentValues = ContentValues()
            contentValues.put("empId", "emp $i")
            contentValues.put("empName", "emp name $i")
            contentValues.put("empCity", "emp city $i")
            dbHelper.insert("Employee", null, contentValues)
        }
    }

    fun deleteEmployee(empId: Int) {
        val numberOfRowsDeleted = dbHelper.delete(
            "Employee",
            "empId = ?",
            arrayOf(empId.toString())
        )
        Log.e("number of rows deleted is :", "$numberOfRowsDeleted")
    }

    fun updateEmployeeRecord(
        empId: Int,
        empName: String,
        empCity: String
    ) {
        val contentValues = ContentValues()
        contentValues.put("empId", empId)
        contentValues.put("empName", empName)
        contentValues.put("empCity", empCity)

        val updatedRows = dbHelper.update(
            "Employee",
            contentValues,
            "empId = ?",
            arrayOf(empId.toString())
        )
        Log.e("updated rows : ","$updatedRows")
    }

    fun getAllEmployees() {
        val employees = ArrayList<Employee>()
        val cursor = dbHelper.query(
            "Employee",
            null,
            null,
            null,
            null,
            null,
            "empId desc"
        )

        while (cursor.moveToNext()) {
            val empId = cursor.getInt(0)
            val empName = cursor.getString(1)
            val empCity = cursor.getString(2)

            val employeeObject = Employee(empId, empName, empCity)
            employees.add(employeeObject)
        }

        val length = employees.size
        Log.e("tag", "${employees.toString()}")
    }
}