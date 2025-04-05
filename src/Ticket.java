import java.util.Date;

public class Ticket {
    int ticketId;
    Date entryTime;
    Date exitTime;
    ParkingSpace parkingSpace;
    Vehicle vehicle;

    public Ticket(int ticketId, Date entryTime, Date exitTime, ParkingSpace parkingSpace, Vehicle vehicle) {
        this.ticketId = ticketId;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.parkingSpace = parkingSpace;
        this.vehicle = vehicle;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }
}
