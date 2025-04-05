import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ParkingLot {
    List<ParkingSpace> parkingSpaces;
    ParkingLot parkingLot;

    private ParkingLot(int numSpace) {
        parkingSpaces = new ArrayList<>();
        for(int i=0; i<numSpace; ++i) {
            //you can divide parking space into different vehicle type
            //for now just take single type
            parkingSpaces.add(new ParkingSpace());
        }
    }

    public synchronized ParkingLot getParkingLotInstance(int numSpace) {
        if(parkingLot == null) {
            parkingLot = new ParkingLot(numSpace);
        }
        return parkingLot;
    }

    public boolean isSpaceAvailable() {
        for(ParkingSpace space : parkingSpaces) {
            if(!space.getIsOccupied()) {
                return true;
            }
        }
        return false;
    }

    public synchronized Ticket parkVehicle(Vehicle vehicle) {
        ParkingSpace space = getParkingSpace();
        if(space == null) {
            //no space available
            return null;
        }

        Ticket ticket = new Ticket(new Random().nextInt(), new Date(), new Date(), space, vehicle);
        space.occupy();
        return ticket;
    }

    private ParkingSpace getParkingSpace() {
        for(ParkingSpace space : parkingSpaces) {
            if(space.getIsOccupied()) {
                return space;
            }
        }
        return null;
    }

    public void processExit(Ticket ticket) {
        ParkingSpace space = ticket.getParkingSpace();

    }
}
