package com.self.xiucuiyu.mkotlin.ui.setting

import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceFragment
import android.preference.PreferenceScreen
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.self.xiucuiyu.mkotlin.R
import org.jetbrains.anko.startActivity

/**
 * Created by xiucui.yu on 2017/11/17.
 */
class SettingFragment : PreferenceFragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        addPreferencesFromResource(R.xml.setting_preference)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onPreferenceTreeClick(preferenceScreen: PreferenceScreen?, preference: Preference?): Boolean {
        val key = preference?.key
        if ("about".equals(key)) {
            startActivity<AboutActivity>()
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference)
    }
}