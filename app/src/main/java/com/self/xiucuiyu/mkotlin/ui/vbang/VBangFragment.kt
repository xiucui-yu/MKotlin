package com.self.xiucuiyu.mkotlin.ui.vbang

import android.Manifest
import android.annotation.SuppressLint
import android.content.AsyncQueryHandler
import android.content.Intent
import android.database.Cursor
import android.media.MediaPlayer
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import com.itheima.player.model.AudioBean
import com.self.xiucuiyu.koltindemo.base.BaseFragment
import com.self.xiucuiyu.mkotlin.R
import com.self.xiucuiyu.mkotlin.utils.CursorUtil
import kotlinx.android.synthetic.main.fragment_vbang_layout.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * Created by xiucui.yu on 2017/11/17.
 *
 * asyncTask
 *
 * 系统还针对数据查询数据库提供的类   AsyncQueryHandler(异步数据库查询)
 *
 *
 */
class VBangFragment : BaseFragment() {
    override fun initView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_vbang_layout, null)
    }

    private lateinit var vBangAdapter: VBangAdapter;
    override fun initData() {
        super.initData()
        loadSongs()
    }

    private fun loadSongs() {
        vBangAdapter = VBangAdapter(context, null)
        listView.adapter = vBangAdapter;
        listView.setOnItemClickListener { parent, view, position, id ->
            var cursor = parent.adapter.getItem(position)
            val audioBeans = AudioBean.getAudioBeans(cursor as Cursor?)
            startActivity<AudioPlayerActivity>("list" to audioBeans, "position" to position)
        }
        ActivityCompat.requestPermissions(this!!.activity!!,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 0);
        val contentResolver = context!!.contentResolver
        var handler = object : AsyncQueryHandler(contentResolver) {
            override fun onQueryComplete(token: Int, cookie: Any?, cursor: Cursor?) {
                super.onQueryComplete(token, cookie, cursor)
                if (cursor != null) {
                    vBangAdapter.swapCursor(cursor)
                }
            }

        }
        handler.startQuery(0, null, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, arrayOf(MediaStore.Audio.Media._ID, MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.SIZE, MediaStore.Audio.Media.DISPLAY_NAME, MediaStore.Audio.Media.ARTIST), null, null, null)
    }

    override fun onDestroy() {
        super.onDestroy()

        vBangAdapter.changeCursor(null)
    }
}