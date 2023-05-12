package com.geez.lastofuswalkthrough.model.database

import android.content.Context
import android.content.SharedPreferences
import com.geez.lastofuswalkthrough.view.activities.GUIDE_NAME
import com.geez.lastofuswalkthrough.view.activities.PREFERENCE_NAME

class PrefRepository(context: Context) {

    private val pref: SharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    private val editor = pref.edit()

    private fun String.put(string: String){
        editor.putString(this, string)
        editor.commit()
    }

    private fun String.getString() = pref.getString(this, "")!!

    fun setGuide(guide: String){
        GUIDE_NAME.put(guide)
    }

    fun getGuide() = GUIDE_NAME.getString()
}