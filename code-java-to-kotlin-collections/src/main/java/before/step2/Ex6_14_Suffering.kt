package before.step2

import travelator.Collections.sorted
import travelator.Journey
import travelator.Location
import travelator.Other
import travelator.Other.SOME_COMPLICATED_RESULT
import travelator.Routes
import java.util.Comparator.comparing
import java.util.stream.Collectors

object Ex6_14_Suffering {
    @JvmStatic
    fun sufferScoreFor(route: List<Journey>): Int {
        return sufferScore(
//            longestJourneysIn(route, 3),
            route.longestJourneys(limit = 3), // <1> Ex6_18
            Routes.getDepartsFrom(route)
        )
    }

    @JvmStatic
    fun longestJourneysIn(
        journeys: List<Journey>,
        limit: Int
    ): List<Journey> {
        val actualLimit = Math.min(journeys.size, limit)
        return sorted(
            journeys,
            comparing { obj: Journey -> obj.duration }.reversed()
        ).subList(0, actualLimit)
    }

    /**
     * Ex6_17
     * take로 바꾸자
     */
    @JvmStatic
    fun longestJourneysIn2(journeys: List<Journey>, limit: Int): List<Journey> =
        journeys.sortedByDescending { it.duration }.take(limit)

    /**
     * Ex6_18
     * 확장함수로 변환했으므로, 이름을 longestJourneys 로 바꾸자
     */
    @JvmStatic
    fun List<Journey>.longestJourneys(limit: Int): List<Journey> =
        sortedByDescending { it.duration }.take(limit)

    fun routesToShowFor(itineraryId: String?): List<List<Journey>> {
        return bearable(Other.routesFor(itineraryId))
    }

    private fun bearable(routes: List<List<Journey>>): List<List<Journey>> {
        return routes.stream()
            .filter { route -> sufferScoreFor(route) <= 10 }
            .collect(Collectors.toUnmodifiableList())
    }

    /**
     * Ex6_21
     * 1) 코틀린이 List의 확장함수로  filter를 제공하므로 .stream() 호출을 없앤다
     * 2) 코틀린 filter는 List를 바로 반환하기 때문에 마지막의 toUnmodifiableList 호출도 불필요하다
     *
     * 실제 반환값의 실행 시점 타입은 가변 ArrayList다.
     * 다운캐스트를 결코 하지 않기 대문에 이런 차이가 문제는 되지 않는다.
     * 이는 자바에서도 공유된 컬렉션을 불변 컬렉션으로 취급하기 때문에 문제가 없다.
     */
    private fun bearable2(routes: List<List<Journey>>): List<List<Journey>> =
        routes. filter { sufferScoreFor(it) <= 10 }

    private fun sufferScore(
        longestJourneys: List<Journey>,
        start: Location
    ): Int {
        return SOME_COMPLICATED_RESULT()
    }
}