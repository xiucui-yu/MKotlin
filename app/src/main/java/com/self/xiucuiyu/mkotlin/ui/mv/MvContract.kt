package com.self.xiucuiyu.mkotlin.ui.mv

import com.example.android.architecture.blueprints.todoapp.BaseView
import com.itheima.player.model.bean.MvAreaBean

/**
 * Created by xiucui.yu on 2017/12/14.
 */
interface MvContract {
    interface MvPresenter {
        fun getTitleData() ;

    }
    interface MvView:BaseView<MvPresenter> {
      fun setTopTab(tabData:ArrayList<MvAreaBean>)

    }


}