package com.example.samplechart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anychart.core.gauge.pointers.Bar
import com.example.samplechart.adapters.BarDataAdapter
import com.example.samplechart.adapters.DataDescAdapter
import com.example.samplechart.dataclasses.ApiResponse
import com.example.samplechart.dataclasses.BarItem
import com.google.gson.Gson

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [audit_stats.newInstance] factory method to
 * create an instance of this fragment.
 */
class audit_stats : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_audit_stats, container, false)

        val barView = view.findViewById<RecyclerView>(R.id.bar_view)
        val dataDescView = view.findViewById<RecyclerView>(R.id.data_desc_view)




        val apiResponse =
            "{\"errorMessage\":null,\"payload\":[{\"auditDate\":\"01-Aug\",\"auditsCount\":0},{\"auditDate\":\"02-Aug\",\"auditsCount\":0},{\"auditDate\":\"03-Aug\",\"auditsCount\":2},{\"auditDate\":\"04-Aug\",\"auditsCount\":1},{\"auditDate\":\"05-Aug\",\"auditsCount\":0},{\"auditDate\":\"06-Aug\",\"auditsCount\":3},{\"auditDate\":\"07-Aug\",\"auditsCount\":2},{\"auditDate\":\"08-Aug\",\"auditsCount\":6},{\"auditDate\":\"09-Aug\",\"auditsCount\":1},{\"auditDate\":\"10-Aug\",\"auditsCount\":1},{\"auditDate\":\"11-Aug\",\"auditsCount\":3},{\"auditDate\":\"12-Aug\",\"auditsCount\":1},{\"auditDate\":\"13-Aug\",\"auditsCount\":1},{\"auditDate\":\"14-Aug\",\"auditsCount\":0},{\"auditDate\":\"15-Aug\",\"auditsCount\":0},{\"auditDate\":\"16-Aug\",\"auditsCount\":2},{\"auditDate\":\"17-Aug\",\"auditsCount\":0},{\"auditDate\":\"18-Aug\",\"auditsCount\":3},{\"auditDate\":\"19-Aug\",\"auditsCount\":0},{\"auditDate\":\"20-Aug\",\"auditsCount\":3},{\"auditDate\":\"21-Aug\",\"auditsCount\":0},{\"auditDate\":\"22-Aug\",\"auditsCount\":4},{\"auditDate\":\"23-Aug\",\"auditsCount\":0},{\"auditDate\":\"24-Aug\",\"auditsCount\":4},{\"auditDate\":\"25-Aug\",\"auditsCount\":4},{\"auditDate\":\"26-Aug\",\"auditsCount\":5},{\"auditDate\":\"27-Aug\",\"auditsCount\":0},{\"auditDate\":\"28-Aug\",\"auditsCount\":0},{\"auditDate\":\"29-Aug\",\"auditsCount\":6},{\"auditDate\":\"30-Aug\",\"auditsCount\":3},{\"auditDate\":\"31-Aug\",\"auditsCount\":1}],\"status\":\"SUCCESS\",\"requestId\":null,\"detail\":null}"



        val apiResponselist = Gson().fromJson(apiResponse.toString(), ApiResponse::class.java)
        val BarDataSet = getData(apiResponselist)
        val DataDescSet = ArrayList<BarItem>()


        val BarViewAdapter = BarDataAdapter(BarDataSet)
        val DataDescViewAdapter = DataDescAdapter(BarDataSet)

        barView.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        dataDescView.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)

        BarViewAdapter.setData(BarDataSet)
        DataDescViewAdapter.setData(DataDescSet)


        barView.adapter = BarViewAdapter
        dataDescView.adapter = DataDescViewAdapter





        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment audit_stats.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            audit_stats().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    fun getData(apiResponse: ApiResponse): ArrayList<BarItem>{
        val returnlist = ArrayList<BarItem>()
        val arrayList = apiResponse.payload
        for (i in arrayList){
            returnlist.add(BarItem(i.auditsCount, i.auditDate))

        }

        return  returnlist



    }
}

//polling