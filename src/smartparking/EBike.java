package smartparking;
public class EBike extends TwoWheeler implements Chargeable {
    public EBike(String regNo) { super(regNo); }
    @Override protected double ratePerHour() { return 10.0; }
    @Override public double chargingFee(int kWh) {
        if (kWh < 0) throw new IllegalArgumentException("kWh cannot be negative");
        return 20.0; // Flat charging fee for an e-bike.
    }
}
