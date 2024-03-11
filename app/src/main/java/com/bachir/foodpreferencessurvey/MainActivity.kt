package com.bachir.foodpreferencessurvey

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var rgSurveyList: RadioGroup
    private lateinit var btnSurveySelection: Button
    private lateinit var checkedSurvey: Survey


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Survey"


        rgSurveyList = findViewById(R.id.rgSurveyList)
        btnSurveySelection = findViewById(R.id.btnSurveySelection)
        btnSurveySelection.isEnabled = false

        val listOfSurveyOptions = data.listOfSurvey

        for ((index,survey)in listOfSurveyOptions.withIndex()) {
            val radioButton = RadioButton(this)
            radioButton.text = survey.name
            radioButton.id=index
            rgSurveyList.addView(radioButton)

        }

        rgSurveyList.setOnCheckedChangeListener { _, checkedId ->
            btnSurveySelection.isEnabled=true
            checkedSurvey = listOfSurveyOptions.get(checkedId)
        }

        btnSurveySelection.setOnClickListener {

            Toast.makeText(
                this,
                "$checkedSurvey is chosen",
                Toast.LENGTH_SHORT
            ).show()

            val intent = Intent(this,SurveyActivity::class.java)
            intent.putExtra("SURVEY_CHOSEN", checkedSurvey)
            startActivity(intent)

        }


    }
}