package before.step3

import travelator.Leg
import java.time.Duration

/**
 * 가장 긴 구간을 찾고 , 그 가장 긴 구간이 주어진 기간보다 길다면 그 값을 반환하고 , 그렇지 않다면 null을 반환한다.
 */
fun longestLegOver(
    legs: List<Leg>,
    duration: Duration
): Leg? {
    var result: Leg? = null
    for (leg in legs) {
        if (leg.isLongerThan(duration))
            if (result == null ||
                leg.isLongerThan(result.plannedDuration))
                result = leg
    }
    return result
}

private fun Leg.isLongerThan(duration: Duration) =
    plannedDuration.compareTo(duration) > 0