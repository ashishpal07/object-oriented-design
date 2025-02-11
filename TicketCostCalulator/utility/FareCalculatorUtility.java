package utility;

import models.PeakHourManager;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class FareCalculatorUtility {
    public static double calculateCost(LocalTime startTime, LocalTime endTime, int peakHourRate, int offPeakHourRate, DayOfWeek day) {
        PeakHourManager peakHour = PeakHourManager.getInstance();

        long peakHourMinutes = peakHour.getPeakMinutes(startTime, endTime, day);
        System.out.println("peak minutes " + peakHourMinutes);
        long totalMinutes = Duration.between(startTime, endTime).toMinutes();

        System.out.println("totalMinutes " + totalMinutes);
        long offPeakHourMinutes = totalMinutes - peakHourMinutes;

        System.out.println("off peak min " + offPeakHourMinutes);

        long totalCost = (offPeakHourMinutes * offPeakHourRate / 60) + (peakHourMinutes * peakHourRate / 60);
        System.out.println("totalCost = " + totalCost);
        return totalCost;
    }
}
