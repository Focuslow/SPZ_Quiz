package com.example.spzquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.preference.PreferenceManager
import org.w3c.dom.Text

class Stat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stat)

        val settings = PreferenceManager.getDefaultSharedPreferences(this)

        fun setTextToView(view: TextView, correct: Int, incorrect: Int):  Void? {
            val correctstr = correct.toString()
            val incorrectstr = incorrect.toString()
            val stringout = correctstr +" / "+ incorrectstr
            view.setText(stringout)
            return null
        }


        val txtViews = listOf("currectGameCity","currectGameSPZ","totalWriteCity","totalWriteSPZ",
        "totalPickCity","totalPickSPZ")

        val statValues = mutableListOf<List<Int>>()
        for (item in txtViews) {
            val correctText = item+"Correct"
            val incorrectText = item+"Incorrect"
            val correct = settings.getInt(correctText, 0)
            val incorrect = settings.getInt(incorrectText, 0)
            val tuple = listOf(correct,incorrect)
            statValues.add(tuple)
        }

        val views = mutableListOf<TextView>()
        views.add(findViewById<TextView>(R.id.currectGameCity))
        views.add(findViewById<TextView>(R.id.currectGameSPZ))
        views.add(findViewById<TextView>(R.id.totalWriteCity))
        views.add(findViewById<TextView>(R.id.totalWriteSPZ))
        views.add(findViewById<TextView>(R.id.totalPickCity))
        views.add(findViewById<TextView>(R.id.totalPickSPZ))

        for (i in 0 until statValues.size){
            setTextToView(views[i],statValues[i][0], statValues[i][1])
        }





    }
}