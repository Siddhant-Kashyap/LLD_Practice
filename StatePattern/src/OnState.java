public class OnState implements State{
    @Override
    public void pressSwitch(Context context) {
        System.out.println("Turning off");
        context.setState(new OffState());
    }
}
