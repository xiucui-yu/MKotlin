package com.self.xiucuiyu.mkotlin.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.self.xiucuiyu.mkotlin.R

/**
 * Created by xiucui.yu on 2017/11/20.
 */
class LodeMoreItemView : RelativeLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    init {
        View.inflate(context, R.layout.load_more_item_view_layout,this)
    }



}