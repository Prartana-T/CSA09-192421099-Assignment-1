package smartparking;
import java.time.LocalDateTime;

public final class ParkingTicket {
    private static long nextTicketNumber = 1000;
    private final String ticketNumber;
    private final Vehicle vehicle;
    private final int floor;
    private final int slot;
    private final LocalDateTime entryTime;
    private final PassType passType;

    public ParkingTicket(Vehicle vehicle, int floor, int slot, PassType passType) {
        this(vehicle, floor, slot, passType, LocalDateTime.now());
    }
    public ParkingTicket(Vehicle vehicle, int floor, int slot, PassType passType, LocalDateTime entryTime) {
        if (vehicle == null || passType == null || entryTime == null || floor < 0 || slot < 0)
            throw new IllegalArgumentException("Invalid ticket data");
        this.ticketNumber = "PK-" + (++nextTicketNumber);
        this.vehicle = vehicle;
        this.floor = floor;
        this.slot = slot;
        this.passType = passType;
        this.entryTime = entryTime;
    }
    public String getTicketNumber() { return ticketNumber; }
    public Vehicle getVehicle() { return vehicle; }
    public int getFloor() { return floor; }
    public int getSlot() { return slot; }
    public LocalDateTime getEntryTime() { return entryTime; }
    public PassType getPassType() { return passType; }
    public double feeAt(LocalDateTime exitTime, int chargingKWh) {
        if (exitTime.isBefore(entryTime)) throw new IllegalArgumentException("Exit precedes entry");
        if (passType == PassType.STUDENT_MONTHLY || passType == PassType.STAFF_MONTHLY ||
            passType == PassType.VISITOR_DAY) return 0.0;
        long minutes = java.time.Duration.between(entryTime, exitTime).toMinutes();
        double fee = vehicle instanceof DeliveryVan van
            ? van.calculateFee((int) minutes, entryTime.toLocalTime())
            : vehicle.calculateFee((int) minutes);
        if (vehicle instanceof Chargeable chargeable) fee += chargeable.chargingFee(chargingKWh);
        return fee;
    }
}
