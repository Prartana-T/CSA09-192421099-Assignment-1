package smartparking;
import java.time.LocalTime;
public class DeliveryVan extends Vehicle {
    public DeliveryVan(String regNo) { super(regNo); }
    @Override protected double ratePerHour() { return 30.0; }
    public double calculateFee(int minutes, LocalTime entryTime) {
        if (minutes < 0 || entryTime == null) throw new IllegalArgumentException("Invalid duration/time");
        int hours = (minutes + 59) / 60;
        LocalTime end = entryTime.plusMinutes(minutes);
        // Charge double car rate if any part of the parking interval overlaps 09:00–17:00.
        boolean overlapsDayWindow = entryTime.isBefore(LocalTime.of(17,0)) &&
                                    end.isAfter(LocalTime.of(9,0));
        return hours * ratePerHour() * (overlapsDayWindow ? 2.0 : 1.0);
    }
}
