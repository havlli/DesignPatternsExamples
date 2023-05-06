package behavioral.command.remotecontrol;

public class Stereo implements Device {
    @Override
    public void turnOn() {
        System.out.println("Stereo is turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Stereo is turned off");
    }
}
