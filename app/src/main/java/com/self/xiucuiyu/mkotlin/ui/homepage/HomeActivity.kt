package com.self.xiucuiyu.mkotlin.ui.homepage

import android.support.v7.widget.Toolbar
import com.self.xiucuiyu.koltindemo.base.BaseActivity
import com.self.xiucuiyu.mkotlin.R
import com.self.xiucuiyu.mkotlin.utils.FragmentUtil
import com.self.xiucuiyu.mkotlin.utils.ToolBarManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.find


class HomeActivity : BaseActivity(), ToolBarManager {
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        super.initData()
        initHomeToolBar();
    }

    override fun initListener() {
        super.initListener()


        bottomBar.setOnTabSelectListener {
            //kotlin 中  it+"" 是不能代替 it.toString()
            val fragment = FragmentUtil.fragmentUtil.getFragment(it)
            val beginTransaction = supportFragmentManager.beginTransaction()
            beginTransaction.replace(R.id.contentContainer, fragment, it.toString())
            beginTransaction.commitAllowingStateLoss()

            when (it) {
                R.id.tab_home -> {
                    HomePresenter(fragment as ListContract.View)
                }
                R.id.tab_mv -> null;
                R.id.tab_vbang -> null;
                R.id.tab_yuedan -> null;

            }

        }


    }
}
