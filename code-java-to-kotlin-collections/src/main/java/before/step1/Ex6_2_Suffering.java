package before.step1;

import travelator.Journey;
import travelator.Location;

import java.util.List;

import static java.util.Comparator.comparing;
import static travelator.Other.SOME_COMPLICATED_RESULT;
import static travelator.Other.routesFor;
import static travelator.Routes.getDepartsFrom;

public class Ex6_2_Suffering {

    public static int sufferScoreFor(List<Journey> route) {
        List<Journey> longestJourneys = longestJourneysIn(route, 3);
        return sufferScore(longestJourneys, getDepartsFrom(route));
    }

    public static List<Journey> longestJourneysIn(
            List<Journey> journeys,
            int limit
    ) {
        // sort : 자기 자신을 정렬한 복사본을 만들고, 그 복사본에 일치하도록 자신을 변경시킨다.
        journeys.sort(comparing(Journey::getDuration).reversed()); // <1> sort에 따라 journeys 파라미터가 변경된다
        var actualLimit = Math.min(journeys.size(), limit);
        return journeys.subList(0, actualLimit);
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
