package before.step3

import travelator.Leg
import java.time.Duration

/**
 * 현재버전
 * object 키워드
 * object로 클래스를 정의하면, 싱클턴(Singleton) 패턴이 적용되어 객체가 한번만 생성
 * - longestLegOver는 자바에서 정적메서드 였으므로 object에 추가
 */
object Legs {
    fun longestLegOver(
        legs: List<Leg>,
        duration: Duration
    ): Leg? {
        var result: Leg? = null
        for (leg in legs) {
            if (isLongerThan(leg, duration))
                if (result == null ||
                    isLongerThan(leg, result.plannedDuration))
                    result = leg
        }
        return result
    }

//    private fun isLongerThan(leg: Leg, duration: Duration): Boolean {
//        return leg.plannedDuration.compareTo(duration) > 0
//    }

    /* 예제 4.13 */
    private fun isLongerThan(leg: Leg, duration: Duration) =
        leg.plannedDuration.compareTo(duration) > 0
}