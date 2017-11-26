package com.self.xiucuiyu.mkotlin.net

import com.google.gson.Gson
import java.lang.reflect.ParameterizedType

/**
 * Created by xiucui.yu on 2017/11/26.
 */
open class MRequest<RESPONSE>(var url: String, var callBack: ResponseCallBack<RESPONSE>) {
    fun parseResponse(result: String?): RESPONSE {
        var superClass = this.javaClass.genericSuperclass
        var type = (superClass as ParameterizedType).actualTypeArguments[0];
        return Gson().fromJson<RESPONSE>(result, type)
    }
}