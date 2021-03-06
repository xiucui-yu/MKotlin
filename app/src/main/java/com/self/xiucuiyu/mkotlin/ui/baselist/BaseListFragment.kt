package com.self.xiucuiyu.mkotlin.ui.homepage

import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.itheima.player.model.bean.YueDanBean
import com.self.xiucuiyu.koltindemo.base.BaseFragment
import com.self.xiucuiyu.mkotlin.R
import kotlinx.android.synthetic.main.fragment_home_layout.*

/**
 * Created by xiucui.yu on 2017/11/17.
 */
abstract class BaseListFragment<RESPONSE, ITEMBEAN, ITEMVIEW : View> : BaseFragment(), ListContract.View<RESPONSE> {
    override fun refreshSuccess(fromJson: RESPONSE) {
        adapter.setData(getPageUseList(fromJson));
        if (refreshLayout.isRefreshing)
            refreshLayout.isRefreshing = false
    }

    override fun loadMoreSuccess(fromJson: RESPONSE) {

        adapter.addData(getPageUseList(fromJson));

        if (refreshLayout.isRefreshing)
            refreshLayout.isRefreshing = false

    }

    abstract fun getPageUseList(fromJson: RESPONSE): List<ITEMBEAN>?


    override fun refreshError(message: String?) {
        if (refreshLayout.isRefreshing)
            refreshLayout.isRefreshing = false
    }

    override fun loadMoreError(message: String?) {
        activity?.runOnUiThread {
            if (refreshLayout.isRefreshing)
                refreshLayout.isRefreshing = false
        }
    }

    override lateinit var presenter: ListContract.Presenter


    val adapter by lazy { initAdapter() }

    abstract fun initAdapter(): BaseListAdapter<ITEMBEAN, ITEMVIEW>


    override fun initView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_home_layout, null)
    }


    override fun initListener() {
        super.initListener()
        refreshLayout.setColorSchemeColors(Color.BLACK, Color.RED, Color.YELLOW)
        refreshLayout.setOnRefreshListener {
            presenter.start()
        }
        //初始化
        recyclerView.layoutManager = LinearLayoutManager(context);
        //适配
        recyclerView.adapter = adapter

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            @Override
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                when (newState) {
                    SCROLL_STATE_IDLE -> {
                        var layoutManager = recyclerView?.layoutManager
                        if (layoutManager is LinearLayoutManager) {
                            val findLastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
                            if (findLastVisibleItemPosition == adapter.itemCount - 1) {
                                //显示最后一条
                                presenter.loadMore(adapter.itemCount - 1)
                            }
                        }

                    }
                    SCROLL_STATE_DRAGGING ->
                        println("SCROLL_STATE_DRAGGING---")
                    SCROLL_STATE_SETTLING ->
                        println("SCROLL_STATE_SETTLING------------")
                }
            }

            @Override
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

    override fun initData() {
        super.initData()
        presenter.start()
    }

}