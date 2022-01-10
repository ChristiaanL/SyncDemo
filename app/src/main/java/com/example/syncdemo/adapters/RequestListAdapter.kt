package com.example.syncdemo.adapters

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.syncdemo.MainApplication
import com.example.syncdemo.R
import com.example.syncdemo.database.models.FibRequest
import com.example.syncdemo.helpers.DBHelper
import com.example.syncdemo.viewmodels.RequestViewModel

class RequestListAdapter(val requestViewModel: RequestViewModel):RecyclerView.Adapter<RequestListAdapter.ViewHolder>()  {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.request_text.text = requestViewModel.fibDisplayedList[position].toString()
        holder.request_button.setOnClickListener {
            Log.i("request_button", "Save was pressed!")
            holder.request_button.isClickable = false
            holder.request_button.text = "Saved"
            holder.request_button.setBackgroundColor(Color.RED)
            Thread(Runnable {
                DBHelper().addFibRequest(request = FibRequest(0, requestViewModel.fibDisplayedList[position], 0))
            }).start()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.request_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return requestViewModel.fibDisplayedList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val request_text = itemView.findViewById<TextView>(R.id.request_item_value)
        val request_button = itemView.findViewById<Button>(R.id.request_item_button)
    }

}

