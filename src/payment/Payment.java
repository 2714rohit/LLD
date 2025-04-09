package payment;

import java.util.Random;

public class Payment {
    int ticketId;
    double fee;

    public Payment() {

    }

    //We can have different mode of payment
    public boolean processPayment(double fee, int ticketId) {
        this.fee = fee;
        this.ticketId = ticketId;
        return true;
    }
}
