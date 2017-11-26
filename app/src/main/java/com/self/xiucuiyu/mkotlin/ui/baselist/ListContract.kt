package com.self.xiucuiyu.mkotlin.ui.homepage

import com.example.android.architecture.blueprints.todoapp.BasePresenter
import com.example.android.architecture.blueprints.todoapp.BaseView
import com.itheima.player.model.bean.HomeItemBean

/**
 * Created by xiucui.yu on 2017/11/26.
 */
interface ListContract {

    interface View<ITEMBEAN> : BaseView<Presenter> {
        fun refreshSuccess(fromJson: List<ITEMBEAN>)
        fun loadMoreSuccess(fromJson: List<ITEMBEAN>)
        fun refreshError(message: String?)
        fun loadMoreError(message: String?)
    }

    interface Presenter : BasePresenter {
        fun loadMore(offset: Int)
    }
}