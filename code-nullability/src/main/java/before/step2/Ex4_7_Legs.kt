package before.step2

import travelator.Leg
import java.time.Duration
import java.util.*

object Legs2 {
    /**
     * 자바 클라이언트는 이 함수를 계속 사용
     */
    @JvmStatic
    fun findLongestLegOver(
        legs: List<Leg>,
        duration: Duration
    ): Optional<Leg> {
        /* 인라인 적용 */
        return Optional.ofNullable(longestLegOver(legs, duration))
    }

    /**
     * 코틀린 클라이언트는 널이 될수 있는 타입을 반환하는 아래 함수를 사용
     */
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

    private fun isLongerThan(leg: Leg, duration: Duration): Boolean {
        return leg.plannedDuration.compareTo(duration) > 0
    }
}