package utility;

import models.PeakHourManager;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class FareCalculatorUtility {
    public static double calculateCost(LocalTime startTime, LocalTime endTime, int peakHourRate, int offPeakHourRate, DayOfWeek day) {
        PeakHourManager peakHour = PeakHourManager.getInstance();

        long peakHourMinutes = peakHour.getPeakMinutes(startTime, endTime, day);
        long totalMinutes = Duration.between(startTime, endTime).toMinutes();
        long offPeakHourMinutes = totalMinutes - peakHourMinutes;

        return ((double) (offPeakHourMinutes * offPeakHourRate) / 60) + ((double) (peakHourMinutes * peakHourRate) / 60);
    }
}
