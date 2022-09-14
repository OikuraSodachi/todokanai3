package com.todokanai.buildeight.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.todokanai.buildeight.databinding.FragmentPlayingAlbumBinding

class PlayingAlbumFragment : Fragment() {

    val binding by lazy{FragmentPlayingAlbumBinding.inflate(layoutInflater)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
}