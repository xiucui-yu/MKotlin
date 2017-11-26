package com.self.xiucuiyu.mkotlin.net

/**
 * Created by xiucui.yu on 2017/11/26.
 */
interface ResponseCallBack<RESPONSE>{
    fun onSuccess(tag:String,response: RESPONSE)
    fun onError(tag:String,msg: String?)
}