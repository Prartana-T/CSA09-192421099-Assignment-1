package smartparking;
import java.time.LocalDateTime;
import java.util.*;

public class ParkingFacility {
    private final Vehicle[][] slots;
    private final Map<String, ParkingTicket> activeTickets = new HashMap<>();
    private int occupancy;
    public ParkingFacility(int[] slotsPerFloor) {
        if (slotsPerFloor == null || slotsPerFloor.length == 0) throw new IllegalArgumentException("At least one floor required");
        slots = new Vehicle[slotsPerFloor.length][];
        for (int i=0;i<slotsPerFloor.length;i++) {
            if (slotsPerFloor[i] <= 0) throw new IllegalArgumentException("Each floor needs slots");
            slots[i] = new Vehicle[slotsPerFloor[i]];
        }
    }
    public synchronized ParkingTicket enter(Vehicle vehicle, PassType passType) {
        Objects.requireNonNull(vehicle);
        if (activeTickets.containsKey(vehicle.getRegistrationNumber()))
            throw new IllegalArgumentException("Vehicle is already parked");
        int[] position = allocate(vehicle);
        if (position == null) return null;
        ParkingTicket ticket = new ParkingTicket(vehicle, position[0], position[1], passType);
        activeTickets.put(vehicle.getRegistrationNumber(), ticket);
        occupancy++;
        return ticket;
    }
    private int[] allocate(Vehicle vehicle) {
        for (int f=0;f<slots.length;f++) {
            for (int s=0;s<slots[f].length;s++) {
                if (slots[f][s] == null) { slots[f][s] = vehicle; return new int[]{f,s}; }
            }
        }
        return null;
    }
    public synchronized double exit(String registrationNumber, LocalDateTime exitTime, int chargingKWh) {
        ParkingTicket ticket = activeTickets.remove(registrationNumber.trim().toUpperCase());
        if (ticket == null) throw new IllegalArgumentException("No active ticket for vehicle");
        slots[ticket.getFloor()][ticket.getSlot()] = null;
        occupancy--;
        return ticket.feeAt(exitTime, chargingKWh);
    }
    public int getOccupancy() { return occupancy; }
    public int getCapacity() { return Arrays.stream(slots).mapToInt(a -> a.length).sum(); }
    public synchronized boolean release(int floor, int slot) {
        if (floor < 0 || floor >= slots.length || slot < 0 || slot >= slots[floor].length || slots[floor][slot] == null)
            return false;
        Vehicle vehicle = slots[floor][slot];
        slots[floor][slot] = null;
        activeTickets.remove(vehicle.getRegistrationNumber());
        occupancy--;
        return true;
    }
}
