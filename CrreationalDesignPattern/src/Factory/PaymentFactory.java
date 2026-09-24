package Factory;

public class PaymentFactory {
    public static Payment create(String type){
        if (type.equals("UPI")){
            return new UpiPayment();
        }
        if(type.equals("CASH")){
            return new CashPayment();
        }
        throw new IllegalArgumentException("Payment Invalid");
    }
}
