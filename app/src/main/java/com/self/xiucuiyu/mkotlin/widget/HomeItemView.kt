package com.self.xiucuiyu.mkotlin.widget


import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.self.xiucuiyu.mkotlin.R

/**
 * Created by xiucui.yu on 2017/11/17.
 * 主构造方法与次构造方法的区别，主构造传入的参数类内部可以访问，否则必须声明传值
 */

class HomeItemView : RelativeLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    init {
        View.inflate(context, R.layout.item_home_adapter_view_layout,this)

    }
}