package before.step1;

import travelator.Journey;
import travelator.Location;

import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toUnmodifiableList;
import static travelator.Other.SOME_COMPLICATED_RESULT;
import static travelator.Collections.sorted;
import static travelator.Other.routesFor;
import static travelator.Routes.getDepartsFrom;

public class Ex6_13_Suffering {

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

    /**
     * 인라이닝 리팩토링
     * @param itineraryId
     * @return
     */
    public static List<List<Journey>> routesToShowFor(String itineraryId) {
        return bearable(routesFor(itineraryId));
    }

    private static List<List<Journey>> bearable
            (List<List<Journey>> routes
            ) {
        return routes.stream()
                .filter(route -> sufferScoreFor(route) <= 10)
                .collect(toUnmodifiableList());
    }

    private static int sufferScore(
            List<Journey> longestJourneys,
            Location start
    ) {
        return SOME_COMPLICATED_RESULT();
    }
}