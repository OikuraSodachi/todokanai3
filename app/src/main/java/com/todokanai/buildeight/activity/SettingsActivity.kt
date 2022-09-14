package com.todokanai.buildeight.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.todokanai.buildeight.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    val binding by lazy { ActivitySettingsBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //여기까지는 기본 양식

        /*
        val intentclose = Intent(ForegroundPlayService.ACTION_PAUSE_PLAY)  // Foreground의 PAUSE_PLAY 실행 인텐트
        sendBroadcast(intentclose)                                      // 브로드캐스트 발신
         */

        val intentmain = Intent(this,MainActivity::class.java)
        binding.Backbtn.setOnClickListener {startActivity(intentmain)} //Backbtn에 대한 동작
    }
    //onCreate 끝
}
// This file is a dummy data