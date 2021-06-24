package com.lijing.viewbindingdemo.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.lijing.viewbindingdemo.R
import com.lijing.viewbindingdemo.databinding.ActivityLoginBinding

class LoginActivity:AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView(){
        supportFragmentManager.beginTransaction().replace(binding.flLoginContainer.id,LoginPhoneFragment()).commitAllowingStateLoss()
    }
}