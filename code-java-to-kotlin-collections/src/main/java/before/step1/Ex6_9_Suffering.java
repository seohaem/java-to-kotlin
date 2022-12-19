package before.step1;

import travelator.Journey;
import travelator.Location;

import java.util.List;

import static java.util.Comparator.comparing;
import static travelator.Other.SOME_COMPLICATED_RESULT;
import static travelator.Collections.sorted;
import static travelator.Other.routesFor;
import static travelator.Routes.getDepartsFrom;

public class Ex6_9_Suffering {

    /* longestjourneysln의 부수 효과에 따라 영향을 받지 않는다. 따라서 지역 변수를 인라이닝할 수 있다． */
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
        removeUnbearableRoutes(routes);
        return routes;
    }

    private static void removeUnbearableRoutes(List<List<Journey>> routes) {
        routes.removeIf(route -> sufferScoreFor(route) > 10);
    }

    private static int sufferScore(
            List<Journey> longestJourneys,
            Location start
    ) {
        return SOME_COMPLICATED_RESULT();
    }
}