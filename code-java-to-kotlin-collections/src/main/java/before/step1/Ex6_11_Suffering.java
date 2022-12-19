package before.step1;

import travelator.Journey;
import travelator.Location;

import java.util.List;

import static java.util.Comparator.comparing;
import static travelator.Collections.sorted;
import static travelator.Other.SOME_COMPLICATED_RESULT;
import static travelator.Other.routesFor;
import static travelator.Routes.getDepartsFrom;

public class Ex6_11_Suffering {

    public static int sufferScoreFor(List<Journey> route) {
        return sufferScore(
                longestJourneysIn(route, 3),
                getDepartsFrom(route));
    }

    static List<Journey> longestJourneysIn(
            List<Journey> journeys,
            int limit
    ) {
        var actualLimit = Math.min(journeys.size(), limit);
        return sorted(
                journeys,
                comparing(Journey::getDuration).reversed()
        ).subList(0, actualLimit);
    }

    public static List<List<Journey>> routesToShowFor(String itineraryId) {
        var routes = routesFor(itineraryId);
        // routes 재대입은 보기 나쁘지만 5장의 리팩터링과 같은 방향의 변화이기 때문에 의도적이다.
        // '어떤 데이터를 제자리에서 변경하는 코드를 '새로운 값을 계산하고 참조가 이 새 값을 가리키게 하는' 코드로 변경했다.
        routes = removeUnbearableRoutes(routes);
        return routes;
    }

    private static List<List<Journey>> removeUnbearableRoutes
            (List<List<Journey>> routes
            ) {
        // re
        routes.removeIf(route -> sufferScoreFor(route) > 10);
        return routes;
    }

    private static int sufferScore(
            List<Journey> longestJourneys,
            Location start
    ) {
        return SOME_COMPLICATED_RESULT();
    }
}