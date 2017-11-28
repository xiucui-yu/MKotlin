package com.self.xiucuiyu.mkotlin.ui.homepage.view


import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions.fitCenterTransform
import com.self.xiucuiyu.mkotlin.ui.homepage.modle.HomeItemBean
import com.self.xiucuiyu.mkotlin.R
import kotlinx.android.synthetic.main.item_home_adapter_view_layout.view.*

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
        View.inflate(context, R.layout.item_home_adapter_view_layout, this)
    }

    fun setData(item: HomeItemBean) {
        title_tv.text = item.title
        desc_tv.text = item.description
        Glide
                .with(context)
                .load(item.posterPic)
                .apply(fitCenterTransform())
                .into(image);

        Glide.with(this).load(item.uhdUrl).into(label_image)


    }
}