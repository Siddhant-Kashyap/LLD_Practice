package AbstractFactory;

public class MacCheckBox implements Checkbox{
    @Override
    public void render() {
        System.out.println("Mac checkbox Rendered");
    }

    @Override
    public void click() {
        System.out.println("Mac check box Clicked ");
    }
}
