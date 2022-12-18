package travelator.before.step3

import travelator.before.WelcomeView2
import travelator.before.step2.Ex5_5_UserPreferences

class Ex5_8_Application(
//    private val preferences: Ex5_5_UserPreferences
    private var preferences: Ex5_5_UserPreferences
) {
    fun showWelcome() {
        WelcomeView2(preferences).show()
    }

    /*
        Application. editPreferences(）는 preferencesView.show(）를 호출하고
        애플리케이션과 사용자 설정 뷰가 모두 같은 가변 객체에 대한 참조를 공유함으로써,
        변경된 내용을 얻을 수 있다는 점에 의지한다.
     */
    fun editPreferences() {
//        Ex5_3_PreferencesView(preferences).show()
        // 예제 5.8
        preferences = Ex5_6_PreferencesView(preferences).showModal() // 가변 프로퍼티
    }
}