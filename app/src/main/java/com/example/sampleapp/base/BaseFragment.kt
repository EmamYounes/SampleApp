package com.example.sampleapp.base

import android.os.Bundle
import android.view.View
import androidx.annotation.NonNull
import androidx.core.text.isDigitsOnly
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.navOptions
import com.example.sampleapp.R
import com.example.sampleapp.commons.ui.LoadingDialog

open class BaseFragment : Fragment() {

    private var dialog: LoadingDialog? = null


    val options = navOptions {
        anim {
            enter = R.anim.slide_in_right
            exit = R.anim.slide_out_left
            popEnter = R.anim.slide_in_left
            popExit = R.anim.slide_out_right
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog = LoadingDialog(requireContext())
    }

    fun findMyNavController(@NonNull fragment: Fragment): NavController {
        return Navigation.findNavController(fragment.requireView())
    }

    fun isDigitsOnly(value: String): Boolean {
        return value.isNotEmpty() && value.isDigitsOnly()
    }

    fun showLoading() {
        val baseActivity = activity as BaseActivity

        if (!baseActivity.isFinishing && !baseActivity.isDestroyed) {
            dialog?.show()
        }
    }

    fun dismissLoading() {
        val baseActivity = activity as BaseActivity
        if (!baseActivity.isFinishing && !baseActivity.isDestroyed) {
            dialog?.dismiss()
        }
    }

}