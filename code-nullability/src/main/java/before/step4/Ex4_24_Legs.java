package before.step4;

import travelator.Leg;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Ex4_24_Legs {

    public static Optional<Leg> findLongestLegOver(
            List<Leg> legs,
            Duration duration
    ) {
        return legs.stream()
                .max(Comparator.comparing(Leg::getPlannedDuration))
                .filter(leg -> isLongerThan(leg, duration));
    }

    private static boolean isLongerThan(Leg leg, Duration duration) {
        return leg.getPlannedDuration().compareTo(duration) > 0;
    }
}
