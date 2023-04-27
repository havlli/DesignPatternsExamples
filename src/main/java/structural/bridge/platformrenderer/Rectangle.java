package structural.bridge.platformrenderer;

public class Rectangle extends Shape {
    private float width;
    private float height;

    public Rectangle(Renderer renderer, float width, float height) {
        super(renderer);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        renderer.renderRectangle(width, height);
    }

    @Override
    public void resize(float factor) {
        width *= factor;
        height *= factor;
    }
}
