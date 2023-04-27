package structural.bridge.platformrenderer;

public class Client {

    public static void main(String[] args) {

        Renderer windowsRenderer = new WindowsRenderer();
        Circle circleOnWindows = new Circle(windowsRenderer, 5);
        circleOnWindows.draw();
        circleOnWindows.resize(5);
        circleOnWindows.draw();

        Renderer macRenderer = new MacRenderer();
        Rectangle rectangleOnMac = new Rectangle(macRenderer, 5, 5);
        rectangleOnMac.draw();
        rectangleOnMac.resize(3);
        rectangleOnMac.draw();
    }
}
