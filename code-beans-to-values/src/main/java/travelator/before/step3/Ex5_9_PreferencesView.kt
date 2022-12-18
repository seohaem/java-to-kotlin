package travelator.before.step3

import travelator.before.View
import java.util.*

class PreferencesView(
    private var preferences: Ex5_10_UserPreferences // PreferencesView 안에 사용자 설정에 대한 가변 참조를 두는 것은 약간 주저스럽다．
) : View() {
    private val greetingPicker = GreetingPicker()
    private val localePicker = LocalePicker()
    private val currencyPicker = CurrencyPicker()

    fun showModal(): Ex5_10_UserPreferences {
        greetingPicker.greeting = preferences.greeting
        localePicker.locale = preferences.locale
        currencyPicker.currency = preferences.currency
        show()
        return preferences
    }

    // 이제 UI 요소가 갱신될 때 preference 프로퍼 티에 새로운 UserPreferences 객쳬를 지정할 수 있게 하기 위해
    // PreferencesView의 preferences 프로퍼티를 가변으로 만듦으로써 상황을 더 악화시킨다.
    // 세터가 없으므로, 코틀린에서 이는 var 프로퍼티를 val로 변경하고 디폴트 생성자 안에 넣자.
    protected fun onGreetingChange() {
        preferences = Ex5_10_UserPreferences(
            greetingPicker.greeting,
            preferences.locale,
            preferences.currency
        )
    }


    protected fun onLocaleChange() {
        preferences = Ex5_10_UserPreferences(
            preferences.greeting,
            localePicker.locale,
            preferences.currency
        )
    }

    protected fun onCurrencyChange() {
        preferences = Ex5_10_UserPreferences(
            preferences.greeting,
            preferences.locale,
            currencyPicker.currency
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