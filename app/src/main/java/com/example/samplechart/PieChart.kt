package com.example.samplechart

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.samplechart.SimplePieChart.SimplePieChart
import com.example.samplechart.dataclasses.ApiRsponsePieData
import com.google.gson.Gson
import kotlin.random.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PieChart.newInstance] factory method to
 * create an instance of this fragment.
 */
class PieChart : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val  view = inflater.inflate(R.layout.fragment_pie_chart, container, false)

        val awesomePieChart: SimplePieChart = view.findViewById<View>(R.id.piechart) as SimplePieChart

        val dataset = getSlicesData("{\"errorMessage\":null,\"payload\":{\"data\":[{\"value\":10,\"name\":\"Maintenance\"},{\"value\":2,\"name\":\"Housekeeping\"},{\"value\":1,\"name\":\"Maintenance\"},{\"value\":14,\"name\":\"Updated category\"},{\"value\":10,\"name\":\"Maintenance\"}]},\"status\":\"SUCCESS\",\"requestId\":null,\"detail\":null}")

        addDataset(awesomePieChart, dataset)

        return view
    }

    fun addDataset(pieChart: SimplePieChart, dataset: ArrayList<SimplePieChart.Slice>){
        for (i in dataset){
            pieChart.addSlice(i)
        }
    }

    fun getSlicesData(json:String) : ArrayList<SimplePieChart.Slice>{

        val list = ArrayList<SimplePieChart.Slice>()
        val apiResponselist = Gson().fromJson(json, ApiRsponsePieData::class.java)
        for (i in apiResponselist.payload!!.data){
            val rnd = Random
//            val color = Color.argb(255, rnd.nextInt(225,256), rnd.nextInt(150,206), rnd.nextInt(0,206))
            val color = (Math.random() * 16777215).toInt() or (0xFF shl 24)
            list += SimplePieChart.Slice(color, i.value!!.toFloat(), i.name!!)
        }
        return list
    }


}