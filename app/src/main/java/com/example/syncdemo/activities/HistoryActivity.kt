package com.example.syncdemo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.syncdemo.R
import com.example.syncdemo.adapters.HistoryListAdapter
import com.example.syncdemo.adapters.RequestListAdapter
import com.example.syncdemo.database.models.FibRequest
import com.example.syncdemo.helpers.DBHelper
import com.example.syncdemo.viewmodels.HistoryViewModel
import com.example.syncdemo.viewmodels.RequestViewModel

class HistoryActivity : AppCompatActivity() {

    var viewModel = HistoryViewModel()
    val adapter = HistoryListAdapter(this.viewModel)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val requestButton: Button = findViewById(R.id.request_activity_button)
        requestButton.setOnClickListener {
            val intent = Intent(this, RequestActivity::class.java)
            this.startActivity(intent)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.history_recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val loadHistoryButton: Button = findViewById(R.id.load_history_button)
        loadHistoryButton.setOnClickListener {
        }

        Thread(Runnable {
            viewModel.historyList = DBHelper().getAllFibRequests()
            Log.i("History Loaded", "History List: ${viewModel.historyList}")
            this.adapter.notifyDataSetChanged()
        }).start()


    }
}