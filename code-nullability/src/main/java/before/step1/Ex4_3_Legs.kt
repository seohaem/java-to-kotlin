package before.step1

import travelator.Leg
import java.time.Duration
import java.util.*

object Ex4_3_Legs {
    @JvmStatic
    fun findLongestLegOver(
        /* null이 될 수 없는 파라미터로 지정
        *  - 컴파일러가 함수 본문 이전에 널 검사를 추가해준다.
        * 이런 방식으로 null을 몰래 함수에 전달해도 그 사실을 캐치할 수 있다.
        * */
        legs: List<Leg>,
        duration: Duration
    ): Optional<Leg> {
        var result: Leg? = null
        for (leg in legs) {
            if (isLongerThan(leg, duration))
                if (result == null ||
                    isLongerThan(leg, result.plannedDuration)
                )
                    result = leg
        }
        return Optional.ofNullable(result)
    }

    private fun isLongerThan(leg: Leg, duration: Duration): Boolean {
        return leg.plannedDuration.compareTo(duration) > 0
    }
}