package com.bachir.foodpreferencessurvey

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SurveyActivity : AppCompatActivity() {

    private lateinit var survey: Survey
    private lateinit var svQuestions: LinearLayout
    private lateinit var btnSubmit : Button
    private lateinit var radioGroup: RadioGroup
    private lateinit var tvSurveyResult : TextView




companion object{
    private const val TAG = "SurveyActivity"
}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        svQuestions = findViewById(R.id.svQuestions)
        btnSubmit = findViewById(R.id.btnSubmit)


        val intent = intent
        if (intent.hasExtra("SURVEY_CHOSEN")) {
            survey = intent.getSerializableExtra("SURVEY_CHOSEN") as Survey
        }
        supportActionBar?.title = survey.name


        val answers = Array(survey.questions.size) { "" }
        Log.i(TAG, "this is question 1: ${survey.questions.size}")
        survey.questions.entries.forEachIndexed { i, entry ->
            val question = entry.key
            Log.i(TAG, "this is question 1: $question")
            val value = entry.value
            radioGroup = RadioGroup(this)
            val textView = TextView(this)
            textView.text = question


            for ((index, valueChoices) in value.withIndex()) {
                val radioButton = RadioButton(this)
                radioButton.text = valueChoices
                radioButton.id = index
                radioGroup.addView(radioButton)
            }

            svQuestions.addView(textView)
            svQuestions.addView(radioGroup)

            radioGroup.setOnCheckedChangeListener { group, checkedId ->
                val checkedRadioButton = group.findViewById<RadioButton>(checkedId)
                val checkedText = checkedRadioButton.text.toString()
                answers[i] =textView.text.toString() + ": " +  checkedText
            }


        }

        btnSubmit.setOnClickListener {
            tvSurveyResult = findViewById(R.id.tvSurveyResult)
            var res = "";
            for (element in answers) {
                if (element.isEmpty()) {
                    Toast.makeText(this,"Please answer to All the questions then submit",Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }else{
                    res = res +  element + "\n"
                }
            }
            tvSurveyResult.text = res
        }

    }}

