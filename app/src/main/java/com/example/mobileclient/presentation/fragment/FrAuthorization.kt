package com.example.mobileclient.presentation.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mobileclient.R
import com.example.mobileclient.databinding.FrAuthorizationBinding
import com.example.mobileclient.presentation.app.MobileClientApp

class FrAuthorization : Fragment() {
    private var _binding: FrAuthorizationBinding? = null
    private val binding get() = _binding!!

    private val component by lazy {
        (requireActivity().application as MobileClientApp).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FrAuthorizationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}