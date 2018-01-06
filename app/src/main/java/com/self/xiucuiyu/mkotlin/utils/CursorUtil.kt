package com.self.xiucuiyu.mkotlin.utils

import android.database.Cursor
import android.util.Log

/**
 * Created by xiucui.yu on 2018/1/5.
 */
object CursorUtil {

    fun logCursor(cursor: Cursor) {
        cursor.let {
            it.moveToPosition(-1)
            while (it.moveToNext()) {
                for (index in 0 until it.columnCount) {

                  System.out.print(it.getColumnName(index)+"--value"+it.getString(index));
                }
            }
        }

    }


}