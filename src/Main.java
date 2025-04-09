import enums.VehicleType;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ParkingLot parkingLot = ParkingLot.getParkingLotInstance(10);
        Ticket ticket = parkingLot.parkVehicle(new Vehicle(VehicleType.LARGE_VEHICLE, 12345));
        if(ticket == null) {
            System.out.println("No space avilable");
        }
        int transactionId = parkingLot.processExit(ticket);
        System.out.println("transactionId "+transactionId);
        boolean releaseSpace = parkingLot.releaseSpace(ticket.getParkingSpace());
        if(releaseSpace) {
            System.out.println("successfully released parking space");
        } else {
            System.out.println("issue while releasing parking space, please again");
        }
    }
}