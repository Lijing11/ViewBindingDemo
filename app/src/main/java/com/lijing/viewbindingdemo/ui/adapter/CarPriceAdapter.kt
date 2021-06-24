package com.lijing.viewbindingdemo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.lijing.viewbindingdemo.R
import com.lijing.viewbindingdemo.data.CarPrice
import com.lijing.viewbindingdemo.databinding.ItemCarPriceBinding

class CarPriceAdapter(var list: List<CarPrice>): RecyclerView.Adapter<CarPriceViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarPriceViewHolder {
        return CarPriceViewHolder(ItemCarPriceBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: CarPriceViewHolder, position: Int) {

       holder.binding.tvCarName.text=list[position]?.name
       holder.binding.tvCarPrice.text=list[position]?.price
    }

    override fun getItemCount(): Int {
       return list.size
    }
}
class CarPriceViewHolder(val binding:ItemCarPriceBinding):RecyclerView.ViewHolder(binding.root){

}