package travelator.before.step3

import java.util.*

/**
 * 불변클래스가 되어서 data 클래스로 변경했다.
 * 데이터 클래스는 equals, hashCode를 구현해주므로 사용시 조심해야한다.
 *
 * 데이터 클래스는 주 생성자에 선언된 모든 프로퍼티로부터 equals와 hashCode 메서드를 자동으로 만들어 준다.
 * 따라서 같은 데이터 클쾌스에 속한 두 인스턴스는 모든 프로퍼티 값이 동등할때 서로 동등하다．
 */
data class Ex5_10_UserPreferences(
    val greeting: String, // var -> val(불변) 변경
    val locale: Locale,
    val currency: Currency
)