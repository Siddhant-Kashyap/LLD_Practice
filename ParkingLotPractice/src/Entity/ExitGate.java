package Entity;

import Services.PaymentService;

public class ExitGate {
    private int gateNo ;
    private final PaymentService paymentService;
    public ExitGate(int gateNo, PaymentService paymentService){
        this.gateNo=gateNo;
        this.paymentService = paymentService;
    }

    public void  exit(){
        double finalPrice = paymentService.amount();
        System.out.println("Your Final amount is :---> "+ finalPrice);
        System.out.println("Thank You for Visiting");
    }

}
