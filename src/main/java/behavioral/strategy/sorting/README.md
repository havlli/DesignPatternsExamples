# Sorting Strategy
In the case of sorting algorithms, we can define a strategy interface called `SortingStrategy` that contains a method `sort` to perform the sorting operation. Then, we can have multiple classes that implement this interface, each one implementing a different sorting algorithm.
```java
// Strategy interface
public interface SortingStrategy {
    public void sort(int[] arr);
}

// Concrete strategy implementation for bubble sort
public class BubbleSort implements SortingStrategy {
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("Array sorted using bubble sort.");
    }
}

// Concrete strategy implementation for merge sort
public class MergeSort implements SortingStrategy {
    public void sort(int[] arr) {
        // implementation of merge sort algorithm
        System.out.println("Array sorted using merge sort.");
    }
}

// Context class that uses the strategy
public class SortContext {
    private SortingStrategy sortingStrategy;

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void sort(int[] arr) {
        sortingStrategy.sort(arr);
    }
}

// Usage example
public class SortingProgram {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        SortContext context = new SortContext();

        // Use bubble sort strategy
        context.setSortingStrategy(new BubbleSort());
        context.sort(arr);

        // Use merge sort strategy
        context.setSortingStrategy(new MergeSort());
        context.sort(arr);
    }
}
```
In this example, the `SortingStrategy` interface defines the `sort` method that each concrete strategy class must implement. The `BubbleSort` and `MergeSort` classes implement this interface and provide their own implementations of the sorting algorithm.

The `SortContext` class acts as the context in which the strategy is used. It has a reference to the current sorting strategy and uses it to perform the sort operation on an array of integers.

Finally, the `SortingProgram` class demonstrates how to use the `SortContext` with different sorting strategies. In this case, we use both `BubbleSort` and `MergeSort` to sort the same array of integers.