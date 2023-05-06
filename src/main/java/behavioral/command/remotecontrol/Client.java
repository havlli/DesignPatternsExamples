package behavioral.command.remotecontrol;

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
