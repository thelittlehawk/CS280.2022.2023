package ba.edu.ssst;

public class Computer {
    private String name;
    
    private IData usbStick;

    public Computer(String name) {
        this.name = name;
    }

    public void plugInUSB(IData usbStick) {
        this.usbStick = usbStick;
    }
}
