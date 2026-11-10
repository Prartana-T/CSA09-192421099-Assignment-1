package smartparking;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        ParkingFacility facility = new ParkingFacility(new int[]{3, 2, 4, 3, 2});
        ParkingTicket t1 = facility.enter(new TwoWheeler("TN01A1234"), PassType.VISITOR);
        ParkingTicket t2 = facility.enter(new Car("TN02B2345"), PassType.STUDENT_MONTHLY);
        ParkingTicket t3 = facility.enter(new ElectricCar("TN03C3456"), PassType.VISITOR);
        ParkingTicket t4 = facility.enter(new EBike("TN04D4567"), PassType.VISITOR_DAY);
        ParkingTicket t5 = facility.enter(new DeliveryVan("TN05E5678"), PassType.VISITOR);
        System.out.println("Tickets issued: " + (t1 != null) + ", " + (t2 != null) + ", " + (t3 != null) + ", " + (t4 != null) + ", " + (t5 != null));
        System.out.println("Occupancy: " + facility.getOccupancy() + "/" + facility.getCapacity());
        LocalDateTime exit = t1.getEntryTime().plusMinutes(61);
        System.out.println("Two-wheeler fee for 61 minutes: Rs " + facility.exit("TN01A1234", exit, 0));
        System.out.println("Occupancy after exit: " + facility.getOccupancy());
        System.out.println("Student monthly pass fee: Rs " +
            facility.exit("TN02B2345", t2.getEntryTime().plusHours(2), 0));
        System.out.println("Electric car fee incl. 10 kWh: Rs " +
            facility.exit("TN03C3456", t3.getEntryTime().plusMinutes(130), 10));
        facility.exit("TN04D4567", t4.getEntryTime().plusMinutes(30), 1);
        System.out.println("Delivery van test completed: " +
            facility.exit("TN05E5678", t5.getEntryTime().plusMinutes(60), 0));
    }
}
