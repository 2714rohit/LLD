import enums.VehicleType;

public class Vehicle {
    int registrationNumber;
    VehicleType vehicleType;
    public Vehicle(VehicleType vehicleType, int registrationNumber) {
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }
}
