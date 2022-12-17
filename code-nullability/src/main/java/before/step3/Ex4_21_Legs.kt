package before.step3

import travelator.Leg
import java.time.Duration

fun List<Leg>.longestOver7(duration: Duration): Leg? {
    // legs 파라미터를 확장 함수의 수신객체로 변환
    val longestLeg = maxByOrNull(Leg::plannedDuration)
    return when {
        longestLeg == null -> null
        longestLeg.plannedDuration > duration -> longestLeg
        else -> null
    }
}