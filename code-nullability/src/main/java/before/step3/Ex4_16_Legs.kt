package before.step3

import travelator.Leg
import java.time.Duration

fun longestLegOver3(
    legs: List<Leg>,
    duration: Duration
): Leg? {
//    val longestLeg: Leg? = legs.maxByOrNull(Leg::plannedDuration)
//    return if (longestLeg != null && longestLeg.plannedDuration > duration)
//        longestLeg
//    else
//        null
    /* 예제4.17 Elvis ?: 연산자 */
    // 좌변이 null이 아니면 좌변 값을 돌려주고 null이면 우변 값을 돌려주는 엘비스 연산자 ?: 를 사용
    val longestLeg = legs.maxByOrNull(Leg::plannedDuration) ?:
    return null
    return if (longestLeg.plannedDuration > duration)
        longestLeg
    else
        null
}