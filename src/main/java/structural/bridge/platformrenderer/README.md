## Platform Renderer
Let's say we have a Shape interface with methods for drawing and resizing shapes. We also have two concrete implementations of the Shape interface: Circle and Rectangle. We want to be able to draw and resize these shapes on different platforms, such as Windows and Mac, without changing the Shape interface or the concrete classes. Here's how we can use the Bridge pattern to achieve this:

First, we create a separate interface called Renderer for the implementation hierarchy. This interface defines the methods for rendering shapes on different platforms. Here's the Renderer interface:
```java
public interface Renderer {
    void renderCircle(float radius);
    void renderRectangle(float width, float height);
}
```
Next, we create concrete classes for the implementation hierarchy that implement the Renderer interface. Here are two concrete classes for rendering shapes on Windows and Mac platforms:
```java
public class WindowsRenderer implements Renderer {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing a circle on Windows with radius " + radius);
    }

    @Override
    public void renderRectangle(float width, float height) {
        System.out.println("Drawing a rectangle on Windows with width " + width + " and height " + height);
    }
}

public class MacRenderer implements Renderer {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing a circle on Mac with radius " + radius);
    }

    @Override
    public void renderRectangle(float width, float height) {
        System.out.println("Drawing a rectangle on Mac with width " + width + " and height " + height);
    }
}
```
Now, we modify the Shape interface to take an instance of the Renderer interface in its constructor, instead of implementing the rendering methods directly. Here's the updated Shape interface:
```java
public abstract class Shape {
    protected Renderer renderer;

    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract void draw();
    public abstract void resize(float factor);
}
```
Finally, we create concrete classes for the Shape interface that use the Renderer interface to draw and resize shapes on different platforms. Here are the concrete Circle and Rectangle classes that use the Renderer interface to render shapes:
```java
public class Circle extends Shape {
    private float radius;

    public Circle(float radius, Renderer renderer) {
        super(renderer);
        this.radius = radius;
    }

    @Override
    public void draw() {
        renderer.renderCircle(radius);
    }

    @Override
    public void resize(float factor) {
        radius *= factor;
    }
}

public class Rectangle extends Shape {
    private float width;
    private float height;

    public Rectangle(float width, float height, Renderer renderer) {
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
```
Now we can create instances of Circle and Rectangle classes with different Renderer implementations, like this:
```java
Renderer windowsRenderer = new WindowsRenderer();
Renderer macRenderer = new MacRenderer();

Circle circleOnWindows = new Circle(5, windowsRenderer);
circleOnWindows.draw();
circleOnWindows.resize(2);

Rectangle rectangleOnMac = new Rectangle(10, 20, macRenderer);
rectangleOnMac.draw();
rectangleOnMac.resize(0.5f);
```
This allows us to draw and resize shapes on different platforms without modifying the Shape interface or the concrete classes, thanks to the Bridge pattern.