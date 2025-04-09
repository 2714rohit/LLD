import enums.VehicleType;
import payment.Payment;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ParkingLot parkingLot = ParkingLot.getParkingLotInstance(10);
        Ticket ticket = parkingLot.parkVehicle(new Vehicle(VehicleType.LARGE_VEHICLE, 12345, "IND12345"));
        if(ticket == null) {
            System.out.println("No space avilable");
        }
        double parkedCharges = parkingLot.processExit(ticket);
        System.out.println("parkedCharges "+parkedCharges);
        //No need of high coupling Payment entity should exist independently, having only ticketId i.e. Aggregation
        Payment payment = new Payment(); // we can have different type of payment instance here
        boolean paymentDone = payment.processPayment(parkedCharges, ticket.ticketId);
        if(paymentDone) {
            System.out.println("Payment successful");
        } else {
            System.out.println("Paymen failed");
        }
        boolean releaseSpace = parkingLot.releaseSpace(ticket.getParkingSpace());
        if(releaseSpace) {
            System.out.println("successfully released parking space");
        } else {
            System.out.println("issue while releasing parking space, please again");
        }
    }
}