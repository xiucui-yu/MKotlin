package com.self.xiucuiyu.mkotlin.ui.homepage.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.itheima.player.model.bean.YueDanBean
import com.self.xiucuiyu.mkotlin.R
import kotlinx.android.synthetic.main.item_yuedan_adapter_view_layout.view.*

/**
 * Created by xiucui.yu on 2017/11/17.
 * 主构造方法与次构造方法的区别，主构造传入的参数类内部可以访问，否则必须声明传值
 */

class YueDanItemView : RelativeLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    fun setData(item: YueDanBean.PlayListsBean) {
        title.text = item.title
        author_name.text = item.creator?.nickName
        count.text = item.videoCount.toString()
        Glide.with(context)
                .load(item.playListBigPic)
                .apply(RequestOptions.fitCenterTransform())
                .into(bg);

        Glide.with(this).load(item.creator?.largeAvatar)
                .into(author_image)
    }

    init {
        View.inflate(context, R.layout.item_yuedan_adapter_view_layout, this)
    }


}