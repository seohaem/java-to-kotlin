package travelator.before.step4

import travelator.before.View
import travelator.before.step3.CurrencyPicker
import travelator.before.step3.Ex5_10_UserPreferences
import travelator.before.step3.GreetingPicker
import travelator.before.step3.LocalePicker
import java.util.*

// PreferencesView 안에 사용자 설정에 대한 가변 참조를 두는 것은 약간 주저스럽다.
//(
//private var preferences: Ex5_10_UserPreferences
//)
class Ex5_11_PreferencesView : View() {
    private val greetingPicker = GreetingPicker()
    private val localePicker = LocalePicker()
    private val currencyPicker = CurrencyPicker()

    fun showModal(preferences: Ex5_10_UserPreferences): Ex5_10_UserPreferences {
        greetingPicker.greeting = preferences.greeting
        localePicker.locale = preferences.locale
        currencyPicker.currency = preferences.currency
        show()
        // 아예 참조를 유지하지 않고 showModal에 사용자 설정을 넘기는 방식으로 이 문제를 해결할 수 있다.
        return Ex5_10_UserPreferences(
            greeting = greetingPicker.greeting,
            locale = localePicker.locale,
            currency = currencyPicker.currency
        )
    }
}

internal class GreetingPicker {
    var greeting: String = ""
}

internal class LocalePicker {
    var locale: Locale = Locale.UK
}

internal class CurrencyPicker {
    var currency: Currency = Currency.getInstance(Locale.UK)
}