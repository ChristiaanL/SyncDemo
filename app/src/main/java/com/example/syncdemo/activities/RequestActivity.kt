package com.example.syncdemo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Size
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.syncdemo.R
import com.example.syncdemo.adapters.RequestListAdapter
import com.example.syncdemo.viewmodels.RequestViewModel

class RequestActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    var sequenceLength = 1
    var viewModel = RequestViewModel()
    val adapter = RequestListAdapter(this.viewModel)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request)
        setupListeners()
        calculateFibSequence()

        val recyclerView = findViewById<RecyclerView>(R.id.requests_recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    private fun setupListeners(){
        val spinner: Spinner = findViewById(R.id.sequence_length_spinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.sequence_length_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
        spinner.onItemSelectedListener = this

        val requestButton: Button = findViewById(R.id.request_button)
        requestButton.setOnClickListener {
            this.sendRequest()
        }
        val historyButton: Button = findViewById(R.id.history_activity_button)
        historyButton.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            this.startActivity(intent)
        }
    }

    private fun calculateFibSequence(){
        var fibList = this.viewModel.fibSequence
        if(fibList.size < 2){
            fibList = mutableListOf(0, 1)
        }
        while(fibList.last() <= 99999999){
            val nextValue = fibList[fibList.size - 1] + fibList[fibList.size - 2]
            fibList.add(nextValue)
        }
        this.viewModel.fibSequence = fibList
    }

    private fun sendRequest(){
        val list = this.viewModel.fibSequence
        val displayList = mutableListOf<Int>()
        for(item in list){
            if(item.toString().length == this.sequenceLength) {
                displayList.add(item)
            }
        }
        this.viewModel.fibDisplayedList = displayList
        this.adapter.notifyDataSetChanged()
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        this.sequenceLength = p2 + 1
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {}
}