package com.lijing.viewbindingdemo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.lijing.viewbindingdemo.data.CarPrice
import com.lijing.viewbindingdemo.databinding.ActivityCarPriceListBinding
import com.lijing.viewbindingdemo.ui.adapter.CarPriceAdapter

class CarPriceListActivity:AppCompatActivity() {
    private lateinit var binding:ActivityCarPriceListBinding
    private var mCars = arrayListOf<CarPrice>()
    private var mAdapter:CarPriceAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarPriceListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        setTestData()

    }
    private fun initView(){
        binding.rlCarPriceList.layoutManager = LinearLayoutManager(this)
        mAdapter = CarPriceAdapter(mCars)
        binding.rlCarPriceList.adapter =mAdapter
    }

   private fun setTestData(){
       for(i in 0..10){
           mCars.add(CarPrice("name$i","price$i"))
       }
       mAdapter?.notifyDataSetChanged()
   }
}