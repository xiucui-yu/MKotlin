package com.self.xiucuiyu.mkotlin.ui.homepage

import com.example.android.architecture.blueprints.todoapp.BasePresenter
import com.example.android.architecture.blueprints.todoapp.BaseView

/**
 * Created by xiucui.yu on 2017/11/26.
 */
interface ListContract {

    interface View<RESPONSE> : BaseView<Presenter> {
        fun refreshSuccess(fromJson: RESPONSE)
        fun loadMoreSuccess(fromJson: RESPONSE)
        fun refreshError(message: String?)
        fun loadMoreError(message: String?)
    }

    interface Presenter : BasePresenter {
        fun loadMore(offset: Int)
    }
}