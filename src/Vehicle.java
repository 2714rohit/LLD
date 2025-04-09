import enums.VehicleType;

public class Vehicle {
    String vehicleId;
    int registrationNumber;
    VehicleType vehicleType;
    public Vehicle(VehicleType vehicleType, int registrationNumber, String vehicleId) {
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
        this.vehicleId = vehicleId;
    }
}
