package before.step3

import travelator.Leg
import java.time.Duration

fun longestLegOver2(
    legs: List<Leg>,
    duration: Duration
): Leg? {
    // maxByOrNull 함수 사용
    val longestLeg: Leg? = legs.maxByOrNull(Leg::plannedDuration)
    if (longestLeg != null && longestLeg.plannedDuration > duration)
        return longestLeg
    else
        return null
}