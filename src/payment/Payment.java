package payment;

import java.util.Random;

public class Payment {
    int ticketId;
    double fee;

    public Payment() {

    }

    //return transactionId. We can have different mode of payment
    public int processPayment(double fee, int ticketId) {
        this.fee = fee;
        this.ticketId = ticketId;
        return new Random().nextInt();
    }
}
