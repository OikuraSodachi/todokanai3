package com.todokanai.buildeight.datatype

import android.net.Uri
import android.provider.MediaStore

data class Music (
    var id: String, var title: String?, var artist: String?, var albumId: String?, var duration: Long?
) {
    fun getMusicUri(): Uri {
        return Uri.withAppendedPath(
            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, id     // 음원의 주소
        )
    }          //-----------음원의 Uri 주소 호출하는 함수

    fun getAlbumUri(): Uri {

        return Uri.parse(
            "content://media/external/audio/albumart/$albumId"    //앨범 이미지 주소
        )
    }
}