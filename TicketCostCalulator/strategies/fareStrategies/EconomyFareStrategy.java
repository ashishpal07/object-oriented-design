package strategies.fareStrategies;

import utility.FareCalculatorUtility;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class EconomyFareStrategy implements IFareStrategy{
    @Override
    public double calculateFare(LocalTime startTime, LocalTime endTime, DayOfWeek day) {
        return FareCalculatorUtility.calculateCost(startTime, endTime, 50, 40, day);
    }
}
