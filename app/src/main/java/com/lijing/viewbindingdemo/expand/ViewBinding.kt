package com.lijing.viewbindingdemo.expand

import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun <VB:ViewBinding>ComponentActivity.binding(inflate:(LayoutInflater)->VB) = lazy {
    inflate(layoutInflater).also { setContentView(it.root) }
}
fun <VB : ViewBinding> Fragment.binding(bind: (View) -> VB) = FragmentBindingDelegate(bind)
fun <VB : ViewBinding> Dialog.binding(inflate: (LayoutInflater) -> VB) = lazy {
    inflate(layoutInflater).also { setContentView(it.root) }
}

inline fun Fragment.doOnDestroyView(crossinline block: () -> Unit) =
    viewLifecycleOwner.lifecycle.addObserver(object : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun onDestroyView() {
            block.invoke()
        }
    })
/*继承这个接口，不要重写onDestory，防止在onDestory错误使用ViewBinding*/
interface BindingLifecycleOwner {
    fun onDestroyViewBinding(destroyingBinding: ViewBinding)
}
class FragmentBindingDelegate<VB : ViewBinding>(private val bind: (View) -> VB) : ReadOnlyProperty<Fragment, VB> {
    private var binding: VB? = null

    override fun getValue(thisRef: Fragment, property: KProperty<*>): VB {
        if (binding == null) {
            binding = bind(thisRef.requireView())
            thisRef.doOnDestroyView {
                if (thisRef is BindingLifecycleOwner) thisRef.onDestroyViewBinding(binding!!)
                binding = null
            }
        }
        return binding!!
    }
}
