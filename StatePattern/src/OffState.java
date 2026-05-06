public class OffState implements State{
    @Override
    public void pressSwitch(Context context) {
        System.out.println("Turning On");
        context.setState(new OnState());
    }
}
