package com.self.xiucuiyu.mkotlin.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.self.xiucuiyu.koltindemo.base.BaseActivity
import com.self.xiucuiyu.mkotlin.R


class MainActivity : BaseActivity() {
    override fun getLayoutId(): Int {
      return  R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
