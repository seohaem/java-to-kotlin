package travelator.before.step1;

public class Ex5_2_Application {
    // 설정이 필요한 view에 이 프로퍼티를 전달한다.
    private final Ex5_1_UserPreferences preferences;

    public Ex5_2_Application(Ex5_1_UserPreferences preferences) {
        this.preferences = preferences;
    }

    public void showWelcome() {
        new WelcomeView(preferences).show();
    }

    public void editPreferences() {
        new Ex5_3_PreferencesView(preferences).show();
    }
}
