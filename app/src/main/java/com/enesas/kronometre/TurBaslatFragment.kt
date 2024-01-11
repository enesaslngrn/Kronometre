package com.enesas.kronometre

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.enesas.kronometre.databinding.FragmentTurBaslatBinding

class TurBaslatFragment : Fragment() {

    lateinit var binding: FragmentTurBaslatBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTurBaslatBinding.inflate(inflater,container,false)

        return binding.root
    }


}