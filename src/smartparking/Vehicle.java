package smartparking;

import java.util.Objects;

public abstract class Vehicle {
    private final String registrationNumber;
    protected Vehicle(String registrationNumber) {
        if (registrationNumber == null || registrationNumber.isBlank())
            throw new IllegalArgumentException("Registration number is required");
        this.registrationNumber = registrationNumber.trim().toUpperCase();
    }
    public final String getRegistrationNumber() { return registrationNumber; }
    protected abstract double ratePerHour();
    public double calculateFee(int minutes) {
        if (minutes < 0) throw new IllegalArgumentException("Minutes cannot be negative");
        int billableHours = (minutes + 59) / 60;
        return billableHours * ratePerHour();
    }
    @Override public boolean equals(Object obj) {
        return obj instanceof Vehicle other &&
               registrationNumber.equals(other.registrationNumber);
    }
    @Override public int hashCode() { return Objects.hash(registrationNumber); }
    @Override public String toString() { return getClass().getSimpleName() + "[" + registrationNumber + "]"; }
}
