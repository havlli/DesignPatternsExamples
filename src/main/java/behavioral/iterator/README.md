# Iterator
The Iterator design pattern provides a way to access the elements of an aggregate object sequentially, without exposing the underlying implementation of the object. It decouples the algorithm for iterating over the elements from the actual structure of the elements. This allows the client code to work with different types of collections or aggregate objects, without having to modify the code for the iteration algorithm.

The Iterator pattern typically consists of three components:

1.  The `Iterator` interface, which defines the methods for accessing the elements of the aggregate object.
2.  The `ConcreteIterator` class, which implements the Iterator interface and provides the implementation for iterating over the elements.
3.  The `Aggregate` interface, which defines the methods for creating an Iterator object.

The following are the typical operations of an iterator:

1.  Accessing the next element in the collection.
2.  Checking whether there are more elements to be accessed.
3.  Removing the current element (optional operation).

Examples of collections that can be iterated using the Iterator pattern include arrays, lists, maps, trees, and sets.

The Iterator pattern promotes encapsulation and separation of concerns, as it separates the traversal algorithm from the collection data structure. This makes the code more modular, reusable, and easier to maintain.

### Example
```java
// Iterator interface
public interface Iterator<T> {
    boolean hasNext();
    T next();
}

// Concrete Iterator class
public class ListIterator<T> implements Iterator<T> {
    private List<T> list;
    private int index;

    public ListIterator(List<T> list) {
        this.list = list;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public T next() {
        T item = list.get(index);
        index++;
        return item;
    }
}

// Aggregate interface
public interface Aggregate<T> {
    Iterator<T> iterator();
}

// Concrete Aggregate class
public class ListAggregate<T> implements Aggregate<T> {
    private List<T> list;

    public ListAggregate(List<T> list) {
        this.list = list;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<T>(list);
    }
}

// Client code
public class Client {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");

        Aggregate<String> aggregate = new ListAggregate<>(list);
        Iterator<String> iterator = aggregate.iterator();

        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println(item);
        }
    }
}
```
In this example, we have an `Iterator` interface with two methods: `hasNext` and `next`. We also have a concrete `ListIterator` class that implements the `Iterator` interface and iterates over a `List` of items.

We also have an `Aggregate` interface that defines a method for creating an `Iterator`, and a concrete `ListAggregate` class that implements the `Aggregate` interface and creates a `ListIterator` instance.

Finally, we have a client class that creates a `List` of strings, creates a `ListAggregate` instance, and uses the iterator to iterate over the list and print each item.

This is just one example of how the Iterator pattern can be implemented in Java. The pattern can be used in many different situations where you need to iterate over a collection of objects without exposing the collection's internal structure.