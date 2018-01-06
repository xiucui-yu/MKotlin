package com.self.xiucuiyu.mkotlin.ui.homepage.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.itheima.player.model.AudioBean
import com.self.xiucuiyu.mkotlin.R
import kotlinx.android.synthetic.main.item_vbang.view.*

/**
 * Created by xiucui.yu on 2018/1/6.
 */
class VBangItemView : RelativeLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    init {
        View.inflate(context, R.layout.item_vbang, this)


    }

    fun setData(bean: AudioBean) {
        title.text = bean.display_name
        artist.text = bean.artist
        size.text = bean.size.toString()

    }
}