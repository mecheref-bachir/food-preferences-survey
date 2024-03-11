package com.bachir.foodpreferencessurvey

import java.io.Serializable

object data {
    val listOfSurvey = listOf<Survey>(
        Survey(
            "Food Preferences",
            mapOf<String, Array<String>>(
                "What is your favorite cuisine?" to arrayOf("Chinese", "French","Italian", "Indian","Turkish"),
                "How often do you eat out?" to arrayOf("Never", "Rarely","Sometimes", "Frequently"),
                "Do you prefer spicy food?" to arrayOf("Yes", "No"),
                "Do you prefer vegetarian food?" to arrayOf("Yes", "No"),
                "Do you like seafood? Y" to arrayOf("Yes", "No"),


                )
        ),
        Survey(
            "Dietary Habits",
            mapOf<String, Array<String>>(
                "Are you vegetarian? " to arrayOf("Yes", "No"),
                "Do you prefer organic food? " to arrayOf("Yes", "No"),
                "Do you consume dairy products? " to arrayOf("Yes", "No"),
                "Do you eat fast food?" to arrayOf("Yes", "No"),
                "Do you have any food allergies?" to arrayOf("Yes", "No"),


                )
        ),
        Survey(
            "Snack Preferences",
            mapOf<String, Array<String>>(
                "How often do you snack during the day? " to arrayOf("Rarely", "1-2 times","More than 5 times"),
                "Do you prefer sweet or savory snacks ?" to arrayOf("Yes", "No"),
                "Are you conscious of healthy snack options?" to arrayOf("Yes", "No"),

                )
        )


    )
}

class Survey(val name: String, val questions: Map<String, Array<String>>) : Serializable {

}








