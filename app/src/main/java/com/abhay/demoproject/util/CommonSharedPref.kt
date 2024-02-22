package com.abhay.demoproject.util

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey


object CommonSharedPref {

    lateinit var sharedPreferences: EncryptedSharedPreferences
    lateinit var editor: SharedPreferences.Editor


    fun initialise(context: Context) {
        if (!::sharedPreferences.isInitialized) {
            val masterKeyAlias = MasterKey.Builder(context)
                .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                .build()

            sharedPreferences = EncryptedSharedPreferences.create(
                context,
                "Demo_Pref",
                masterKeyAlias,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            ) as EncryptedSharedPreferences

            editor = sharedPreferences.edit()
        }
    }

    fun getInstance(): EncryptedSharedPreferences {
        return sharedPreferences
    }

    fun putString(key: String, value: String) {
        editor.putString(key, value)
        editor.commit()
    }

    fun getString(key: String): String? {
        return sharedPreferences.getString(key, "")
    }
}