package com.self.xiucuiyu.mkotlin.ui.vbang

import android.media.MediaPlayer
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.self.xiucuiyu.koltindemo.base.BaseFragment
import com.self.xiucuiyu.mkotlin.R
import com.self.xiucuiyu.mkotlin.utils.CursorUtil
import kotlinx.android.synthetic.main.fragment_vbang_layout.*

/**
 * Created by xiucui.yu on 2017/11/17.
 */
class VBangFragment : BaseFragment() {
    override fun initView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_vbang_layout, null)
    }

    override fun initData() {
        super.initData()
        listView.adapter
        val contentResolver = context!!.contentResolver
        val query = contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, arrayOf(MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.SIZE), null, null, null)
        CursorUtil.logCursor(query)

    }
}