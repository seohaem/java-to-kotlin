package before.step3

import travelator.Leg
import java.time.Duration

fun longestLegOver6(
    legs: List<Leg>,
    duration: Duration
): Leg? =
    // takelf
    // 술어가 true이면 수신객체를 반환하고 ture가 아니면 null을 반환한다.
    legs.maxByOrNull(Leg::plannedDuration)?.takeIf { longestLeg ->
        longestLeg.plannedDuration > duration
    }