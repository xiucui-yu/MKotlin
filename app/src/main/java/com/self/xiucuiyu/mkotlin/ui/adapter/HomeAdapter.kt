package com.self.xiucuiyu.mkotlin.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.itheima.player.model.bean.HomeItemBean
import com.self.xiucuiyu.mkotlin.widget.HomeItemView
import com.self.xiucuiyu.mkotlin.widget.LodeMoreItemView

/**
 * Created by xiucui.yu on 2017/11/17.
 */
class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeHolder>() {
    private var homeItemBeanList = ArrayList<HomeItemBean>();
    private val ITEM_TYPE: Int = 1
    private val MORE_TYPE: Int = 2

    fun addData(newHomeItemBeanList: ArrayList<HomeItemBean>) {
        homeItemBeanList.addAll(newHomeItemBeanList)
        notifyDataSetChanged()
    }

    fun setData(newHomeItemBeanList: ArrayList<HomeItemBean>) {
        homeItemBeanList.clear()
        homeItemBeanList.addAll(newHomeItemBeanList)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        if (homeItemBeanList.size == position) {
            return MORE_TYPE;
        } else {
            return ITEM_TYPE;
        }
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        if (homeItemBeanList?.size == position) {
            return;
        } else {
            val get = homeItemBeanList?.get(position)
            val homeItemView = holder.itemView as HomeItemView
            homeItemView.setData(get)
        }
    }

    override fun getItemCount(): Int {
        return homeItemBeanList?.size + 1;
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HomeHolder {
        if (viewType == ITEM_TYPE) {
            return HomeHolder(HomeItemView(parent?.context))
        } else {
            return HomeHolder(LodeMoreItemView(parent?.context))
        }
    }

    class HomeHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {


    }


}