package before.step1;

import travelator.Leg;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

public class Ex4_1_Legs {

    public static Optional<Leg> findLongestLegOver(
            List<Leg> legs,
            Duration duration
    ) {
        Leg result = null; // null 가능
        for (Leg leg : legs) {
            if (isLongerThan(leg, duration))
                if (result == null ||
                        isLongerThan(leg, result.getPlannedDuration())
                ) {
                    result = leg;
                }
        }
        return Optional.ofNullable(result);
    }

    private static boolean isLongerThan(Leg leg, Duration duration) {
        return leg.getPlannedDuration().compareTo(duration) > 0;
    }
}
