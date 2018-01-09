package com.self.xiucuiyu.mkotlin.ui.vbang

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.net.rtp.AudioStream
import android.os.IBinder
import com.itheima.player.model.AudioBean
import com.self.xiucuiyu.koltindemo.base.BaseActivity
import com.self.xiucuiyu.mkotlin.R

/**
 * Created by xiucui.yu on 2018/1/6.
 */
class AudioPlayerActivity : BaseActivity() {

    var myServiceConnection: AudioConnection? = null

    override fun getLayoutId(): Int {
        return R.layout.audio_detail_layout
    }

    override fun initData() {
        super.initData()
        var parcelableArrayExtra = intent.getParcelableArrayExtra("list")
        var intExtra = intent.getIntExtra("position", 0)

       var intentService = Intent(this, VbangService::class.java)
        intentService.putExtra("list",parcelableArrayExtra)
        intentService.putExtra("position",intExtra)
        myServiceConnection = AudioConnection()
        bindService(intentService, myServiceConnection, Context.BIND_AUTO_CREATE);
        startService(intentService)
    }

    class AudioConnection : ServiceConnection {
        //意外断开连接的时候
        override fun onServiceDisconnected(name: ComponentName?) {

        }
        //连接的时候
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            var service = service as IService
            service.onPrepared()

        }

    }

    fun stop() {
        unbindService(myServiceConnection);
    }
}