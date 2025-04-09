public class ParkingSpace {
    int parkingId;
    boolean isOccupied;
    Vehicle vehicle;

    public ParkingSpace(int parkingId) {
        this.parkingId = parkingId;
    }
    public boolean isOccupied() {
        return isOccupied;
    }

    public void occupy(Vehicle vehicle) {
        this.isOccupied = true;
        this.vehicle = vehicle;
    }

    public void release() {
        isOccupied = false;
        vehicle = null;
    }
}
