package com.todokanai.buildeight

import android.util.Log
import com.todokanai.buildeight.datatype.Music
import com.todokanai.buildeight.service.ForegroundPlayService.Companion.mediaPlayer

class MusicControl {

    var mCurrent: Music? = null     // 현재 재생중인 곡
    var mPrev : Music? = null       // 이전곡
    var mNext : Music? = null       // 다음곡

    fun replay() {
        Log.d("tester","repeat Button activated")
    }       // 반복재생
    fun prev(){
        Log.d("tester","prev Button activated")
    }       // 이전곡
    fun pauseplay(){
        Log.d("tester","pauseplay Button activated")
        if(mediaPlayer!!.isPlaying){
            mediaPlayer?.pause()
        }else{
            mediaPlayer?.start()
        }
    }       // 일시정지,재생
    fun next(){
        Log.d("tester","next Button activated")
    }       // 다음곡
    fun close() {
        mediaPlayer?.release()
        Log.d("tester","close Button activated")
    }       // 종료
    fun start() {
        if(mediaPlayer !=null)
            mediaPlayer?.start()
    }

}