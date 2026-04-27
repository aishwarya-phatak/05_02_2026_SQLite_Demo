package com.example.a05_02_2026_sqlite_demo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DBHelper(context : Context?,
    name : String?,
    factory : SQLiteDatabase.CursorFactory?,
    version : Int) : SQLiteOpenHelper(context,name,factory,version) {

    override fun onCreate(db: SQLiteDatabase?) {
        Log.e("tag","abstract -- onCreate method called")
        db?.execSQL("Create Table IF NOT EXISTS Employee(" +
                "empId Int PRIMARY KEY," +
                "empName String,empCity String);")
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        Log.e("tag","abstract -- onUpgrade method called")
    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        super.onDowngrade(db, oldVersion, newVersion)
        Log.e("tag","onDownGrade method called")
    }
}