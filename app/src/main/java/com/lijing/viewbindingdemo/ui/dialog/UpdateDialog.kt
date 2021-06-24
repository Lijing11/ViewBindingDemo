package com.lijing.viewbindingdemo.ui.dialog

import android.app.Dialog
import android.content.Context
import com.lijing.viewbindingdemo.databinding.DialogUpdateBinding

class UpdateDialog(context: Context): Dialog(context) {
    private var binding:DialogUpdateBinding = DialogUpdateBinding.inflate(layoutInflater)
//    private  val  binding by binding (DialogUpdateBinding::inflate)
    init {
        setContentView(binding.root)
        binding.tvDialogTitle.text = "dialog title"
    }

}