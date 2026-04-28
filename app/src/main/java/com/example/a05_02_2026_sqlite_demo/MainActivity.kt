package com.example.a05_02_2026_sqlite_demo

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val dbUtil = DBUtil(this)
//        dbUtil.insertEmployeeRecords(90231,
//            "Ashish",
//            "Pune")

        Log.e("tag","------------------------")
        dbUtil.getAllEmployees()

        Log.e("tag","------------------------")
        dbUtil.deleteEmployee(90231)

        Log.e("tag","------------------------")
        dbUtil.getAllEmployees()

        Log.e("tag","------------------------")
        dbUtil.updateEmployeeRecord(12454,"Rahul","Banglore")

        Log.e("tag","------------------------")
        dbUtil.getAllEmployees()
    }
}