package travelator.before.step2

import travelator.before.step1.Ex5_1_UserPreferences
import travelator.before.step1.Ex5_3_PreferencesView
import travelator.before.step1.WelcomeView

class Ex5_4_Application(
    private val preferences: Ex5_1_UserPreferences
) {
    fun showWelcome() {
        WelcomeView(preferences).show()
    }

    fun editPreferences() {
        Ex5_3_PreferencesView(preferences).show()
    }
}