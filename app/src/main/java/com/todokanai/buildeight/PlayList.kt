package com.todokanai.buildeight

import android.content.Context
import android.util.Log
import com.todokanai.buildeight.datatype.Music

class PlayList (val context: Context?) {
    val mscan=MusicTool(context).scanMusicList()
    var list = mutableListOf<Music>()

    fun act() {
        list.addAll(mscan)
        list.sortByDescending { it.title }
        val b = list.size
        for (a in 1..b) {
            Log.d("tester2", "${list[a - 1].title}")
        }
        Log.d("tester2", "$b")
    }
}

// PlayList: 재생목록