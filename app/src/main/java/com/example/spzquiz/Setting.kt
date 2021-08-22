package com.example.spzquiz

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import android.widget.Toast
import android.content.res.Resources
import androidx.appcompat.app.AppCompatDelegate.*
import androidx.core.view.isVisible

data class Settings(val isPicChecked: Boolean, val isCityChecked: Boolean,
                    val isNightTheme: Boolean,val isDarkChecked: Boolean)

class Setting : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode", "CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        val btnSave = findViewById<Button>(R.id.btnSave)
        val switchPic = findViewById<Switch>(R.id.switchPic)
        val switchCityName = findViewById<Switch>(R.id.switchCityName)
        val switchDark = findViewById<Switch>(R.id.switchDark)

        fun getSettings(): Settings {
            val settings = PreferenceManager.getDefaultSharedPreferences(this)
            val isPicChecked = settings.getBoolean("switchPic", true)
            val isCityChecked = settings.getBoolean("switchCityName", false)

            fun isUsingNightModeResources(): Boolean {
                return when (Resources.getSystem().configuration.uiMode and
                        Configuration.UI_MODE_NIGHT_MASK) {
                    Configuration.UI_MODE_NIGHT_YES -> true
                    Configuration.UI_MODE_NIGHT_NO -> false
                    Configuration.UI_MODE_NIGHT_UNDEFINED -> false
                    else -> false
                }

            }
            val isNightTheme = isUsingNightModeResources()
            val isDarkChecked = settings.getBoolean("darkChecked", isNightTheme)
            return Settings(isPicChecked, isCityChecked, isNightTheme, isDarkChecked)
        }



        val settings = getSettings()

        val preferences = PreferenceManager.getDefaultSharedPreferences(this)


        var isPicChecked = settings.isPicChecked
        var isCityChecked = settings.isCityChecked
        var isDarkChecked = settings.isDarkChecked
        val isNightTheme = settings.isNightTheme

        switchPic.isChecked = isPicChecked
        switchCityName.isChecked = isCityChecked
        switchDark.isChecked = isDarkChecked
        switchDark.isVisible = !isNightTheme


        switchPic?.setOnCheckedChangeListener { _, isChecked ->
            isPicChecked = isChecked
        }

        switchCityName?.setOnCheckedChangeListener { _, isChecked ->
            isCityChecked = isChecked
        }

        switchDark?.setOnCheckedChangeListener { _, isChecked ->
            isDarkChecked = isChecked
            val e = preferences.edit()
            val change = true
            if (!isNightTheme)
            {
                if (isDarkChecked)
                {
                    e.putBoolean("darkChange", change)
                    e.apply()
                    setDefaultNightMode(MODE_NIGHT_YES)
                }
                else
                {
                    e.putBoolean("darkChange", change)
                    e.apply()
                    setDefaultNightMode(MODE_NIGHT_NO)
                }
            }
            else
            {
                    e.putBoolean("darkChange", change)
                    e.apply()
                    setDefaultNightMode(MODE_NIGHT_NO)
                }


            }



        btnSave.setOnClickListener {
            if (!isPicChecked && !isCityChecked)
            {
                Toast.makeText(applicationContext,"Can't save with both options turned off \n Try again",Toast.LENGTH_SHORT).show()
                switchPic.isChecked = true
            }
            else
            {
                val e = preferences.edit()
                e.putBoolean("switchPic", isPicChecked)
                e.putBoolean("switchCityName", isCityChecked)
                e.putBoolean("darkChecked", isDarkChecked)
                e.putBoolean("darkChange", false)
                e.apply()
                Toast.makeText(applicationContext,"Preferences successfully saved",Toast.LENGTH_SHORT).show()
            }

        }


    }
}