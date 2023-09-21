package helper;

import java.time.Duration;
import java.time.temporal.Temporal;

public class TimeHelper {
    public static double timeCalculator(Temporal startTime, Temporal endTime) {
        Duration timePassed = Duration.between(startTime, endTime);
        double spendTime = timePassed.toSeconds();
        return spendTime;
    }
}
