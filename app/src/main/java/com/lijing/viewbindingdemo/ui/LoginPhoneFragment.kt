package com.lijing.viewbindingdemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.lijing.viewbindingdemo.R
import com.lijing.viewbindingdemo.databinding.FragmentLoginPhoneBinding

class LoginPhoneFragment : Fragment(R.layout.fragment_login_phone) {

    //    private val binding:FragmentLoginPhoneBinding by binding(FragmentLoginPhoneBinding::bind)
    private var binding: FragmentLoginPhoneBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val _binding = FragmentLoginPhoneBinding.inflate(inflater, container, false)
        binding = _binding
        return _binding.root
    }

    override fun onDestroyView() {
        //Fragment 的存在时间比其视图长。请务必在 Fragment 的 onDestroyView() 方法中清除对绑定类实例的所有引用
        binding = null
        super.onDestroyView()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.tvTitle?.setOnClickListener {
            Toast.makeText(
                context,
                "Click View",
                Toast.LENGTH_LONG
            ).show()
        }
    }


}