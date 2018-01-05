package com.self.xiucuiyu.mkotlin.ui.mv

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.self.xiucuiyu.koltindemo.base.BaseFragment
import org.jetbrains.anko.textColor

/**
 * Created by xiucui.yu on 2018/1/5.
 */
class MvVideoFragment : BaseFragment() {
    override fun initView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val textView = TextView(activity)
        textView.text = "Bilibili"
        textView.textSize= 20F;
        textView.gravity = Gravity.CENTER
        textView.textColor = Color.RED
        return textView

    }
}