package com.example.samplechart.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.samplechart.R
import com.example.samplechart.dataclasses.BarItem

class DataDescAdapter (var BarDataSet: List<BarItem>): RecyclerView.Adapter<DataDescAdapterViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataDescAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.data_desc_item, parent,  false)
        return DataDescAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataDescAdapterViewHolder, position: Int) {
        val barItem = BarDataSet[position]
        holder.label.text = barItem.label
        holder.bar.text = barItem.value.toString()

    }

    override fun getItemCount(): Int {
        return  BarDataSet.size
    }

    fun setData( BarDataSet: ArrayList<BarItem>){
        this.BarDataSet = BarDataSet
        notifyDataSetChanged()
    }

}

class DataDescAdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    val bar = itemView.findViewById<TextView>(R.id.dataValue)
    val label = itemView.findViewById<TextView>(R.id.dataLabel)
}
