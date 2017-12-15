package com.self.xiucuiyu.mkotlin.ui.mv

import android.os.Parcelable
import android.support.v7.widget.Toolbar
import com.self.xiucuiyu.koltindemo.base.BaseActivity
import com.self.xiucuiyu.mkotlin.R
import com.self.xiucuiyu.mkotlin.ui.homepage.modle.VideoPlayerBean
import com.self.xiucuiyu.mkotlin.utils.ToolBarManager
import kotlinx.android.synthetic.main.activity_video_player_layout.*
import org.jetbrains.anko.find

/**
 * Created by xiucui.yu on 2017/12/15.
 */
class VideoPlayerActivity : BaseActivity(), ToolBarManager {

    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun getLayoutId(): Int {
        return R.layout.activity_video_player_layout
    }

    override fun initData() {
        super.initData()
        initVideoInfoToolBar();
        val value = intent.getParcelableExtra<VideoPlayerBean>("videoBean")
        video_view.setVideoPath(value.url)
        video_view.setOnPreparedListener {
            video_view.start()
        }

    }

}