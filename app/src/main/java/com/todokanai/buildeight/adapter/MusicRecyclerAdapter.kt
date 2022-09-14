package com.todokanai.buildeight.adapter

import android.media.MediaPlayer
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.todokanai.buildeight.service.ForegroundPlayService.Companion.mediaPlayer
import com.todokanai.buildeight.datatype.Music
import com.todokanai.buildeight.MusicControl
import com.todokanai.buildeight.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

class MusicRecyclerAdapter : RecyclerView.Adapter<MusicRecyclerAdapter.Holder>() {
    var musicList = mutableListOf<Music>()
    //----변수 선언--------

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return musicList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val music = musicList[position]
        holder.setMusic(music)
    }

    inner class Holder(val binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {//원래는 홀더 밖에 있어야할 클래스 구겨넣음
        var musicUri: Uri? = null

        //-----------------------
        init {
            binding.root.setOnClickListener {
            //ItemRecycler에 대해 OnClickListener 생성
                    if(mediaPlayer != null) {       //이미 재생되고있는게 있으면
                        mediaPlayer?.release()      //재생 중단후
                        mediaPlayer = null          //재생중이 아닌상태로 초기화, //재생중인 동일곡 클릭시 중단안하고 지속하는 코드 만들기 //
                    }
                mediaPlayer = MediaPlayer.create(binding.root.context, musicUri)    //mediaPlayer에 음원id(musicUri) 넣기
                MusicControl().start()                // 재생 개시
            }

        }
        //---------아이템뷰가 클릭되면 음원 재생

        fun setMusic(music: Music) {
            binding.run {
                imageAlbum.setImageURI(music.getAlbumUri())     //앨범이미지 투영
                textArtist.text = music.artist
                textTitle.text = music.title

                val duration = SimpleDateFormat("mm:ss").format(music.duration)
                textDuration.text = duration
            }
            this.musicUri = music.getMusicUri()
        }
    }
}

//뷰에 데이터를 집어넣는 과정에 관한거?