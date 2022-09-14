package com.todokanai.buildeight.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.todokanai.buildeight.databinding.FragmentPlayingControlBinding

class PlayingControlFragment : Fragment() {

    val binding by lazy{FragmentPlayingControlBinding.inflate(layoutInflater)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }
}
// This file is a dummy data
