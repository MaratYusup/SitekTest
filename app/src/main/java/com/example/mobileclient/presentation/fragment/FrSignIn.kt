package com.example.mobileclient.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mobileclient.R
import com.example.mobileclient.databinding.FrSignInBinding
import com.example.mobileclient.presentation.app.MobileClientApp
import com.example.mobileclient.presentation.viewmodel.FrSignInVM
import com.example.mobileclient.presentation.viewmodel.ViewModelFactory
import javax.inject.Inject

class FrSignIn : Fragment() {
    private var _binding: FrSignInBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: FrSignInVM
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

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
        _binding = FrSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel =
            ViewModelProvider(this, viewModelFactory)[FrSignInVM::class.java]

        viewModel.getUsersList()

        viewModel.userDataList.observe(viewLifecycleOwner) {userDataWithResp ->
            var items = userDataWithResp.userDataList?.map{
                it?.user
            }
            items = items?.filterNotNull()  ?: listOf()
            val adapter = ArrayAdapter(requireContext(), R.layout.list_item, items)
            binding.frSignInLoginText.setAdapter(adapter)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}