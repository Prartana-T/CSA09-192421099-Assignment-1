
package smartparking;

import java.time.LocalDateTime;

public class SmartParkingTests {

    static void check(String test, boolean result) {
        System.out.println(test + " : " +
            (result ? "PASS" : "FAIL"));
    }

    public static void main(String[] args) {

        System.out.println("CAMPUS SMART PARKING - TESTING");
        System.out.println("--------------------------------");

        // Test 1: Normal vehicle entry
        ParkingFacility p1 =
            new ParkingFacility(new int[]{2, 2});

        ParkingTicket t1 = p1.enter(
            new TwoWheeler("TN01A1111"),
            PassType.VISITOR
        );

        check("Normal vehicle entry", t1 != null);

        // Test 2: Duplicate registration
        boolean duplicateRejected = false;

        try {
            p1.enter(
                new Car("TN01A1111"),
                PassType.VISITOR
            );
        } catch (IllegalArgumentException e) {
            duplicateRejected = true;
        }

        check("Duplicate registration", duplicateRejected);

        // Test 3: Last available slot
        ParkingFacility p2 =
            new ParkingFacility(new int[]{1, 1});

        p2.enter(new Car("TN02A2222"), PassType.VISITOR);

        ParkingTicket last = p2.enter(
            new Car("TN03A3333"),
            PassType.VISITOR
        );

        check("Last available slot", last != null
            && last.getFloor() == 1
            && last.getSlot() == 0);

        // Test 4: Full parking facility
        check("Full facility rejection",
            p2.enter(new Car("TN04A4444"),
            PassType.VISITOR) == null);

        // Test 5: Zero-minute parking
        ParkingTicket zero = new ParkingTicket(
            new TwoWheeler("TN05A5555"),
            0, 0, PassType.VISITOR,
            LocalDateTime.of(2026, 11, 10, 10, 0)
        );

        check("Zero-minute parking",
            zero.feeAt(zero.getEntryTime(), 0) == 0.0);

        // Test 6: Exactly 60 minutes
        check("60-minute fee boundary",
            zero.feeAt(
                zero.getEntryTime().plusMinutes(60), 0
            ) == 10.0);

        // Test 7: Invalid slot number
        check("Invalid slot rejection",
            !p1.release(9, 0));

        System.out.println("--------------------------------");
        System.out.println("TESTING COMPLETED");
    }
}
