package com.todokanai.buildeight.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.todokanai.buildeight.databinding.FragmentPlayingBinding

class PlayingFragment : Fragment() {

    val binding by lazy { FragmentPlayingBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    //------------------------------------------------------------
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("request") { key, bundle ->
            bundle.getString("valueKey")?.let {
                Log.d("numbers","recv:$it")

            }
        }
    }
}


