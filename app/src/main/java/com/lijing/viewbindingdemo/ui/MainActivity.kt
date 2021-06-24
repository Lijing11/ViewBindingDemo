package com.lijing.viewbindingdemo.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lijing.viewbindingdemo.databinding.ActivityMainBinding
import com.lijing.viewbindingdemo.databinding.LayoutTitleBarBinding

class MainActivity: AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
//    private val binding by binding(ActivityMainBinding::inflate)
    private lateinit var titleBarBinding: LayoutTitleBarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        titleBarBinding = LayoutTitleBarBinding.bind(binding.root)
        initView()
        setListener()
    }
    private fun initView(){
      binding.tvActBinding.text ="changed content"
    }
    private fun setListener(){
      binding.tvActLogin.setOnClickListener {
          startActivity(Intent(this,LoginActivity::class.java))
      }
      binding.tvActCarList.setOnClickListener {
          startActivity(Intent(this,CarPriceListActivity::class.java))
      }
        titleBarBinding.tvTitle.setOnClickListener {
            Toast.makeText(this,"title click",Toast.LENGTH_LONG).show()
        }
    }

}