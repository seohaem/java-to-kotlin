package travelator.before.step3

import travelator.before.View
import travelator.before.step2.Ex5_5_UserPreferences
import travelator.mobile.CurrencyPicker
import travelator.mobile.GreetingPicker
import travelator.mobile.LocalePicker
import java.util.*

class Ex5_6_PreferencesView(
    private val preferences: Ex5_5_UserPreferences
) : View() {
    private val greetingPicker = GreetingPicker()
    private val localePicker = LocalePicker()
    private val currencyPicker = CurrencyPicker()

//    override fun show() {
//        greetingPicker.greeting = preferences.greeting
//        localePicker.locale = preferences.locale
//        currencyPicker.currency = preferences.currency
//        super.show()
//    }
    /*
        show 라는 이름을 showModal 으로 바꾸고,
        super. show(）가반환되면 기존의 가변 preferences 프로퍼티를 반환하도록 만든다．
     */
    fun showModal(): Ex5_5_UserPreferences {
        greetingPicker.greeting = preferences.greeting
        localePicker.locale = preferences.locale
        currencyPicker.currency = preferences.currency
        show()
        // 지금은 showModa 1 메서드가 생성자를 통해 뷰에 전달된 객쳬와 같은 객쳬를 반환한다. 따라서 아직은 아무것도 달라진 게 없다 .
        return preferences
    }

    protected fun onGreetingChange() {
        preferences.greeting = greetingPicker.greeting
    }


    protected fun onLocaleChange() {
        preferences.locale = localePicker.locale
    }

    protected fun onCurrencyChange() {
        preferences.currency = currencyPicker.currency
    }
}

internal class GreetingPicker2 {
    var greeting: String = TODO()
}

internal class LocalePicker2 {
    var locale: Locale = TODO()
}

internal class CurrencyPicker2 {
    var currency: Currency = TODO()
}