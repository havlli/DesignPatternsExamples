# Flyweight Pattern
Flyweight pattern is a structural design pattern that is used to minimize memory usage and improve performance by sharing as much data as possible with similar objects. The key idea behind this pattern is to reuse existing objects instead of creating new ones, which can be costly in terms of memory and processing time.

In the Flyweight pattern, we have a factory class that creates and manages a pool of shared objects. These objects are called flyweights, and they have two states - intrinsic and extrinsic. Intrinsic state is the shared data that is stored within the flyweight, and extrinsic state is the unique data that is passed to the flyweight when it is used.

Here's an example of the Flyweight pattern being used in a real-life scenario:

Let's say you are building a text editor that allows users to format text using different fonts and colors. To do this, the editor needs to create a lot of font and color objects, which can be memory-intensive and time-consuming.

To reduce memory usage and improve performance, you can use the Flyweight pattern. In this case, you would create a factory class that manages a pool of font and color objects. Each object would have an intrinsic state (e.g., font name, color code) that is shared among all instances of that object, and an extrinsic state (e.g., font size, text content) that is unique to each instance.

### Example
Flyweight class that represents a font:
```java
public class Font {
    private final String name;
    private final int size;
    private final boolean bold;
    private final boolean italic;
 
    public Font(String name, int size, boolean bold, boolean italic) {
        this.name = name;
        this.size = size;
        this.bold = bold;
        this.italic = italic;
    }
 
    // getters for intrinsic state
}
```
`Font` class has four properties - `name`, `size`, `bold`, and `italic`. These properties represent the intrinsic state of the font object.

To use the `Font` class in the text editor, you would create a factory class that manages a pool of `Font` objects. When the user selects a font, the factory class would either create a new `Font` object or reuse an existing one from the pool, depending on whether an object with the same intrinsic state already exists.

FontFactory class that manages a pool of `Font` objects:
```java
public class FontFactory {
    private Map<String, Font> fontPool = new HashMap<>();
 
    public Font getFont(String name, int size, boolean bold, boolean italic) {
        String key = name + size + bold + italic;
 
        if (!fontPool.containsKey(key)) {
            Font font = new Font(name, size, bold, italic);
            fontPool.put(key, font);
        }
 
        return fontPool.get(key);
    }
}
```
`FontFactory` class manages a pool of `Font` objects using a HashMap. When the `getFont` method is called with specific intrinsic state properties, the factory checks if an object with the same intrinsic state already exists in the pool. If an object does not exist, the factory creates a new one and adds it to the pool. If an object with the same intrinsic state already exists in the pool, the factory returns that object.

Now, whenever the text editor needs to display text with a specific font, it can request a `Font` object from the `FontFactory` class:
```java
public class TextEditor {
    private FontFactory fontFactory;
 
    public TextEditor() {
        this.fontFactory = new FontFactory();
    }
 
    public void formatText(String text, String fontName, int fontSize, boolean bold, boolean italic) { 
	    Font font = fontFactory.getFont(fontName, fontSize, bold, italic); // apply font to text 
	}
}
```
`TextEditor` class uses the `FontFactory` class to retrieve a `Font` object with the specified intrinsic state properties. The `Font` object can then be applied to the text using the appropriate methods.

By using the Flyweight pattern in this example, the text editor can reuse existing `Font` objects and avoid creating new ones unnecessarily, which can significantly reduce memory usage and improve performance.
