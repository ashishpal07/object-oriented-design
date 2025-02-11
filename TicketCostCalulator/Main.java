import models.*;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Main {
  public static void main(String[] args) {
    Time travelTime = new Time(LocalTime.of(12, 0), LocalTime.of(22, 0));
    User user = new User("Abc", "salesforce@gmail.com");
    PeakHourManager peakHourManager = PeakHourManager.getInstance();
    BusType busType = BusType.Economy;
    DayOfWeek day = DayOfWeek.FRIDAY;

    Journey journey = new Journey(travelTime.getStart(), travelTime.getEnd(), day);

    Ticket ticket = new Ticket(user, journey, busType);

    System.out.println(ticket.calculateMinCost());
  }
}


/**
*
Design a ticketing cost calculator for a bus service.

There are three types of services available - Economy, Comfort, and Premium. Below are the details along with the pricing scheme 
for all three types in peak and off-peak hours:

Type	   Peak hours (per hour)	Off-peak hours (per hour)
Economy	    50	                         40
Comfort	    60	                         50
Premium	    80	                         65

Peak Hours Timings
Monday to Friday: [07:00 - 10:30, 17:00 - 20:00]

Customers can also purchase a day pass, which allows unlimited travel in a single day without incurring any extra cost.

Day Pass Cost
Economy: 250
Comfort: 300
Premium: 450
Task
Design a system that outputs the least amount the customer can spend to get to their destination,
given a list of journeys with the start and end times and the type of bus chosen.
*
*/
