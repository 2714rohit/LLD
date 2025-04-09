import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//import com.google.common.base.Preconditions;
import payment.Payment;

public class ParkingLot {
    List<ParkingSpace> parkingSpaces;
    private static ParkingLot parkingLot;

    private ParkingLot(int numSpace) {
        parkingSpaces = new ArrayList<>();
        for(int i=0; i<numSpace; ++i) {
            //you can divide parking space into different vehicle type
            //for now just take single type
            parkingSpaces.add(new ParkingSpace(i+1));
        }
    }

    //make sure there is only one instance for ParkingLot
    public static synchronized ParkingLot getParkingLotInstance(int numSpace) {
        if(parkingLot == null) {
            parkingLot = new ParkingLot(numSpace);
        }
        return parkingLot;
    }

    //this is not needed as parkVehicle will return null in case if there is no space available
    public boolean getAvailableSpace() {
        for(ParkingSpace space : parkingSpaces) {
            if(!space.isOccupied()) {
                return true;
            }
        }
        return false;
    }

    //make sure only one thread must park at any point of time
    public synchronized Ticket parkVehicle(Vehicle vehicle) {
        ParkingSpace space = getParkingSpace();
        if(space == null) {
            //no space available
            return null;
        }

        Ticket ticket = new Ticket(new Random().nextInt(), System.currentTimeMillis(), space, vehicle);
        space.occupy(vehicle);
        return ticket;
    }

    private ParkingSpace getParkingSpace() {
        for(ParkingSpace space : parkingSpaces) {
            if(!space.isOccupied()) {
                return space;
            }
        }
        return null;
    }

    public int processExit(Ticket ticket) {
        assert ticket!=null : "please provide ticket details";
        //Preconditions.checkNotNull(ticket);
        long entryTime = ticket.getEntryTime();
        ticket.setExitTime(System.currentTimeMillis());
        double parkedCharges = getParkedCharges(entryTime, ticket.getExitTime());
        //we can have different mode of payment new UpiPayment(), new ScanQR(), new CashPayment() etc
        Payment payment = new Payment();
        int transactionNumber = payment.processPayment(parkedCharges, ticket.getTicketId());
        return transactionNumber;
    }

    private double getParkedCharges(long entyTime, long exitTime) {
        //assume 20Rs per hour for any type of Vehicle
        return((exitTime-entyTime)/1000*60*60)*20;
    }

    public boolean releaseSpace(ParkingSpace space) {
        space.release();
        return true;
    }
}
