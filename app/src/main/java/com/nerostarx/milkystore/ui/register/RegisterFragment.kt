package com.nerostarx.milkystore.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.nerostarx.milkystore.databinding.RegisterFragmentBinding

class RegisterFragment : Fragment() {

    private val viewModel: RegisterViewModel by activityViewModels()
    private lateinit var binding: RegisterFragmentBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        binding = RegisterFragmentBinding.inflate(layoutInflater, container,false)
        return binding.root
    }



}