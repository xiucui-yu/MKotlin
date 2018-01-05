package com.self.xiucuiyu.mkotlin.ui.mv

import android.graphics.SurfaceTexture
import android.media.MediaPlayer
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import android.view.Surface
import android.view.TextureView
import com.self.xiucuiyu.koltindemo.base.BaseActivity
import com.self.xiucuiyu.mkotlin.R
import com.self.xiucuiyu.mkotlin.ui.homepage.modle.VideoPlayerBean
import com.self.xiucuiyu.mkotlin.utils.ToolBarManager
import kotlinx.android.synthetic.main.activity_texture_video_player_layout.*
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.__ViewPager_OnPageChangeListener
import org.jetbrains.anko.support.v4.onPageChangeListener

/**
 * Created by xiucui.yu on 2017/12/15.
 *
 * 与VideoView 比优势可以放到列表中显示 旋转 动画处理
 *
 * 4.0 之后提供的
 *
 * MediaPlayer 缺点： 不支持硬解码，不支持高清格式，用系统自带的是远远不够的
 *
 * Vitamio :GPU渲染，硬解码 高清格式 缺点：继承自serfaceView  对页面旋转设置，动画显示，都是不支持的 是一个窗体
 *
 *Ijkplayer
 *
 *
 */
class TextureVideoPlayerActivity : BaseActivity(), ToolBarManager, TextureView.SurfaceTextureListener {
    val mediaPlayer by lazy { MediaPlayer() }
    override fun onSurfaceTextureSizeChanged(p0: SurfaceTexture?, p1: Int, p2: Int) {

    }

    override fun onSurfaceTextureUpdated(p0: SurfaceTexture?) {

    }

    override fun onSurfaceTextureDestroyed(p0: SurfaceTexture?): Boolean {
        //关闭mediaPlayer
        mediaPlayer?.let {
            mediaPlayer.stop()
            mediaPlayer.release()
        }
        //true 不会继续渲染了
        //false 释放资源刷新
        return true
    }

    override fun onSurfaceTextureAvailable(p0: SurfaceTexture?, p1: Int, p2: Int) {
        videoPlayerBean?.let {
            mediaPlayer.setDataSource(it.url)
            mediaPlayer.setSurface(Surface(p0))
            mediaPlayer.prepareAsync()
            mediaPlayer.setOnPreparedListener {
                mediaPlayer.start()
            }
        }

    }

    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun getLayoutId(): Int {
        return R.layout.activity_texture_video_player_layout
    }

    var videoPlayerBean: VideoPlayerBean? = null

    override fun initData() {
        super.initData()
        initVideoInfoToolBar();
        videoPlayerBean = intent.getParcelableExtra<VideoPlayerBean>("videoBean")
        textureView.surfaceTextureListener = this
        viewpager.adapter = VideoAdapter(supportFragmentManager)
        radio_group.setOnCheckedChangeListener { _rg, i ->
            when (i) {
                R.id.mv_description -> viewpager.currentItem = 0
                R.id.mv_comment -> viewpager.currentItem = 1
                R.id.mv_relative -> viewpager.currentItem = 2
            }

        }
        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> radio_group.check(R.id.mv_description)
                    1 -> radio_group.check(R.id.mv_comment)
                    2 -> radio_group.check(R.id.mv_relative)
                }

            }

        });


    }

}