package com.self.xiucuiyu.mkotlin.ui.homepage.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.itheima.player.model.bean.VideosBean
import com.self.xiucuiyu.mkotlin.R
import kotlinx.android.synthetic.main.item_mv.view.*

/**
 * Created by xiucui.yu on 2017/12/14.
 */
class MvItemView : RelativeLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    init {
        View.inflate(context, R.layout.item_mv, this);
    }

    fun setData(videosBean: VideosBean) {
        title.text = videosBean.title
        Glide.with(context).load(videosBean.albumImg).into(bg)
        artist.text = videosBean.artistName

    }

}