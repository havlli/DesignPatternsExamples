package structural.bridge.platformrenderer;

public class WindowsRenderer implements Renderer {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing a circle on Windows with radius " + radius);
    }

    @Override
    public void renderRectangle(float width, float height) {
        System.out.println("Drawing a rectangle on Windows with width " + width);
    }
}
