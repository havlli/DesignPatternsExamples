# Remote Control System
In this example, the `Television` and `Stereo` classes implement the `Device` interface and define their own `turnOn()` and `turnOff()` methods.

The `RemoteControl` class is the invoker and contains four commands that can be set by the client. Each command corresponds to a button on the remote control and is associated with a concrete command instance.

The `Television` and `Stereo` classes are the receivers and represent the electronic devices that can be controlled by the remote control. They have methods that correspond to the actions that can be taken on the devices.

The `Client` class creates the `RemoteControl` instance and associates it with the `Television` and `Stereo` instances. It then uses the invoker to turn the TV and stereo on and off by pressing the corresponding buttons on the remote control.
```java
// Device interface
interface Device {
    void turnOn();
    void turnOff();
}

// Television class
class Television implements Device {
    public void turnOn() {
        System.out.println("Turning on the TV");
    }

    public void turnOff() {
        System.out.println("Turning off the TV");
    }
}

// Stereo class
class Stereo implements Device {
    public void turnOn() {
        System.out.println("Turning on the stereo");
    }

    public void turnOff() {
        System.out.println("Turning off the stereo");
    }
}

// Command interface
interface Command {
    void execute();
}

// Concrete command for turning on the device
class DeviceOnCommand implements Command {
    private Device device;

    public DeviceOnCommand(Device device) {
        this.device = device;
    }

    public void execute() {
        device.turnOn();
    }
}

// Concrete command for turning off the device
class DeviceOffCommand implements Command {
    private Device device;

    public DeviceOffCommand(Device device) {
        this.device = device;
    }

    public void execute() {
        device.turnOff();
    }
}

// Invoker
class RemoteControl {
    private Command onCommand;
    private Command offCommand;

    public void setOnCommand(Command onCommand) {
        this.onCommand = onCommand;
    }

    public void setOffCommand(Command offCommand) {
        this.offCommand = offCommand;
    }

    public void pressOnButton() {
        onCommand.execute();
    }

    public void pressOffButton() {
        offCommand.execute();
    }
}

// Client
public class Client {
    public static void main(String[] args) {
        Device tv = new Television();
        Device stereo = new Stereo();

        Command tvOnCommand = new DeviceOnCommand(tv);
        Command tvOffCommand = new DeviceOffCommand(tv);
        Command stereoOnCommand = new DeviceOnCommand(stereo);
        Command stereoOffCommand = new DeviceOffCommand(stereo);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setOnCommand(tvOnCommand);
        remoteControl.setOffCommand(tvOffCommand);

        remoteControl.pressOnButton();
        remoteControl.pressOffButton();

        remoteControl.setOnCommand(stereoOnCommand);
        remoteControl.setOffCommand(stereoOffCommand);

        remoteControl.pressOnButton();
        remoteControl.pressOffButton();
    }
}
```