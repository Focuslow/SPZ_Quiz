package com.example.spzquiz

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import android.widget.Button
import androidx.preference.PreferenceManager

class DialogWindowFragment: DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_dialog, container, false)

        val btnNo = rootView.findViewById<Button>(R.id.btnNo)
        val btnYes = rootView.findViewById<Button>(R.id.btnYes)

        fun resetForNewGame(): Void? {
            val settings = PreferenceManager.getDefaultSharedPreferences(activity)
            val e = settings.edit()
            e.putInt("currentGameCityCorrect", 0)
            e.putInt("currentGameSPZCorrect",0)
            e.putInt("currentGameCityIncorrect", 0)
            e.putInt("currentGameSPZIncorrect",0)
            e.apply()
            return null
        }
        btnNo.setOnClickListener{
             dismiss()
        }

        btnYes.setOnClickListener {
            val intent = Intent(activity, Game::class.java)
            activity?.startActivity(intent)
            resetForNewGame()
            dismiss()
        }



        return rootView
    }
}