package travelator.before.step1;

import travelator.before.View;

import java.util.Currency;
import java.util.Locale;

public class Ex5_3_PreferencesView extends View {

    private final Ex5_1_UserPreferences preferences;
    private final GreetingPicker greetingPicker = new GreetingPicker();
    private final LocalePicker localePicker = new LocalePicker();
    private final CurrencyPicker currencyPicker = new CurrencyPicker();

    /**
     * 생성자
     * @param preferences
     */
    public Ex5_3_PreferencesView(Ex5_1_UserPreferences preferences) {
        this.preferences = preferences;
    }

    public void show() {
        greetingPicker.setGreeting(preferences.getGreeting());
        localePicker.setLocale(preferences.getLocale());
        currencyPicker.setCurrency(preferences.getCurrency());
        super.show();
    }

    /**
     * preferences 변경
     */
    protected void onGreetingChange() {
        preferences.setGreeting(greetingPicker.getGreeting());
    }

    protected void onLocaleChange() {
        preferences.setLocale(localePicker.getLocale());
    }

    protected void onCurrencyChange() {
        preferences.setCurrency(currencyPicker.getCurrency());
    }
}

class GreetingPicker {
    private String greeting;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}

class LocalePicker {
    private Locale locale;

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}

class CurrencyPicker {
    private Currency currency;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}

