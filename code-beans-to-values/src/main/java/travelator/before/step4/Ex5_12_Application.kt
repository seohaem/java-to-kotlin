package travelator.before.step4

import travelator.before.WelcomeView2
import travelator.before.step1.WelcomeView
import travelator.before.step2.Ex5_5_UserPreferences
import travelator.before.step3.Ex5_10_UserPreferences

class Application(
    private var preferences: Ex5_10_UserPreferences
) {
    fun showWelcome() {
        WelcomeView(preferences).show()
    }

    fun editPreferences() {
        preferences = Ex5_11_PreferencesView().showModal(preferences)
    }
}