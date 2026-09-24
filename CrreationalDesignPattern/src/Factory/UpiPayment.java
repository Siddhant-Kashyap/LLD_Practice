package Factory;

public class UpiPayment implements Payment{
    @Override
    public void pay() {
        System.out.println("Paid via UPI");
    }
}
