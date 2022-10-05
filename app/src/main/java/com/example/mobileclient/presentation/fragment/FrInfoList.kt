package com.example.mobileclient.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobileclient.databinding.FrInfoListBinding
import com.example.mobileclient.databinding.FrSignInBinding
import com.example.mobileclient.domain.model.UserAuthDataModel
import com.example.mobileclient.presentation.app.MobileClientApp
import com.example.mobileclient.presentation.recyclerview.RwFrInfoListAdapter
import com.example.mobileclient.presentation.viewmodel.FrInfoListVM
import com.example.mobileclient.presentation.viewmodel.FrSignInVM
import com.example.mobileclient.presentation.viewmodel.ViewModelFactory
import javax.inject.Inject

class FrInfoList : Fragment() {
    private var _binding: FrInfoListBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<FrInfoListArgs>()
    private lateinit var viewModel: FrInfoListVM

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as MobileClientApp).component
            .fragmentComponentFactory()
            .create(uid = args.uid)
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FrInfoListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel =
            ViewModelProvider(this, viewModelFactory)[FrInfoListVM::class.java]

        val rvAdapter = RwFrInfoListAdapter(
            requireContext(),
        )
        binding.recyclerViewInfoList.adapter = rvAdapter
        binding.recyclerViewInfoList.layoutManager = LinearLayoutManager(requireContext())

        viewModel.userAuthData.observe(viewLifecycleOwner) {
            if (it?.user != null && it.user != "") {
                binding.textViewText.text = it.user
                rvAdapter.userAuthDataInfoList = viewModel.createUserAuthDataInfo(it)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}