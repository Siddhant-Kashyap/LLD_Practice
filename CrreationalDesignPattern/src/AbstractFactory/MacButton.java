package AbstractFactory;

public class MacButton implements Button{
    @Override
    public void render() {
        System.out.println("Mac button rendering");
    }

    @Override
    public void click() {
        System.out.println("Mac Button clicked");
    }
}
