
package smartparking;

import java.time.LocalDateTime;

public class Task12FeatureTests {

    static void check(String name, boolean result) {
        System.out.println(name + " : " +
            (result ? "PASS" : "FAIL"));
    }

    public static void main(String[] args) {

        System.out.println("TASK 12 - EXTENDED FEATURE TESTING");
        System.out.println("-----------------------------------");

        // Test 1: E-bike flat charging fee
        EBike bike = new EBike("TN10A1111");

        check("E-bike flat charging fee",
            bike.chargingFee(5) == 20.0);

        // Test 2: Delivery van daytime double rate
        DeliveryVan van = new DeliveryVan("TN20B2222");

        double dayFee = van.calculateFee(
            60, java.time.LocalTime.of(10, 0)
        );

        check("Delivery van daytime rate",
            dayFee == 60.0);

        // Test 3: Delivery van night rate
        double nightFee = van.calculateFee(
            60, java.time.LocalTime.of(20, 0)
        );

        check("Delivery van night rate",
            nightFee == 30.0);

        // Test 4: Visitor day pass
        ParkingTicket dayPass = new ParkingTicket(
            new Car("TN30C3333"),
            0, 0, PassType.VISITOR_DAY,
            LocalDateTime.of(2026, 11, 10, 10, 0)
        );

        check("Visitor day pass exemption",
            dayPass.feeAt(
                dayPass.getEntryTime().plusHours(5), 0
            ) == 0.0);

        // Test 5: Five floors with unequal capacities
        ParkingFacility facility =
            new ParkingFacility(new int[]{3, 2, 4, 3, 2});

        for (int i = 1; i <= 14; i++) {
            facility.enter(
                new Car("TN" + String.format("%02d", i) + "X"),
                PassType.VISITOR
            );
        }

        check("Five-floor capacity",
            facility.getCapacity() == 14);

        check("All 14 slots occupied",
            facility.getOccupancy() == 14);

        check("Fifteenth vehicle rejected",
            facility.enter(
                new Car("TN99X"),
                PassType.VISITOR
            ) == null);

        System.out.println("-----------------------------------");
        System.out.println("TASK 12 TESTING COMPLETED");
    }
}
