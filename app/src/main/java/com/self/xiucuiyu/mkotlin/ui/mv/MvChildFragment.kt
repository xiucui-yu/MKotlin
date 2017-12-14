package com.self.xiucuiyu.mkotlin.ui.mv

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.itheima.player.model.bean.MvPagerBean
import com.itheima.player.model.bean.VideosBean
import com.self.xiucuiyu.koltindemo.base.BaseFragment
import com.self.xiucuiyu.mkotlin.R
import com.self.xiucuiyu.mkotlin.ui.homepage.BaseListAdapter
import com.self.xiucuiyu.mkotlin.ui.homepage.BaseListFragment
import com.self.xiucuiyu.mkotlin.ui.homepage.view.MvItemView
import org.jetbrains.anko.textColor

/**
 * Created by xiucui.yu on 2017/12/14.
 */
class MvChildFragment : BaseListFragment<MvPagerBean, VideosBean, MvItemView>() {
    override fun getPageUseList(fromJson: MvPagerBean): List<VideosBean>? {
        return fromJson.videos
    }

    override fun initAdapter(): BaseListAdapter<VideosBean, MvItemView> {

    }

    override fun initView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_vbang_layout, null)
    }

    override fun init() {
        super.init()
        arguments?.getString("title")
    }

}