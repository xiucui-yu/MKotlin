package com.self.xiucuiyu.mkotlin.ui.fragment

import android.graphics.Color
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.itheima.player.model.bean.HomeItemBean
import com.self.xiucuiyu.koltindemo.base.BaseFragment
import com.self.xiucuiyu.mkotlin.R
import com.self.xiucuiyu.mkotlin.ui.adapter.HomeAdapter
import com.self.xiucuiyu.mkotlin.utils.URLProviderUtils
import kotlinx.android.synthetic.main.fragment_home_layout.*
import okhttp3.*
import org.jetbrains.anko.sdk25.coroutines.__AbsListView_OnScrollListener
import java.io.IOException

/**
 * Created by xiucui.yu on 2017/11/17.
 */
class HomeFragment : BaseFragment() {

    val adapter by lazy { HomeAdapter() }

    override fun initView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_home_layout, null)
    }

    override fun initListener() {
        super.initListener()
        refreshLayout.setColorSchemeColors(Color.BLACK, Color.RED, Color.YELLOW)
        refreshLayout.setOnRefreshListener {
            initNetData()
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

                                loadMoreData(adapter.itemCount - 1)
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
        initNetData()
    }

    private fun initNetData() {

        var path = URLProviderUtils.getHomeUrl(0, 10)
        val okHttpClient = OkHttpClient()
        val builder = Request.Builder()
                .url(path)
                .get()
                .build();
        okHttpClient.newCall(builder).enqueue(object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {
                activity?.runOnUiThread {
                    if (refreshLayout.isRefreshing)
                        refreshLayout.isRefreshing = false
                }
            }

            override fun onResponse(call: Call?, response: Response?) {
                val gson = Gson()
                val fromJson = gson.fromJson<List<HomeItemBean>>(response?.body()?.string(), object : TypeToken<List<HomeItemBean>>() {}.type)
                activity?.runOnUiThread {
                    adapter.setData(fromJson as ArrayList<HomeItemBean>);
                }
                if (refreshLayout.isRefreshing)
                    refreshLayout.isRefreshing = false
            }
        })

    }

    private fun loadMoreData(offset: Int) {
        var path = URLProviderUtils.getHomeUrl(offset, 10)
        val okHttpClient = OkHttpClient()
        val builder = Request.Builder()
                .url(path)
                .get()
                .build();
        okHttpClient.newCall(builder).enqueue(object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {
                activity?.runOnUiThread {
                    if (refreshLayout.isRefreshing)
                        refreshLayout.isRefreshing = false
                }
            }

            override fun onResponse(call: Call?, response: Response?) {
                val gson = Gson()
                val fromJson = gson.fromJson<List<HomeItemBean>>(response?.body()?.string(), object : TypeToken<List<HomeItemBean>>() {}.type)
                activity?.runOnUiThread {
                    adapter.addData(fromJson as ArrayList<HomeItemBean>);
                }
                if (refreshLayout.isRefreshing)
                    refreshLayout.isRefreshing = false
            }
        })

    }
}