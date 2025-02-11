package models;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class PeakHourManager {
    public static PeakHourManager instance = new PeakHourManager();

    // We can modify this in future
    public List<Time> peakHourManagerList = new ArrayList<>(List.of(
            new Time(LocalTime.of(7, 0), LocalTime.of(10, 30)),
            new Time(LocalTime.of(17, 0), LocalTime.of(20, 0))
    ));

    private PeakHourManager() {}

    public static PeakHourManager getInstance() {
        return instance;
    }

    public boolean isPeakHour(LocalTime time) {
        return peakHourManagerList.stream().anyMatch(timeRange -> timeRange.isWithinRange(time));
    }

    public long getPeakMinutes(LocalTime startTime, LocalTime endTime, DayOfWeek day) {
        System.out.println("get peak minutes called.");
        if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
            return 0;
        }
        peakHourManagerList.sort((Time a, Time b) -> a.getStart().compareTo(b.getStart()));

        System.out.println("peakHourList = " + peakHourManagerList);

        long peakMinutes = 0;
        for (Time peakTime: peakHourManagerList) {
            if (endTime.isAfter(peakTime.getStart())) {
                LocalTime startTimeOverlap = startTime.isAfter(peakTime.getStart()) ? startTime : peakTime.getStart();
                LocalTime endTimeOverlap = endTime.isAfter(peakTime.getEnd()) ? peakTime.getEnd() : endTime;

                peakMinutes += Duration.between(startTimeOverlap, endTimeOverlap).toMinutes();
            }
        }
        return peakMinutes;
    }
}
