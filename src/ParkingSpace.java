public class ParkingSpace {
    int parkingId;
    boolean isOccupied;
    Vehicle vehicle;

    public boolean getIsOccupied() {
        return isOccupied;
    }

    public void occupy() {
        this.isOccupied = true;
    }
}
