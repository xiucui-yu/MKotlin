package com.self.xiucuiyu.mkotlin.ui.vbang

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.view.Surface
import android.widget.Toast
import com.itheima.player.model.AudioBean

/**
 * Created by xiucui.yu on 2018/1/9.
 */
class VbangService : Service() {
    val mediaPlayer by lazy { MediaPlayer() }
    val playBinder by lazy { MusicBind() }
    var audioList?=null
    var position: Int? = 0
    override fun onBind(intent: Intent?): IBinder {
        return playBinder;
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        audioList = intent?.getParcelableArrayExtra("list")
        position = intent?.getIntExtra("position", -1)
        playBinder.playItem()
        return super.onStartCommand(intent, flags, startId)
    }


    inner class MusicBind : Binder(), IService {
        override fun onPrepared() {
            mediaPlayer.setOnPreparedListener {
                mediaPlayer.start()
            }
        }

        fun playItem() {
            mediaPlayer.setDataSource(position?.let { audioList?.get(it)?.data })
            //mediaPlayer.setSurface(Surface(p0))
            mediaPlayer.prepareAsync()

        }

    }

}