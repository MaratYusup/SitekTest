package com.example.mobileclient.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mobileclient.R
import com.example.mobileclient.databinding.FrSignInBinding
import com.example.mobileclient.domain.model.UserData
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
        var userDataSelected: UserData? = null
        viewModel =
            ViewModelProvider(this, viewModelFactory)[FrSignInVM::class.java]

        viewModel.getUsersList()

        viewModel.userDataList.observe(viewLifecycleOwner) {
            val items = it.userDataList?.toMutableList()?.filterNotNull() ?: listOf()
            val adapter = ArrayAdapter(requireContext(), R.layout.list_item, items)

            binding.frSignInLoginText.setAdapter(adapter)
        }

        binding.frSignInLoginText.setOnItemClickListener { adapterView, view, i, l ->
            userDataSelected = adapterView.getItemAtPosition(i) as UserData
        }

        viewModel.resultCheckLogin.observe(viewLifecycleOwner) {
            binding.frSignInLogin.error = it?.let { itTemp -> resources.getString(itTemp) }
        }

        viewModel.resultCheckPassword.observe(viewLifecycleOwner) {
            binding.frSignInPassword.error = it?.let { itTemp -> resources.getString(itTemp) }
        }

        viewModel.accessAllow.observe(viewLifecycleOwner) {
            if (it) {
                findNavController().navigate(R.id.action_frSignIn_to_frAuthorization)
            }
        }

        binding.frSignInBtnLogin.setOnClickListener {
            var userData = viewModel.compareLastSelectedUserDataAndSpinnerText(
                userData = userDataSelected,
                spinnerText = binding.frSignInLoginText.text.toString(),
            )
            
            viewModel.apply {
                checkLogin(userData.user?: "")
                checkPassword(binding.frSignInPasswordText.text.toString())

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}