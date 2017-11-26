package com.self.xiucuiyu.mkotlin.ui.homepage

import com.example.android.architecture.blueprints.todoapp.BasePresenter
import com.example.android.architecture.blueprints.todoapp.BaseView
import com.itheima.player.model.bean.HomeItemBean

/**
 * Created by xiucui.yu on 2017/11/26.
 */
interface HomeContract {

    interface View : BaseView<Presenter> {
        fun refreshSuccess(fromJson: List<HomeItemBean>)
        fun loadMoreSuccess(fromJson: List<HomeItemBean>)
        fun refreshError(message: String?)
        fun loadMoreError(message: String?)
    }

    interface Presenter : BasePresenter {
        fun loadMore(offset: Int)
    }
}