package behavioral.strategy.sorting;

public class Client {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        SortContext context = new SortContext();

        context.setSortingStrategy(new BubbleSort());
        context.sort(arr);

        context.setSortingStrategy(new MergeSort());
        context.sort(arr);
    }
}
