package com.todokanai.buildeight

import android.content.Context
import android.provider.MediaStore
import com.todokanai.buildeight.datatype.Music

class MusicTool (context: Context?){
    var context: Context? = null
    val myContext = context

    fun scanMusicList(): List<Music> {
        // 1. 음원 정보 주소
        val listUrl = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI    // URI 값을 주면 나머지 데이터 모아옴
        // 2. 음원 정보 자료형 정의
        val proj = arrayOf(
            MediaStore.Audio.Media._ID,
            MediaStore.Audio.Media.TITLE,
            MediaStore.Audio.Media.ARTIST,
            MediaStore.Audio.Media.ALBUM_ID,
            MediaStore.Audio.Media.DURATION
        )
        // 3. 컨텐트리졸버의 쿼리에 주소와 컬럼을 입력하면 커서형태로 반환받는다
        val cursor = myContext?.contentResolver?.query(listUrl, proj, null, null, null)
        val musicList = mutableListOf<Music>()
        while (cursor?.moveToNext() == true) {
            val id = cursor.getString(0)
            val title = cursor.getString(1)
            val artist = cursor.getString(2)
            val albumId = cursor.getString(3)
            val duration = cursor.getLong(4)

            val music = Music(id, title, artist, albumId, duration)
            musicList.add(music)
        }
        cursor?.close()
        musicList.sortByDescending { it.title }       // 제목기준으로 정렬
        return musicList    // music 전체 반환
    }
}