package before.step2

import travelator.Journey
import travelator.Location
import travelator.Other.SOME_COMPLICATED_RESULT
import travelator.Other.routesFor
import travelator.Routes

/**
 * 리팩토링 완료 코드
 *
 * 1) 자바가 코틀린에 전달한 컬렉션 내부를 변경할 수 있다는 사실을 인식하라.
 * 2) 자바가 코틀린으로부터 전달받은 컬렉션 내부를 변경할 수 있다는（적어도 내부를 변경하려고 시도해볼수 있다는） 사실을 인식하라.
 * 3) 자바 컬렉션을 사용하는 코드에서 컬렉션 내부 상태 변경을 제거하라. 상태 변경을 제거할 수 없는 경우 에는 방어적 복사를 수행하라.
 */
object Ex6_22_Suffering {
    @JvmStatic
    fun sufferScoreFor(route: List<Journey>): Int =
        sufferScore(
            route.longestJourneys(limit = 3),
            Routes.getDepartsFrom(route)
        )

    @JvmStatic
    fun List<Journey>.longestJourneys(limit: Int): List<Journey> =
        sortedByDescending { it.duration }.take(limit)

    fun routesToShowFor(itineraryId: String?): List<List<Journey>> =
        bearable(routesFor(itineraryId))

    private fun bearable(routes: List<List<Journey>>): List<List<Journey>> =
        routes.filter { sufferScoreFor(it) <= 10 }

    private fun sufferScore(
        longestJourneys: List<Journey>,
        start: Location
    ): Int = SOME_COMPLICATED_RESULT()
}