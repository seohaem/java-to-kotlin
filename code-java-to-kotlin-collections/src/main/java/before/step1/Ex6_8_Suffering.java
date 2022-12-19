package before.step1;

import travelator.Journey;
import travelator.Location;

import java.util.List;

import static java.util.Comparator.comparing;
import static travelator.Other.SOME_COMPLICATED_RESULT;
import static travelator.Collections.sorted;
import static travelator.Other.routesFor;
import static travelator.Routes.getDepartsFrom;

public class Ex6_8_Suffering {

    public static int sufferScoreFor(List<Journey> route) {
        Location start = getDepartsFrom(route);
        List<Journey> longestJourneys = longestJourneysIn(route, 3);
        return sufferScore(longestJourneys, start);
    }

    static List<Journey> longestJourneysIn(
            List<Journey> journeys,
            int limit
    ) {
        var actualLimit = Math.min(journeys.size(), limit);
        // sorted()
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