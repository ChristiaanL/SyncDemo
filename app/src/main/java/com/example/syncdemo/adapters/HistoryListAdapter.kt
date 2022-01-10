package com.example.syncdemo.adapters

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.syncdemo.R
import com.example.syncdemo.database.models.FibRequest
import com.example.syncdemo.helpers.DBHelper
import com.example.syncdemo.viewmodels.HistoryViewModel
import com.example.syncdemo.viewmodels.RequestViewModel

class HistoryListAdapter(val historyViewModel: HistoryViewModel):RecyclerView.Adapter<HistoryListAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i("onBindViewHolder", "Value: ${historyViewModel.historyList[position].value}")
        holder.history_text.text = historyViewModel.historyList[position].value.toString()
        holder.history_time.text = historyViewModel.historyList[position].requestTime.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.history_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return historyViewModel.historyList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var history_text = itemView.findViewById<TextView>(R.id.history_item_value)
        var history_time = itemView.findViewById<TextView>(R.id.history_item_time)
    }

}