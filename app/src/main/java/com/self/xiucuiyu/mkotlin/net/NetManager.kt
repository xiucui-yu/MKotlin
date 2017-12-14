package com.self.xiucuiyu.mkotlin.net

import android.util.Log
import com.self.xiucuiyu.mkotlin.executor.AppExecutors
import okhttp3.*
import java.io.IOException

/**
 * Created by xiucui.yu on 2017/11/26.
 */
class NetManager private constructor() {
    private val okHttpClient by lazy { OkHttpClient() }

    companion object {
        val instance = NetManager()
    }

    fun <RESPONSE> sendRequest(tag: String, request: MRequest<RESPONSE>) {

        val builder = Request.Builder()
                .url(request.url)
                .get()
                .build();
        okHttpClient.newCall(builder).enqueue(object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {
                AppExecutors().mainThread.execute {
                    request.callBack.onError(tag, e?.message)
                }
            }

            override fun onResponse(call: Call?, response: Response?) {

                val response = request.parseResponse(response?.body()?.string())
                AppExecutors().mainThread.execute {
                    request.callBack.onSuccess(tag, response)
                }

            }
        })
    }

}