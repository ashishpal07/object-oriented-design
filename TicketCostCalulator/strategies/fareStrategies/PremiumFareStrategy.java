package strategies.fareStrategies;

import utility.FareCalculatorUtility;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class PremiumFareStrategy implements IFareStrategy {
    @Override
    public double calculateFare(LocalTime startTime, LocalTime endTime, DayOfWeek day) {
        return FareCalculatorUtility.calculateCost(startTime, endTime, 80, 65, day);
    }
}
