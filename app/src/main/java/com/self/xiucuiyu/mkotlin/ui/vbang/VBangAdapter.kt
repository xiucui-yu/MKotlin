package com.self.xiucuiyu.mkotlin.ui.vbang

import android.content.Context
import android.database.Cursor
import android.provider.MediaStore
import android.view.View
import android.view.ViewGroup
import android.widget.CursorAdapter
import com.itheima.player.model.AudioBean
import com.self.xiucuiyu.mkotlin.ui.homepage.view.VBangItemView

/**
 * Created by xiucui.yu on 2018/1/6.
 */
class VBangAdapter : CursorAdapter {
    constructor(context: Context?, c: Cursor?) : super(context, c)

    override fun newView(p0: Context?, p1: Cursor?, p2: ViewGroup?): View {
        return VBangItemView(p0)
    }

    override fun bindView(p0: View?, p1: Context?, p2: Cursor?) {
        var p = p0 as VBangItemView;
        //p2 v Bean
        var bean = AudioBean
        p.setData( bean.getAudioBean(p2))

    }
}