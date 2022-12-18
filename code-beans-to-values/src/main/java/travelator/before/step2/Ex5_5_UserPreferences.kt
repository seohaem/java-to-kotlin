package travelator.before.step2

import java.util.*

// @ivmOverloads 애너테이션은 컴파일러가 greeting, locale, currency 의 디폴트 값들을 서로 조합한 여러 생성자를 만들어내도록 지정한다 .
class Ex5_5_UserPreferences @JvmOverloads constructor(
    // var : 변경 가능한 데이터 (프로퍼티마다 비공개 필드, gtter, setter 메서드 제공)
    var greeting: String = "Hello",
    var locale: Locale = Locale.UK,
    var currency: Currency = Currency.getInstance(Locale.UK)
)