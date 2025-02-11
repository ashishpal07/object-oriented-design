package strategies.fareStrategies;

import java.time.DayOfWeek;
import java.time.LocalTime;

public interface IFareStrategy {
    double calculateFare(LocalTime startTime, LocalTime endTime, DayOfWeek day);
}
