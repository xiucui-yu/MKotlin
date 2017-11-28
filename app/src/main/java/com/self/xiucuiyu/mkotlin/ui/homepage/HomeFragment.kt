package com.self.xiucuiyu.mkotlin.ui.homepage

import com.self.xiucuiyu.mkotlin.ui.homepage.modle.HomeItemBean
import com.self.xiucuiyu.mkotlin.ui.homepage.view.HomeItemView

/**
 * Created by xiucui.yu on 2017/11/17.
 */
class HomeFragment : BaseListFragment<List<HomeItemBean>, HomeItemBean, HomeItemView>() {
    override fun getPageUseList(fromJson: List<HomeItemBean>): List<HomeItemBean> {
        return fromJson
    }

    override fun initAdapter(): BaseListAdapter<HomeItemBean, HomeItemView> {
        return HomeAdapter()
    }

    /* override fun refreshSuccess(fromJson: List<HomeItemBean>) {
         activity?.runOnUiThread {
             adapter.setData(fromJson as ArrayList<HomeItemBean>);
             if (refreshLayout.isRefreshing)
                 refreshLayout.isRefreshing = false
         }
     }

     override fun loadMoreSuccess(fromJson: List<HomeItemBean>) {
         activity?.runOnUiThread {
             adapter.addData(fromJson as ArrayList<HomeItemBean>);

             if (refreshLayout.isRefreshing)
                 refreshLayout.isRefreshing = false
         }
     }

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


     val adapter by lazy { HomeAdapter() }

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

     companion object {
         fun newInstance() = BaseListFragment()
     }*/
}