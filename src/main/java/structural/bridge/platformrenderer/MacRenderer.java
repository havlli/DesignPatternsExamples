package structural.bridge.platformrenderer;

public class MacRenderer implements Renderer {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing a circle on Mac with radius " + radius);
    }

    @Override
    public void renderRectangle(float width, float height) {
        System.out.println("Drawing a rectangle on Mac with width " + width);
    }
}
