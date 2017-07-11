package com.samson.rivers_lakes.lower.utils

import android.content.Context
import android.content.SharedPreferences

class PreferencesUtils private constructor() {


    companion object {

        var PREFERENCE_NAME = "TrineaAndroidCommon"

        /**
         * put string preferences

         * @param key   The name of the preference to modify
         * *
         * @param value The new value for the preference
         * *
         * @return True if the new values were successfully written to persistent storage.
         */
        fun putString(key: String, value: String): Boolean {
            val settings = AppUtils.appContext!!.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
            val editor = settings.edit()
            editor.putString(key, value)
            return editor.commit()
        }

        /**
         * get string preferences

         * @param key          The name of the preference to retrieve
         * *
         * @param defaultValue Value to return if this preference does not exist
         * *
         * @return The preference value if it exists, or defValue. Throws ClassCastException if there is a preference with
         * * this name that is not a string
         */
        @JvmOverloads fun getString(key: String, defaultValue: String? = null): String {
            val settings = AppUtils.appContext!!.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
            return settings.getString(key, defaultValue)
        }

        /**
         * put int preferences

         * @param key   The name of the preference to modify
         * *
         * @param value The new value for the preference
         * *
         * @return True if the new values were successfully written to persistent storage.
         */
        fun putInt(key: String, value: Int): Boolean {
            val settings = AppUtils.appContext!!.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
            val editor = settings.edit()
            editor.putInt(key, value)
            return editor.commit()
        }

        /**
         * get int preferences

         * @param key          The name of the preference to retrieve
         * *
         * @param defaultValue Value to return if this preference does not exist
         * *
         * @return The preference value if it exists, or defValue. Throws ClassCastException if there is a preference with
         * * this name that is not a int
         */
        @JvmOverloads fun getInt(key: String, defaultValue: Int = -1): Int {
            val settings = AppUtils.appContext!!.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
            return settings.getInt(key, defaultValue)
        }

        /**
         * put long preferences

         * @param key   The name of the preference to modify
         * *
         * @param value The new value for the preference
         * *
         * @return True if the new values were successfully written to persistent storage.
         */
        fun putLong(key: String, value: Long): Boolean {
            val settings = AppUtils.appContext!!.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
            val editor = settings.edit()
            editor.putLong(key, value)
            return editor.commit()
        }

        /**
         * get long preferences

         * @param key          The name of the preference to retrieve
         * *
         * @param defaultValue Value to return if this preference does not exist
         * *
         * @return The preference value if it exists, or defValue. Throws ClassCastException if there is a preference with
         * * this name that is not a long
         */
        @JvmOverloads fun getLong(key: String, defaultValue: Long = -1): Long {
            val settings = AppUtils.appContext!!.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
            return settings.getLong(key, defaultValue)
        }

        /**
         * put float preferences

         * @param key   The name of the preference to modify
         * *
         * @param value The new value for the preference
         * *
         * @return True if the new values were successfully written to persistent storage.
         */
        fun putFloat(key: String, value: Float): Boolean {
            val settings = AppUtils.appContext!!.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
            val editor = settings.edit()
            editor.putFloat(key, value)
            return editor.commit()
        }

        /**
         * get float preferences

         * @param key          The name of the preference to retrieve
         * *
         * @param defaultValue Value to return if this preference does not exist
         * *
         * @return The preference value if it exists, or defValue. Throws ClassCastException if there is a preference with
         * * this name that is not a float
         */
        @JvmOverloads fun getFloat(key: String, defaultValue: Float = -1f): Float {
            val settings = AppUtils.appContext!!.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
            return settings.getFloat(key, defaultValue)
        }

        /**
         * put boolean preferences

         * @param key   The name of the preference to modify
         * *
         * @param value The new value for the preference
         * *
         * @return True if the new values were successfully written to persistent storage.
         */
        fun putBoolean(key: String, value: Boolean): Boolean {
            val settings = AppUtils.appContext!!.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
            val editor = settings.edit()
            editor.putBoolean(key, value)
            return editor.commit()
        }

        /**
         * get boolean preferences

         * @param key          The name of the preference to retrieve
         * *
         * @param defaultValue Value to return if this preference does not exist
         * *
         * @return The preference value if it exists, or defValue. Throws ClassCastException if there is a preference with
         * * this name that is not a boolean
         */
        @JvmOverloads fun getBoolean(key: String, defaultValue: Boolean = false): Boolean {
            val settings = AppUtils.appContext!!.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
            return settings.getBoolean(key, defaultValue)
        }
    }
}
/**
 * get string preferences

 * @param key The name of the preference to retrieve
 * *
 * @return The preference value if it exists, or null. Throws ClassCastException if there is a preference with this
 * * name that is not a string
 * *
 * @see .getString
 */
/**
 * get int preferences

 * @param key The name of the preference to retrieve
 * *
 * @return The preference value if it exists, or -1. Throws ClassCastException if there is a preference with this
 * * name that is not a int
 * *
 * @see .getInt
 */
/**
 * get long preferences

 * @param key The name of the preference to retrieve
 * *
 * @return The preference value if it exists, or -1. Throws ClassCastException if there is a preference with this
 * * name that is not a long
 * *
 * @see .getLong
 */
/**
 * get float preferences

 * @param key The name of the preference to retrieve
 * *
 * @return The preference value if it exists, or -1. Throws ClassCastException if there is a preference with this
 * * name that is not a float
 * *
 * @see .getFloat
 */
/**
 * get boolean preferences, default is false

 * @param key The name of the preference to retrieve
 * *
 * @return The preference value if it exists, or false. Throws ClassCastException if there is a preference with this
 * * name that is not a boolean
 */
