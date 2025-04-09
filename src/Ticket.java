import java.util.Date;

public class Ticket {
    int ticketId;
    long entryTime;
    long exitTime;
    ParkingSpace parkingSpace;
    Vehicle vehicle;

    public Ticket(int ticketId, long entryTime, ParkingSpace parkingSpace, Vehicle vehicle) {
        this.ticketId = ticketId;
        this.entryTime = entryTime;
        this.parkingSpace = parkingSpace;
        this.vehicle = vehicle;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public long getExitTime() {
        return exitTime;
    }

    public void setExitTime(long exitTime) {
        this.exitTime = exitTime;
    }

    public int getTicketId() {
        return ticketId;
    }
}
