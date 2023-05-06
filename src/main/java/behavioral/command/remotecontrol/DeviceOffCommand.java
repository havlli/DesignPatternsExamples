package behavioral.command.remotecontrol;

public class DeviceOffCommand implements Command {
    private Device device;

    public DeviceOffCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOff();
    }
}
