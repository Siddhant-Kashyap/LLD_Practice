package Factory;

public class CashPayment implements Payment{
    @Override
    public void pay() {
        System.out.println("Paid by cash");
    }
}
