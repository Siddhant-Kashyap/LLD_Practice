package AbstractFactory;

public class WindowsButton implements Button{
    @Override
    public void render() {
        System.out.println("Rendering Windows Button");
    }

    @Override
    public void click() {
        System.out.println("Clicking Windows Button");
    }
}
