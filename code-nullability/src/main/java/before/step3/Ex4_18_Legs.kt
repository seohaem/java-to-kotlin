package before.step3

import travelator.Leg
import java.time.Duration

fun longestLegOver4(
    legs: List<Leg>,
    duration: Duration
): Leg? =
    /*
     * ?.let식
     * ?.는 수신 객체가 null이면 null로 평가되고, 그렇지않으면 let 블록으로 가장 긴 구간을 전달
     * 따라서 let 안에서 longestLeg는 null일 수 없다 .
     */
    legs.maxByOrNull(Leg::plannedDuration)?.let { longestLeg ->
        if (longestLeg.plannedDuration > duration)
            longestLeg
        else
            null
    }