package AbstractFactory;

public class WindowCheckbox implements Checkbox{
    @Override
    public void render() {
        System.out.println("WindowCheckbox rendered");
    }

    @Override
    public void click() {
        System.out.println("Window Checbox clicked");
    }
}
