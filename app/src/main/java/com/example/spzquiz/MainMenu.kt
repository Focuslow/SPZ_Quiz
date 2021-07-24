package com.example.spzquiz

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.PreferenceManager

class MainMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun isUsingNightModeResources(): Boolean {
            return when (resources.configuration.uiMode and
                    Configuration.UI_MODE_NIGHT_MASK) {
                Configuration.UI_MODE_NIGHT_YES -> true
                Configuration.UI_MODE_NIGHT_NO -> false
                Configuration.UI_MODE_NIGHT_UNDEFINED -> false
                else -> false
            }
        }

        val settings = PreferenceManager.getDefaultSharedPreferences(this)
        val isDarkChecked = settings.getBoolean("darkChecked", isUsingNightModeResources())
        val saveDark = settings.getBoolean("darkChange", false)
        if (!saveDark)
        {
            if (isDarkChecked)
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            else
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }


        val btnResume = findViewById<Button>(R.id.btnResume)
        val btnNewGame = findViewById<Button>(R.id.btnNewGame)
        val btnStat = findViewById<Button>(R.id.btnStat)
        val btnSetting = findViewById<Button>(R.id.btnSetting)
        val btnAbout = findViewById<Button>(R.id.btnAbout)


        btnResume.setOnClickListener {
            val intent = Intent(this, Game::class.java)
            startActivity(intent)
        }

        btnNewGame.setOnClickListener {
            val intent = Intent(this, Game::class.java)
            startActivity(intent)
        }

        btnStat.setOnClickListener {
            val intent = Intent(this, Stat::class.java)
            startActivity(intent)
        }

        btnSetting.setOnClickListener {
            val intent = Intent(this, Setting::class.java)
            startActivity(intent)
        }

        btnAbout.setOnClickListener {
            val intent = Intent(this, About::class.java)
            startActivity(intent)

        }
    }

    private var counter: Int = 0

    private val timer = object : CountDownTimer(2000, 500) {
        override fun onTick(millisUntilFinished: Long) {}
        override fun onFinish() {
            counter = 0
        }
    }



    override fun onBackPressed() {
        counter++
        if(counter == 1)
        {
            Toast.makeText(applicationContext,"Press back again to exit",Toast.LENGTH_SHORT).show()
        }
        else
        {
            super.onBackPressed()
        }
        timer.start()
    }

    



}