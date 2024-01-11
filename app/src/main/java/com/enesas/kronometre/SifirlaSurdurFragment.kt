package com.enesas.kronometre

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.enesas.kronometre.databinding.FragmentSifirlaSurdurBinding


class SifirlaSurdurFragment : Fragment() {

    lateinit var binding: FragmentSifirlaSurdurBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSifirlaSurdurBinding.inflate(inflater,container,false)

        return binding.root
    }
}