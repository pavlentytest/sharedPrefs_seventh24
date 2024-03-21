package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.settings, SettingsFragment())
                .commit()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val map: Map<String,*> = sharedPreferences.all
        map.forEach { v ->
            Log.d("RRR","${v.key} - ${v.value}")
        }
        val sharedPreferences2 = getSharedPreferences("filename", MODE_PRIVATE)
        val editor = sharedPreferences2.edit().putString("key","value123123")
        editor.apply()

        // create dir in Ext.storage
      //  getExternalFilesDir()
    }

    class SettingsFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)
        }
    }
}