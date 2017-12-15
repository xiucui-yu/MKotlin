package com.self.xiucuiyu.mkotlin.ui.homepage

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.self.xiucuiyu.mkotlin.ui.homepage.view.HomeItemView
import com.self.xiucuiyu.mkotlin.widget.LodeMoreItemView

/**
 * Created by xiucui.yu on 2017/11/17.
 */
abstract class BaseListAdapter<ITEMBEAN, ITEMVIEW : View> : RecyclerView.Adapter<BaseListAdapter.BaseListHolder>() {
    private var homeItemBeanList = ArrayList<ITEMBEAN>();
    private val ITEM_TYPE: Int = 1
    private val MORE_TYPE: Int = 2


    fun addData(newHomeItemBeanList: List<ITEMBEAN>?) {
        newHomeItemBeanList?.let {
            homeItemBeanList.addAll(it)
            notifyDataSetChanged()
        }
    }

    fun setData(newHomeItemBeanList: List<ITEMBEAN>?) {
        newHomeItemBeanList?.let {
            homeItemBeanList.clear()
            homeItemBeanList.addAll(it)
            notifyDataSetChanged()
        }

    }

    override fun getItemViewType(position: Int): Int {
        if (homeItemBeanList.size == position) {
            return MORE_TYPE;
        } else {
            return ITEM_TYPE;
        }
    }

    override fun onBindViewHolder(holder: BaseListHolder, position: Int) {
        if (homeItemBeanList?.size == position) {
            return;
        } else {
            val get = homeItemBeanList?.get(position)
            val itemView = holder.itemView as ITEMVIEW
            refreshView(itemView, get)
            itemView.setOnClickListener {
                listener?.invoke(get)
            }
        }
    }

    var listener: ((itemBean: ITEMBEAN) -> Unit)? = null

    fun setItemOnClickListener(listener: ((itemBean: ITEMBEAN) -> Unit)) {
        this.listener = listener
    }

    override fun getItemCount(): Int {
        return homeItemBeanList?.size + 1;
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseListHolder {
        if (viewType == ITEM_TYPE) {
            return BaseListHolder(getItemView(parent?.context))
        } else {
            return BaseListHolder(LodeMoreItemView(parent?.context))
        }
    }

    abstract fun getItemView(context: Context?): ITEMVIEW?

    abstract fun refreshView(itemView: ITEMVIEW, get: ITEMBEAN)


    class BaseListHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {


    }


}